package com.seanshubin.learn.spark.core

import org.scalatest.FunSuite

class WordFactoryTest extends FunSuite {
  test("word factory") {
    val random: Random = new FakeRandom(
      0, 1, 2,
      2, 2, 0,
      1, 0, 1)
    val startingConsonants = Seq("b", "d", "f")
    val middleVowels = Seq("a", "e", "i")
    val endingConsonants = Seq("g", "h", "j")
    val wordFactory: WordFactory = new WordFactoryImpl(random, startingConsonants, middleVowels, endingConsonants)
    assert(wordFactory.generateWord() === "bej")
    assert(wordFactory.generateWord() === "fig")
    assert(wordFactory.generateWord() === "dah")
  }
}
