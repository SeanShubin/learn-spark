package com.seanshubin.learn.spark.core

import org.scalatest.FunSuite

class NotificationsTest extends FunSuite {
  test("generate report") {
    val lineEmitter = new FakeLineEmitter
    val notifications: Notifications = new LineEmittingNotifications(lineEmitter.apply)
    val histogram = Seq("a" -> 1, "b" -> 2, "c" -> 3)
    notifications.generateReport(histogram)
    assert(lineEmitter.lines === Seq("", "histogram:", "  a -> 1", "  b -> 2", "  c -> 3"))
  }

  test("describe calculation") {
    val lineEmitter = new FakeLineEmitter
    val notifications: Notifications = new LineEmittingNotifications(lineEmitter.apply)
    val description = "some description"
    notifications.describeCalculation(description)
    assert(lineEmitter.lines === Seq("some description"))

  }
}
