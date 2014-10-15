package com.seanshubin.learn.spark.core

class WordFactoryImpl(random: Random, startingConsonants: Seq[String], middleVowels: Seq[String], endingConsonants: Seq[String]) extends WordFactory {
  override def generateWord(): String = {
    chooseRandom(startingConsonants) + chooseRandom(middleVowels) + chooseRandom(endingConsonants)
  }

  private def chooseRandom(fromSounds: Seq[String]): String = fromSounds(random.nextInt(fromSounds.size))
}
