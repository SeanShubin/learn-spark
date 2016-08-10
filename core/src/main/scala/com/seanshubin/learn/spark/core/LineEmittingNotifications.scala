package com.seanshubin.learn.spark.core

class LineEmittingNotifications(emitLine:String => Unit) extends Notifications {
  override def describeCalculation(description: String): Unit = {
    emitLine(description)
  }

  override def generateReport(histogram: Seq[(String, Int)]): Unit = {
    val histogramLines = for {
      (key, value) <- histogram
    } yield {
      s"  $key -> $value"
    }
    emitLine("")
    emitLine("histogram:")
    histogramLines.foreach(emitLine)
  }
}
