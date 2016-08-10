package com.seanshubin.learn.spark.core

import org.scalatest.FunSuite


class RunnerTest extends FunSuite {
  test("runner") {
    //given
    val sampleDataGenerator = new SampleDataGeneratorStub
    val histogram = Seq("aaa" -> 3)
    val wordCounter = new WordCounterStub(histogram)
    val fakeLineEmitter = new FakeLineEmitter
    val notifications: Notifications = new LineEmittingNotifications(fakeLineEmitter.apply)
    val thirdPartyLogging = new ThirdPartyLoggingStub
    val runner: Runner = new RunnerImpl(sampleDataGenerator, wordCounter, notifications, thirdPartyLogging)

    //when
    runner.run()

    //then
    assert(thirdPartyLogging.invocationCount === 1)
    assert(sampleDataGenerator.invocationCount === 1)
    assert(wordCounter.invocationCount === 1)
    assert(fakeLineEmitter.lines === Seq("", "histogram:", "  aaa -> 3"))
  }
}
