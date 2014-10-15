package com.seanshubin.learn.spark.core

class FakeWordFactory extends WordFactory {
  var index: Int = 0

  override def generateWord(): String = {
    val word = (index + 'a').toChar.toString * 3
    index += 1
    if (index >= 26) index = 0
    word
  }
}
