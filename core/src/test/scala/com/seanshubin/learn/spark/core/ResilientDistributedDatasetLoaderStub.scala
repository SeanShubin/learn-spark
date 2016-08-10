package com.seanshubin.learn.spark.core

import org.apache.spark.rdd.RDD

class ResilientDistributedDatasetLoaderStub(results: Map[String, Seq[String]]) extends ResilientDistributedDatasetLoader {
  val sparkContext = SparkContextForIntegrationTests.sparkContext

  override def loadFromPathPattern(pathPattern: String): RDD[String] = {
    val lines = results(pathPattern)
    val dataset = sparkContext.parallelize(lines)
    dataset
  }
}
