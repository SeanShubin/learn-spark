package com.seanshubin.learn.spark.core

class WordCounterStub(histogram: Seq[(String, Int)]) extends WordCounter {
  var invocationCount = 0

  override def calculateWordHistogram(): Seq[(String, Int)] = {
    invocationCount += 1
    histogram
  }
}
