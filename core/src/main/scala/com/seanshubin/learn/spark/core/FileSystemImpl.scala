package com.seanshubin.learn.spark.core

import java.io.{Reader, Writer}
import java.nio.charset.Charset
import java.nio.file.{Files, Path}

class FileSystemImpl(charset: Charset) extends FileSystem {
  override def ensureDirectoryExists(path: Path): Unit = Files.createDirectories(path)

  override def writerFor(path: Path): Writer = Files.newBufferedWriter(path, charset)

  override def readerFor(path: Path): Reader = Files.newBufferedReader(path, charset)
}
