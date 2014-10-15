package com.seanshubin.learn.spark.core

trait Reporter {
  def generateReport(histogram: Seq[(String, Int)])
}
