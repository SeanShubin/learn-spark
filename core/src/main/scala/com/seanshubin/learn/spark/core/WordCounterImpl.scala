package com.seanshubin.learn.spark.core

import org.apache.spark.SparkContext._

class WordCounterImpl(pathSpecification: String,
                      resilientDistributedDatasetLoader: ResilientDistributedDatasetLoader) extends WordCounter {
  override def calculateWordHistogram(): Seq[(String, Int)] = {
    val logData = resilientDistributedDatasetLoader.loadFromPathPattern(pathSpecification).cache()

    val lineToWords: String => Seq[String] = line => line.split(" ")
    val wordHasA: String => Boolean = word => word.contains("a")
    val wordToWordOne: String => (String, Int) = word => (word, 1)
    val plus: (Int, Int) => Int = (left, right) => left + right
    val wordQuantityToWord: ((String, Int)) => String = wordQuantity => wordQuantity._1

    val sortedWordAndCountSeq = logData.
      flatMap(lineToWords).
      filter(wordHasA).
      map(wordToWordOne).
      reduceByKey(plus).
      sortBy(wordQuantityToWord)

    val histogram = sortedWordAndCountSeq.toLocalIterator.toSeq
    histogram
  }
}
