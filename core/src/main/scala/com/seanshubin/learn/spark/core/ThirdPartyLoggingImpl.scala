package com.seanshubin.learn.spark.core

class ThirdPartyLoggingImpl extends ThirdPartyLogging {
  override def silenceAllLoggers(): Unit = {
    //    val rootLogger: Logger = LogManager.getRootLogger
    //    val untypedLoggers = JavaConversions.enumerationAsScalaIterator(LogManager.getCurrentLoggers).toSeq
    //    val typedLoggers = untypedLoggers.map(logger => logger.asInstanceOf[Logger])
    //    val loggers: Seq[Logger] = rootLogger +: typedLoggers
    //    def shutLoggerOff(logger: Logger): Unit = {
    //      logger.setLevel(Level.OFF)
    //    }
    //    loggers.foreach(shutLoggerOff)
  }
}
