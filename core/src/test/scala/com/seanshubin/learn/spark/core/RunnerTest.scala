package com.seanshubin.learn.spark.core

import org.scalatest.FunSuite
import org.scalatest.mock.EasyMockSugar

class RunnerTest extends FunSuite with EasyMockSugar {
  test("runner") {
    val sampleDataGenerator: SampleDataGenerator = mock[SampleDataGenerator]
    val wordCounter: WordCounter = mock[WordCounter]
    val notifications: Notifications = mock[Notifications]
    val thirdPartyLogging: ThirdPartyLogging = mock[ThirdPartyLogging]
    val runner: Runner = new RunnerImpl(sampleDataGenerator, wordCounter, notifications, thirdPartyLogging)
    val histogram = Seq("aaa" -> 3)
    expecting {
      thirdPartyLogging.silenceAllLoggers()
      sampleDataGenerator.generate()
      wordCounter.calculateWordHistogram().andReturn(histogram)
      notifications.generateReport(histogram)
    }
    whenExecuting(sampleDataGenerator, wordCounter, notifications) {
      runner.run()
    }
  }
}
