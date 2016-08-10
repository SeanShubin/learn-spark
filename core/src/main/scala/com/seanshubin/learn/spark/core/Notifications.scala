package com.seanshubin.learn.spark.core

trait Notifications {
  def describeCalculation(description:String):Unit
  def generateReport(histogram: Seq[(String, Int)]): Unit
}
