package com.seanshubin.learn.spark.core

trait WordCounter {
  def calculateWordHistogram(): Seq[(String, Int)]
}
