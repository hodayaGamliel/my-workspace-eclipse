/*
 * Copyright © 2015 Typesafe, Inc. All rights reserved.
 * No information contained herein may be reproduced or transmitted in any form
 * or by any means without the express written permission of Typesafe, Inc.
 */

package com.typesafe.phoenix.sample.bottleneck

import scala.util.Random

object Util {
  val random = new Random

  def randomWithin(min: Long, max: Long): Long = min + random.nextInt((max - min).toInt)
}
