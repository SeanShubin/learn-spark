package com.seanshubin.learn.spark.core

import org.apache.spark.{SparkConf, SparkContext}
import org.scalatest.FunSuite
import org.scalatest.mock.EasyMockSugar

class WordCounterTest extends FunSuite with EasyMockSugar {
  test("histogram") {
    val conf = new SparkConf().setAppName("Simple Application").setMaster("local")
    val sparkContext = new SparkContext(conf)
    val sampleLines = Seq(
      "aaa bab cad beb",
      "beb cad bab aaa",
      "cad aaa bab aaa"
    )
    val expected = Seq(("aaa", 4), ("bab", 3), ("cad", 3))
    val sampleRdd = sparkContext.parallelize(sampleLines)
    val pathSpecification = "path specification"
    val resilientDistributedDatasetLoader = mock[ResilientDistributedDatasetLoader]
    val wordCounter = new WordCounterImpl(pathSpecification, resilientDistributedDatasetLoader)

    expecting {
      resilientDistributedDatasetLoader.loadFromPathPattern("path specification").andReturn(sampleRdd)
    }

    whenExecuting(resilientDistributedDatasetLoader) {
      val actual = wordCounter.calculateWordHistogram()
      assert(actual === expected)
    }
  }
}
