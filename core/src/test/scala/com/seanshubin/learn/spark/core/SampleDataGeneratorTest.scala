package com.seanshubin.learn.spark.core

import java.nio.file.Paths

import org.scalatest.FunSuite


class SampleDataGeneratorTest extends FunSuite {
  test("3 files, 3 lines, 3 words") {
    //given
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
    val sampleDataDir = Paths.get("sample", "data")
    val fileSystem = new FakeFileSystem(Set(sampleDataDir))
    val file1 = sampleDataDir.resolve("sample-00001.txt")
    val file2 = sampleDataDir.resolve("sample-00002.txt")
    val file3 = sampleDataDir.resolve("sample-00003.txt")
    val fileCount = 3
    val lineCount = 3
    val wordsPerLine = 3
    val wordFactory = new FakeWordFactory()
    val sampleDataGenerator = new SampleDataGeneratorImpl(
      wordFactory, fileSystem, sampleDataDir, fileCount, lineCount, wordsPerLine)

    //when
    sampleDataGenerator.generate()

    //then
    assert(fileSystem.writers(file1).toLines === expected1)
    assert(fileSystem.writers(file2).toLines === expected2)
    assert(fileSystem.writers(file3).toLines === expected3)
    assert(fileSystem.writers(file1).closeCount === 1)
    assert(fileSystem.writers(file2).closeCount === 1)
    assert(fileSystem.writers(file3).closeCount === 1)
  }
}
