package com.seanshubin.learn.spark.core

import org.apache.spark.rdd.RDD

class ResilientDistributedDatasetLoaderImpl(sparkContextLifecycle: SparkContextLifecycle) extends ResilientDistributedDatasetLoader {
  override def loadFromPathPattern(pathPattern: String): RDD[String] = {
    val dataset = sparkContextLifecycle.sparkContext.textFile(pathPattern)
    dataset
  }
}
