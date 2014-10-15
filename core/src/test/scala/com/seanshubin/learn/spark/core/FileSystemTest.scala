package com.seanshubin.learn.spark.core

import java.io.{BufferedReader, PrintWriter}
import java.nio.charset.{Charset, StandardCharsets}
import java.nio.file.Paths

import org.scalatest.FunSuite

class FileSystemTest extends FunSuite {
  test("write and read file") {
    val expected = "Hello, world!"
    val path = Paths.get(IntegrationTestPaths.pathStringForFile("hello.txt"))
    val charset: Charset = StandardCharsets.UTF_8
    val fileSystem: FileSystem = new FileSystemImpl(charset)
    fileSystem.ensureDirectoryExists(IntegrationTestPaths.sampleDataDir)
    val writer = new PrintWriter(fileSystem.writerFor(path))
    writer.println(expected)
    writer.close()
    val reader = new BufferedReader(fileSystem.readerFor(path))
    val actual = reader.readLine()
    assert(actual === expected)
  }
}
