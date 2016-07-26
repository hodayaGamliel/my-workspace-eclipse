/*
 * Copyright © 2015 Typesafe, Inc. All rights reserved.
 * No information contained herein may be reproduced or transmitted in any form
 * or by any means without the express written permission of Typesafe, Inc.
 */

package com.typesafe.phoenix.sample.bottleneck

import akka.actor.ActorSystem

import scala.Console._

/**
 * Demo that can be used to simulate bottlenecks in an Akka application.
 *
 * The structure of the application is like follows.
 *
 * ControllerActor
 * Loads the application via bursts and sends signals to the database actor(s) when it should simulate slow response or connection timeout.
 * Burst size, latency, slow db percentage and db connection timeout percentage can be configured in application.conf
 *
 * FrontEndRouterActor
 * Routes to 5 FrontEndActors with a round robin strategy.
 *
 * FrontEndActor
 * Simulates the endpoint of a traditional web app. Creates a transaction actor for each call.
 *
 * TransactionActor
 * Carries any context specific information throughout the application and is responsible for the response to the client.
 * Since this is a simulation the TA does not reply but rather just stops itself when it's "done".
 * The transaction timeout, called "roundTripTime", can be set in the application.conf file.
 *
 * BusinessLogicActor
 * Simulates configured processing time and thereafter forwards to the database router actor.
 *
 * DatabaseRouterActor
 * Routes to 10 DatabaseActors with a round robin strategy.
 *
 * DatabaseActor
 * Simulates database work via some configuration settings.
 * It currently has three modes:
 * - standard operation
 * - slow operation
 * - connection timeout
 *
 * All latencies + timeouts can be configured in the application.conf file.
 *
 * Further improvement suggestions:
 * - divide segments of actors into their separate dispatchers
 * - use Akka Http to open up for external loading mechanism
 */
object BottleneckDemo {
  def main(args: Array[String]): Unit = run()

  def run(): Unit = {
    val system = ActorSystem("BottleneckSample")
    println(BLUE + "Press enter to exit ..." + RESET)
    val controller = system.actorOf(ControllerActor.props, "controller")
    controller ! ControllerActor.Initiate
    System.in.read()
    system.shutdown()
  }
}

