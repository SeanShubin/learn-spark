package com.seanshubin.learn.spark.core

import java.nio.file.Paths

import org.scalatest.FunSuite
import org.scalatest.mock.EasyMockSugar

class SampleDataGeneratorTest extends FunSuite with EasyMockSugar {
  test("3 files, 3 lines, 3 words") {
    val expected1 = Seq(
      "aaa bbb ccc",
      "ddd eee fff",
      "ggg hhh iii")
    val expected2 = Seq(
      "jjj kkk lll",
      "mmm nnn ooo",
      "ppp qqq rrr")
    val expected3 = Seq(
      "sss ttt uuu",
      "vvv www xxx",
      "yyy zzz aaa")
    val fileSystem = mock[FileSystem]
    val sampleDataDir = Paths.get("sample", "data")
    val fileCount = 3
    val lineCount = 3
    val wordsPerLine = 3
    val wordFactory = new FakeWordFactory()
    val sampleDataGenerator = new SampleDataGeneratorImpl(
      wordFactory, fileSystem, sampleDataDir, fileCount, lineCount, wordsPerLine)
    val writer1 = new FakeStringWriter
    val writer2 = new FakeStringWriter
    val writer3 = new FakeStringWriter
    expecting {
      fileSystem.ensureDirectoryExists(sampleDataDir)
      fileSystem.writerFor(sampleDataDir.resolve("sample-00001.txt")).andReturn(writer1)
      fileSystem.writerFor(sampleDataDir.resolve("sample-00002.txt")).andReturn(writer2)
      fileSystem.writerFor(sampleDataDir.resolve("sample-00003.txt")).andReturn(writer3)
    }
    whenExecuting(fileSystem) {
      sampleDataGenerator.generate()
    }
    def toLines(fakeStringWriter: FakeStringWriter) = fakeStringWriter.toString.split("\r\n|\r|\n").toSeq
    assert(toLines(writer1) === expected1)
    assert(toLines(writer2) === expected2)
    assert(toLines(writer3) === expected3)
    assert(writer1.closeCount === 1)
    assert(writer2.closeCount === 1)
    assert(writer3.closeCount === 1)
  }
}
