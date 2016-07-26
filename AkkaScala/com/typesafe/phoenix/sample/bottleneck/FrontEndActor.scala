/*
 * Copyright © 2015 Typesafe, Inc. All rights reserved.
 * No information contained herein may be reproduced or transmitted in any form
 * or by any means without the express written permission of Typesafe, Inc.
 */

package com.typesafe.phoenix.sample.bottleneck

import akka.actor.{ ActorRef, Props, Actor, ActorLogging }
import com.typesafe.cinnamon.akka.Tracer

import scala.util.Random

class FrontEndActor(databaseRouterActor: ActorRef) extends Actor with ActorLogging {
  // Each FEA will have its own BLA
  val businessLogicActor = context.actorOf(BusinessLogicActor.props(databaseRouterActor))

  def receive = {
    case req: FrontEndRouterActor.Request =>
      context.actorOf(TransactionActor.props(businessLogicActor)) ! req
  }
}

object FrontEndActor {
  def props(databaseRouterActor: ActorRef) = Props(new FrontEndActor(databaseRouterActor))
}

class TransactionActor(businessLogicActor: ActorRef) extends Actor with ActorLogging {
  import TransactionActor._
  def receive = {
    case req: FrontEndRouterActor.Request =>
      Tracer(context.system).start(transactionName) {
        businessLogicActor ! BusinessLogicActor.BusinessLogic
      }
    case Done =>
      // Transaction is done - in a real app we would just return the result to the client here
      Tracer(context.system).end(transactionName)
      context.stop(self)
  }
}

object TransactionActor {
  def props(businessLogicActor: ActorRef) = Props(new TransactionActor(businessLogicActor))
  case object Done
  val transactionName = "roundTripTime"
}
