package com.seanshubin.learn.spark.console

import java.nio.file.Paths

import com.seanshubin.learn.spark.core.Configuration

object ConsoleApplication extends App {
  val theConfiguration = Configuration(
    seed = 12345,
    dataDirectory = Paths.get("generated", "sample-data").toString,
    fileCount = 100,
    lineCount = 100,
    wordsPerLine = 100,
    startingConsonants = Seq("p", "b", "t", "d", "k", "g", "m", "n", "f", "v", "th", "s", "z", "sh", "ch", "j", "w", "l", "r", "y", "h"),
    middleVowels = Seq("a", "e", "i", "o", "u"),
    endingConsonants = Seq("p", "b", "t", "d", "k", "g", "m", "n", "ng", "f", "v", "th", "s", "z", "sh", "ch", "j", "w", "l", "r", "y"),
    sparkAppName = "Spark Application",
    sparkMaster = "local"
  )
  new RunnerWiring {
    override def configuration: Configuration = theConfiguration
  }.runner.run()
}
