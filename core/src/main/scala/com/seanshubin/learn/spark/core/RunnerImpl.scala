package com.seanshubin.learn.spark.core

class RunnerImpl(sampleDataGenerator: SampleDataGenerator,
                 wordCounter: WordCounter,
                 reporter: Reporter,
                 thirdPartyLogging: ThirdPartyLogging) extends Runner {
  override def run(): Unit = {
    thirdPartyLogging.silenceAllLoggers()
    sampleDataGenerator.generate()
    val histogram = wordCounter.calculateWordHistogram()
    reporter.generateReport(histogram)
  }
}
