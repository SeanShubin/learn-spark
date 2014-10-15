package com.seanshubin.learn.spark.core

class FakeRandom(values: Int*) extends Random {
  var currentIndex = 0

  override def nextInt(upperExclusive: Int): Int = {
    val result = values(currentIndex)
    currentIndex += 1
    if (currentIndex >= values.size) currentIndex = 0
    result
  }
}
