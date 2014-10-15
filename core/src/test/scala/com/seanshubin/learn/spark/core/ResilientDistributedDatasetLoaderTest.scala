package com.seanshubin.learn.spark.core

import java.io.{File, PrintWriter}
import java.nio.charset.StandardCharsets
import java.nio.file.Files

import org.scalatest.FunSuite

class ResilientDistributedDatasetLoaderTest extends FunSuite {
  test("get resilient distributed dataset from many files") {
    val directoryToScan = IntegrationTestPaths.sampleDataDir.toString + File.separatorChar + "sample-file-*.txt"
    createSampleFile("sample-file-a.txt", "aaa bbb ccc", "ddd eee fff", "ggg hhh iii")
    createSampleFile("sample-file-b.txt", "jjj kkk lll", "mmm nnn ooo", "ppp qqq rrr")
    createSampleFile("sample-file-c.txt", "sss ttt uuu", "vvv www xxx", "yyy zzz aaa")
    val sparkContextLifecycle: SparkContextLifecycle = new SparkContextLifecycleImpl("Integration Test", "local")
    val resilientDistributedDatasetLoader: ResilientDistributedDatasetLoader = new ResilientDistributedDatasetLoaderImpl(sparkContextLifecycle)
    val dataset = resilientDistributedDatasetLoader.loadFromPathPattern(directoryToScan)
    val lines = dataset.toLocalIterator.toSeq
    assert(lines.size === 9)
    assert(lines.contains("aaa bbb ccc"), "has line from sample-file-a.txt")
    assert(lines.contains("mmm nnn ooo"), "has line from sample-file-b.txt")
    assert(lines.contains("yyy zzz aaa"), "has line from sample-file-c.txt")
  }

  def createSampleFile(name: String, lines: String*): Unit = {
    Files.createDirectories(IntegrationTestPaths.sampleDataDir)
    val path = IntegrationTestPaths.sampleDataDir.resolve(name)
    val charset = StandardCharsets.UTF_8
    val printWriter = new PrintWriter(Files.newBufferedWriter(path, charset))
    lines.foreach(printWriter.println)
    printWriter.close()
  }
}
