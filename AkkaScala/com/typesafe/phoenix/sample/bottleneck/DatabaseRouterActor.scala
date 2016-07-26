/*
 * Copyright © 2015 Typesafe, Inc. All rights reserved.
 * No information contained herein may be reproduced or transmitted in any form
 * or by any means without the express written permission of Typesafe, Inc.
 */

package com.typesafe.phoenix.sample.bottleneck

import akka.actor.{ ActorRef, Props, ActorLogging, Actor }
import akka.routing.{ RoundRobinRoutingLogic, Router, ActorRefRoutee }

class DatabaseRouterActor extends Actor with ActorLogging {
  import DatabaseRouterActor._

  var router = {
    val routees = Vector.fill(10) {
      val r = context.actorOf(DatabaseActor.props)
      context watch r
      ActorRefRoutee(r)
    }
    Router(RoundRobinRoutingLogic(), routees)
  }

  val numberRoutees = router.routees.toVector.size

  def receive = {
    case dbr: DatabaseRequest =>
      router.route(dbr, sender)
    case ssd @ SimulateSlowDatabase(numberOfActors) =>
      sendToRoutees(numberOfActors, ssd, sender)
    case sndc @ SimulateDatabaseConnectionTimeout(numberOfActors) =>
      sendToRoutees(numberOfActors, sndc, sender)
  }

  def sendToRoutees[T](number: Int, payload: T, sender: ActorRef): Unit = {
    if (number == 0 || number >= numberRoutees) router.routees foreach { _.send(payload, sender) }
    else 1 to number foreach { n => router.route(payload, sender) }
  }
}

object DatabaseRouterActor {
  def props = Props[DatabaseRouterActor]
  // Use 0 for all db actors
  case class SimulateSlowDatabase(numberOfActors: Int = 0)
  // Use 0 for all db actors
  case class SimulateDatabaseConnectionTimeout(numberOfActors: Int = 0)
  case class DatabaseRequest(request: String, transactionActor: ActorRef)
  case class DatabaseResponse(response: String, transactionActor: ActorRef)

}