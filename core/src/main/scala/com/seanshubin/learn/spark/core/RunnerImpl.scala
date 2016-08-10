package com.seanshubin.learn.spark.core

class RunnerImpl(sampleDataGenerator: SampleDataGenerator,
                 wordCounter: WordCounter,
                 notifications:Notifications,
                 thirdPartyLogging: ThirdPartyLogging) extends Runner {
  override def run(): Unit = {
    thirdPartyLogging.silenceAllLoggers()
    sampleDataGenerator.generate()
    val histogram = wordCounter.calculateWordHistogram()
    notifications.generateReport(histogram)
  }
}
