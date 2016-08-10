package com.seanshubin.learn.spark.core

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD

class ResilientDistributedDatasetLoaderImpl(sparkContext: SparkContext) extends ResilientDistributedDatasetLoader {
  override def loadFromPathPattern(pathPattern: String): RDD[String] = {
    val dataset = sparkContext.textFile(pathPattern)
    dataset
  }
}
