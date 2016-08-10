package com.seanshubin.learn.spark.core

import org.scalatest.FunSuite
import org.scalatest.mock.EasyMockSugar

class WordCounterTest extends FunSuite with EasyMockSugar {
  test("histogram") {
    val sparkContext = SparkContextForIntegrationTests.sparkContext
    val sampleLines = Seq(
      "aaa bab cad beb",
      "beb cad bab aaa",
      "cad aaa bab aaa"
    )
    val expected = Seq(("aaa", 4), ("bab", 3), ("cad", 3))
    val sampleDataset = sparkContext.parallelize(sampleLines)
    val pathSpecification = "path specification"
    val resilientDistributedDatasetLoader = mock[ResilientDistributedDatasetLoader]
    val lineEmitter = new FakeLineEmitter
    val notifications = new LineEmittingNotifications(lineEmitter.apply)
    val wordCounter = new WordCounterImpl(pathSpecification, resilientDistributedDatasetLoader, notifications)

    expecting {
      resilientDistributedDatasetLoader.loadFromPathPattern("path specification").andReturn(sampleDataset)
    }

    whenExecuting(resilientDistributedDatasetLoader) {
      val actual = wordCounter.calculateWordHistogram()
      assert(actual === expected)
    }
  }
}
