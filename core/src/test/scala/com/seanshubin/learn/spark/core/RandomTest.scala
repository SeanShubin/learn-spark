package com.seanshubin.learn.spark.core

import org.scalatest.FunSuite

class RandomTest extends FunSuite {
  test("generates variety of numbers") {
    val random: Random = new RandomImpl(123456)
    assert(random.nextInt(10) == 3)
    assert(random.nextInt(10) == 7)
    assert(random.nextInt(10) == 7)
  }

}
