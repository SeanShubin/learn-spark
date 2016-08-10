package com.seanshubin.learn.spark.core

import org.scalatest.FunSuite

class WordCounterTest extends FunSuite {
  test("histogram") {
    //given
    val sampleLines = Seq(
      "aaa bab cad beb",
      "beb cad bab aaa",
      "cad aaa bab aaa"
    )
    val expected = Seq(("aaa", 4), ("bab", 3), ("cad", 3))
    val pathSpecification = "path specification"
    val resilientDistributedDatasetLoader = new ResilientDistributedDatasetLoaderStub(Map(pathSpecification -> sampleLines))
    val lineEmitter = new FakeLineEmitter
    val notifications = new LineEmittingNotifications(lineEmitter.apply)
    val wordCounter = new WordCounterImpl(pathSpecification, resilientDistributedDatasetLoader, notifications)

    //when
    val actual = wordCounter.calculateWordHistogram()

    //then
    assert(actual === expected)
  }
}
