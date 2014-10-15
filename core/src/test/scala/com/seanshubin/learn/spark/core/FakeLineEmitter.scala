package com.seanshubin.learn.spark.core

import scala.collection.mutable.ArrayBuffer

class FakeLineEmitter {
  val lines = new ArrayBuffer[String]()

  def apply(line: String): Unit = {
    lines.append(line)
  }
}
