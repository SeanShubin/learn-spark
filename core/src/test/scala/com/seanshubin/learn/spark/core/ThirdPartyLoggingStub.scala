package com.seanshubin.learn.spark.core

class ThirdPartyLoggingStub extends ThirdPartyLogging {
  var invocationCount = 0

  override def silenceAllLoggers(): Unit = invocationCount += 1
}
