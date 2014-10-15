package com.seanshubin.learn.spark.core

import java.io.PrintWriter
import java.nio.file.Path

class SampleDataGeneratorImpl(wordFactory: WordFactory,
                              fileSystem: FileSystem,
                              sampleDataPath: Path,
                              fileCount: Int,
                              lineCount: Int,
                              wordsPerLine: Int) extends SampleDataGenerator {
  override def generate(): Unit = {
    fileSystem.ensureDirectoryExists(sampleDataPath)
    (1 to fileCount).foreach(generateFile)
  }

  private def generateFile(fileIndex: Int): Unit = {
    val path = sampleDataPath.resolve(f"sample-$fileIndex%05d.txt")
    val writer = new PrintWriter(fileSystem.writerFor(path))
    val lines = (1 to lineCount).map(generateLine)
    lines.foreach(line => writer.println(line))
    writer.close()
  }

  private def generateLine(lineIndex: Int): String = {
    (1 to wordsPerLine).map(generateWord).mkString(" ")
  }

  private def generateWord(wordIndex: Int): String = {
    wordFactory.generateWord()
  }
}
