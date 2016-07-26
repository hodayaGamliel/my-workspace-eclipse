/*
 * Copyright © 2015 Typesafe, Inc. All rights reserved.
 * No information contained herein may be reproduced or transmitted in any form
 * or by any means without the express written permission of Typesafe, Inc.
 */

package com.typesafe.phoenix.sample.bottleneck

import java.util.concurrent.TimeUnit

import akka.actor.{ Props, ActorLogging, Actor }

import scala.util.Random

class ControllerActor extends Actor with ActorLogging {
  import ControllerActor._

  // Create database and frontend routers since we only want one of those
  val databaseRouterActor = context.actorOf(DatabaseRouterActor.props)
  val frontEndRouterActor = context.actorOf(FrontEndRouterActor.props(databaseRouterActor))

  // Settings for system behavior
  val minBurstNumber = context.system.settings.config.getInt("bottleneck.controller.min-burst-number")
  val maxBurstNumber = context.system.settings.config.getInt("bottleneck.controller.max-burst-number")
  val minBurstWaitTime = context.system.settings.config.getDuration("bottleneck.controller.min-burst-wait-time", TimeUnit.MILLISECONDS)
  val maxBurstWaitTime = context.system.settings.config.getDuration("bottleneck.controller.max-burst-wait-time", TimeUnit.MILLISECONDS)
  val percentageSlowDatabase = context.system.settings.config.getDouble("bottleneck.controller.percentage-slow-database")
  val percentageConnectionTimeout = context.system.settings.config.getDouble("bottleneck.controller.percentage-connection-timeout")

  def receive = {
    case SendBurst =>
      val upper = Util.randomWithin(minBurstNumber, maxBurstNumber).toInt
      1 to upper foreach { n =>
        frontEndRouterActor ! FrontEndRouterActor.Request(s"User$n", s"Payload$n")
        if (minBurstWaitTime > 0) Thread.sleep(Util.randomWithin(minBurstWaitTime, maxBurstWaitTime))
      }
      nextOperation()
    case SlowDatabase =>
      databaseRouterActor ! DatabaseRouterActor.SimulateSlowDatabase()
    case ConnectionTimeout =>
      databaseRouterActor ! DatabaseRouterActor.SimulateDatabaseConnectionTimeout()
    case Initiate =>
      nextOperation()
  }

  def nextOperation() = {
    val r = random.nextDouble() * 100
    if (r <= percentageConnectionTimeout) self ! ConnectionTimeout
    if (r <= percentageSlowDatabase) self ! SlowDatabase
    self ! SendBurst
  }
}

object ControllerActor {
  def props = Props[ControllerActor]
  val random = new Random()
  case object Initiate
  case object SendBurst
  case object SlowDatabase
  case object ConnectionTimeout
}
