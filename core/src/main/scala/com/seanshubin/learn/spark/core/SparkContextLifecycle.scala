package com.seanshubin.learn.spark.core

import org.apache.spark.SparkContext

trait SparkContextLifecycle {
  def sparkContext: SparkContext
}
