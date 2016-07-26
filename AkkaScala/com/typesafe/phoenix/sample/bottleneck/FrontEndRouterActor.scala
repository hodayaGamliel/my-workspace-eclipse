/*
 * Copyright © 2015 Typesafe, Inc. All rights reserved.
 * No information contained herein may be reproduced or transmitted in any form
 * or by any means without the express written permission of Typesafe, Inc.
 */

package com.typesafe.phoenix.sample.bottleneck

import akka.actor.{ ActorRef, Props, ActorLogging, Actor }
import akka.routing.{ RoundRobinRoutingLogic, Router, ActorRefRoutee }

class FrontEndRouterActor(databaseRouterActor: ActorRef) extends Actor with ActorLogging {
  import FrontEndRouterActor._

  var router = {
    val routees = Vector.fill(5) {
      val r = context.actorOf(FrontEndActor.props(databaseRouterActor))
      context watch r
      ActorRefRoutee(r)
    }
    Router(RoundRobinRoutingLogic(), routees)
  }

  def receive = {
    case req: Request => router.route(req, sender)
  }
}

object FrontEndRouterActor {
  def props(databaseRouterActor: ActorRef) = Props(new FrontEndRouterActor(databaseRouterActor))
  case class Request(user: String, payload: String)
}