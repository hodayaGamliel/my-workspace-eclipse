/*
 * Copyright © 2015 Typesafe, Inc. All rights reserved.
 * No information contained herein may be reproduced or transmitted in any form
 * or by any means without the express written permission of Typesafe, Inc.
 */

package com.typesafe.phoenix.sample.bottleneck

import java.util.concurrent.TimeUnit

import akka.actor.{ ActorRef, Props, ActorLogging, Actor }
import scala.concurrent.ExecutionContext.Implicits.global

import scala.concurrent.duration.Duration
import scala.util.Random

class DatabaseActor extends Actor with ActorLogging {
  import DatabaseActor._

  val minExecutionTimeInMillis = context.system.settings.config.getDuration("bottleneck.database.min-execution-time", TimeUnit.MILLISECONDS)
  val maxExecutionTimeInMillis = context.system.settings.config.getDuration("bottleneck.database.max-execution-time", TimeUnit.MILLISECONDS)
  val minSlowExecutionTimeInMillis = context.system.settings.config.getDuration("bottleneck.database.min-slow-execution-time", TimeUnit.MILLISECONDS)
  val maxSlowExecutionTimeInMillis = context.system.settings.config.getDuration("bottleneck.database.max-slow-execution-time", TimeUnit.MILLISECONDS)
  val slowConnectionInMillis = context.system.settings.config.getDuration("bottleneck.database.slow-database-duration", TimeUnit.MILLISECONDS)
  val slowConnectionDuration = Duration.create(slowConnectionInMillis, TimeUnit.MILLISECONDS)
  val connectionTimeoutInMillis = context.system.settings.config.getDuration("bottleneck.database.connection-timeout", TimeUnit.MILLISECONDS)

  var minTime = minExecutionTimeInMillis
  var maxTime = maxExecutionTimeInMillis

  def receive = {
    case DatabaseRouterActor.DatabaseRequest(req, transactionActor) =>
      println("dsdsds")
    case DatabaseRouterActor.SimulateSlowDatabase(_) =>
      println("dsdsds")
    case DatabaseRouterActor.SimulateDatabaseConnectionTimeout(_) =>
      try {
        Thread.sleep(connectionTimeoutInMillis)
        throw new DatabaseConnectionTimeout(s"Database timeout after $connectionTimeoutInMillis millis")
      } catch {
        case _: Exception => // ignore
      }
    //     case ControllerActor.Reset => sender ! ControllerActor.Initiate
  }

}

object DatabaseActor {
  def props = Props[DatabaseActor]
  case object StandardDatabaseOperation
}
