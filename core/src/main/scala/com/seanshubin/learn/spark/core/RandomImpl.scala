package com.seanshubin.learn.spark.core

class RandomImpl(seed: Int) extends Random {
  private val peer = new scala.util.Random(seed)

  override def nextInt(upperExclusive: Int): Int = {
    peer.nextInt(upperExclusive)
  }
}
