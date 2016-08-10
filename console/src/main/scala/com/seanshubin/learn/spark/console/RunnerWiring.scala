package com.seanshubin.learn.spark.console

import java.nio.charset.{Charset, StandardCharsets}
import java.nio.file.{Path, Paths}

import com.seanshubin.learn.spark.core._
import org.apache.spark.{SparkConf, SparkContext}

trait RunnerWiring {
  def configuration: Configuration

  lazy val path: Path = Paths.get(configuration.dataDirectory)
  lazy val random: Random = new RandomImpl(configuration.seed)
  lazy val charset: Charset = StandardCharsets.UTF_8
  lazy val fileSystem = new FileSystemImpl(charset)
  lazy val emitLine: String => Unit = println
  lazy val wordFactory: WordFactory = new WordFactoryImpl(
    random,
    configuration.startingConsonants,
    configuration.middleVowels,
    configuration.endingConsonants)
  lazy val sampleDataGenerator: SampleDataGenerator = new SampleDataGeneratorImpl(
    wordFactory,
    fileSystem,
    path,
    configuration.fileCount,
    configuration.lineCount,
    configuration.wordsPerLine)
  lazy val sparkConfig: SparkConf = new SparkConf().
    setAppName(configuration.sparkAppName).
    setMaster(configuration.sparkMaster)
  lazy val sparkContext: SparkContext = new SparkContext(sparkConfig)
  lazy val resilientDistributedDatasetLoader: ResilientDistributedDatasetLoader =
    new ResilientDistributedDatasetLoaderImpl(sparkContext)
  lazy val notifications: Notifications = new LineEmittingNotifications(emitLine)
  lazy val wordCounter: WordCounter = new WordCounterImpl(
    configuration.dataDirectory,
    resilientDistributedDatasetLoader,
    notifications)
  lazy val thirdPartyLogging: ThirdPartyLogging = new ThirdPartyLoggingImpl()
  lazy val runner: Runner = new RunnerImpl(sampleDataGenerator, wordCounter, notifications, thirdPartyLogging)
}
