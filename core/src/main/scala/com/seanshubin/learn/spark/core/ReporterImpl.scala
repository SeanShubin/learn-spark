package com.seanshubin.learn.spark.core

class ReporterImpl(emitLine: String => Unit) extends Reporter {
  override def generateReport(histogram: Seq[(String, Int)]): Unit = {
    for {
      (key, value) <- histogram
    } {
      val line = s"$key -> $value"
      emitLine(line)
    }
  }
}
