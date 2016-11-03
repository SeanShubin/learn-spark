package com.seanshubin.learn.spark.core

import org.apache.log4j.{Level, LogManager, Logger}

import scala.collection.JavaConverters._

class ThirdPartyLoggingImpl extends ThirdPartyLogging {
  override def silenceAllLoggers(): Unit = {
//    val rootLogger: Logger = LogManager.getRootLogger
//    val untypedLoggers = LogManager.getCurrentLoggers.asScala.toSeq
//    val typedLoggers = untypedLoggers.map(logger => logger.asInstanceOf[Logger])
//    val loggers: Seq[Logger] = rootLogger +: typedLoggers
//    def shutLoggerOff(logger: Logger): Unit = {
//      logger.setLevel(Level.OFF)
//    }
//    loggers.foreach(shutLoggerOff)
  }
}
