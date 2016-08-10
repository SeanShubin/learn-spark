package com.seanshubin.learn.spark.core

import java.io.{Reader, Writer}
import java.nio.file.Path

class FakeFileSystem(existingDirectories: Set[Path]) extends FileSystem {
  var writers: Map[Path, FakeStringWriter] = Map()

  override def ensureDirectoryExists(path: Path): Unit = existingDirectories.contains(path)

  override def readerFor(path: Path): Reader = ???

  override def writerFor(path: Path): Writer = {
    writers.get(path) match {
      case Some(writer) => writer
      case None =>
        val writer = new FakeStringWriter
        writers += (path -> writer)
        writer
    }
  }
}
