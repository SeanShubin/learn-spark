package com.seanshubin.learn.spark.core

import java.io.File
import java.nio.file.Paths

object IntegrationTestPaths {
  val sampleDataDir = Paths.get("target", "generated", "test", "integration")

  def pathStringForFile(fileName: String) = sampleDataDir.toString + File.separator + fileName
}
