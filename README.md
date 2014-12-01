# Sean's prototype for learning spark

Sean's word counter application to learn spark

- generate a bunch of words in a bunch of files
- return a sorted histogram of the word frequencies
- only considers words containing the letter 'a'

Not working with one jar, perhaps the One-Jar-URL-Factory setting could help.  
However, I tried both OneJarURLFactory and FileURLFactory under executions/execution/configuration/manifestEntries/One-Jar-URL-Factory and both times I got

    Could not find resource path for Web UI: org/apache/spark/ui/static

In the meantime, you will have to run com.seanshubin.learn.spark.console.ConsoleApplication from your Integrated Development Environment.

Your output should be about 441 lines long, first few lines should look like this:

    bab -> 436
    bach -> 453
    bad -> 424
    baf -> 426

## This is test driven! 

### How to integration test Resilient Distributed Dataset
[ResilientDistributedDatasetLoaderTest](core/src/test/scala/com/seanshubin/learn/spark/core/ResilientDistributedDatasetLoaderTest.scala)

### How to unit test the Resilient Distributed Dataset
[WordCounterTest](core/src/test/scala/com/seanshubin/learn/spark/core/WordCounterTest.scala)

## It is very easy to compose list transformations

[WordCounterImpl](core/src/main/scala/com/seanshubin/learn/spark/core/WordCounterImpl.scala)

    val sortedWordAndCountSeq = logData.
      flatMap(lineToWords).
      filter(wordHasA).
      map(wordToWordOne).
      reduceByKey(plus).
      sortBy(wordQuantityToWord)
