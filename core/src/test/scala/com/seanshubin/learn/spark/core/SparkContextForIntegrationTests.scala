package com.seanshubin.learn.spark.core

import org.apache.spark.{SparkConf, SparkContext}

object SparkContextForIntegrationTests {
  val sparkConfig: SparkConf = new SparkConf().setAppName("Integration Test").setMaster("local")
  val sparkContext: SparkContext = new SparkContext(sparkConfig)
}
