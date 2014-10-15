package com.seanshubin.learn.spark.core

import org.apache.spark.{SparkConf, SparkContext}

class SparkContextLifecycleImpl(appName: String, master: String) extends SparkContextLifecycle {
  lazy val sparkConfig: SparkConf = new SparkConf().setAppName(appName).setMaster(master)
  override lazy val sparkContext: SparkContext = new SparkContext(sparkConfig)
}
