/*
 * Copyright © 2015 Typesafe, Inc. All rights reserved.
 * No information contained herein may be reproduced or transmitted in any form
 * or by any means without the express written permission of Typesafe, Inc.
 */

package com.typesafe.phoenix.sample.bottleneck

import java.util.concurrent.TimeUnit

import akka.actor.{ ActorRef, Props, ActorLogging, Actor }

import scala.util.Random

class BusinessLogicActor(databaseRouterActor: ActorRef) extends Actor with ActorLogging {
  import BusinessLogicActor._

  val minProcessingTime = context.system.settings.config.getDuration("bottleneck.business-logic-layer.min-processing-time", TimeUnit.MILLISECONDS)
  val maxProcessingTime = context.system.settings.config.getDuration("bottleneck.business-logic-layer.max-processing-time", TimeUnit.MILLISECONDS)

  def receive = {
    case BusinessLogic =>
      if (minProcessingTime > 0)
        Thread.sleep(Util.randomWithin(minProcessingTime, maxProcessingTime))
      databaseRouterActor ! DatabaseRouterActor.DatabaseRequest("some query", sender)
    case DatabaseRouterActor.DatabaseResponse(response, transactionActor) =>
      transactionActor ! TransactionActor.Done

  }
}

object BusinessLogicActor {
  def props(databaseRouterActor: ActorRef) = Props(new BusinessLogicActor(databaseRouterActor))
  case object BusinessLogic
}