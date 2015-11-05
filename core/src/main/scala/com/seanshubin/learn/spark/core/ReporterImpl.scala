package com.seanshubin.learn.spark.core

class ReporterImpl(emitLine: String => Unit) extends Reporter {
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
