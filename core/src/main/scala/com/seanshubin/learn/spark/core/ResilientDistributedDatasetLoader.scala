package com.seanshubin.learn.spark.core

import org.apache.spark.rdd.RDD

trait ResilientDistributedDatasetLoader {
  def loadFromPathPattern(pathPattern: String): RDD[String]
}
