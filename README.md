# Sean's prototype for learning spark

Sean's word counter application to learn spark

- generate a bunch of words in a bunch of files
- return a sorted histogram of the word frequencies
- only considers words containing the letter 'a'

Steps to run

- mvn package
- java -jar console/target/learn-spark.jar

Your output should be about 441 lines long, first few lines should look like this:

    bab -> 436
    bach -> 453
    bad -> 424
    baf -> 426

## This is test driven! 

### How to integration test the Resilient Distributed Dataset
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
