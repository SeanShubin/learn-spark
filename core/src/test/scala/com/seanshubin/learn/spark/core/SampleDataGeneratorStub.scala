package com.seanshubin.learn.spark.core

class SampleDataGeneratorStub extends SampleDataGenerator {
  var invocationCount = 0

  override def generate(): Unit = invocationCount += 1
}
