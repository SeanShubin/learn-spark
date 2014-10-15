package com.seanshubin.learn.spark.core

import java.io.{Reader, Writer}
import java.nio.file.Path

trait FileSystem {
  def ensureDirectoryExists(path: Path)

  def readerFor(path: Path): Reader

  def writerFor(path: Path): Writer
}
