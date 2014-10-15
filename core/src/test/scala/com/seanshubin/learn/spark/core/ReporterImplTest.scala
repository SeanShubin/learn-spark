package com.seanshubin.learn.spark.core

import org.scalatest.FunSuite

class ReporterImplTest extends FunSuite {
  test("reporter") {
    val lineEmitter = new FakeLineEmitter
    val reporter: Reporter = new ReporterImpl(lineEmitter.apply)
    val histogram = Seq("a" -> 1, "b" -> 2, "c" -> 3)
    reporter.generateReport(histogram)
    assert(lineEmitter.lines === Seq("a -> 1", "b -> 2", "c -> 3"))
  }
}
