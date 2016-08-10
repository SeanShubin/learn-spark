package com.seanshubin.learn.spark.core

import java.io.{StringWriter, Writer}

class FakeStringWriter extends Writer {
  val stringWriter = new StringWriter
  var closeCount = 0

  override def write(cbuf: Array[Char], off: Int, len: Int): Unit = stringWriter.write(cbuf, off, len)

  override def flush(): Unit = stringWriter.flush()

  override def toString: String = stringWriter.toString

  def close(): Unit = {
    closeCount += 1
  }

  def toLines: Seq[String] = toString.split("\r\n|\r|\n").toSeq
}
