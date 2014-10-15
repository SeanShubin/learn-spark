package com.seanshubin.learn.spark.core

case class Configuration(seed: Int,
                         dataDirectory: String,
                         fileCount: Int,
                         lineCount: Int,
                         wordsPerLine: Int,
                         startingConsonants: Seq[String],
                         middleVowels: Seq[String],
                         endingConsonants: Seq[String],
                         sparkAppName: String,
                         sparkMaster: String)
