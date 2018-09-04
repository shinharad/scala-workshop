import java.nio.file.{Files, Paths}
import scala.collection.JavaConversions._

import scala.language.reflectiveCalls

object Sample {
  val headerCategory = 1
  val bodyCategory = 3

  def using[A, R <: { def close() }](r : R)(f : R => A) : A =
    try {
      f(r)
    } finally {
      r.close()
    }

  def summaryByCategory(body: List[String]): List[String] = {
    def go(category: String, list: List[String]): String = {
      list
        .filter(_.split(",")(headerCategory) == category)
        .map(_.split(",")(bodyCategory).toInt)
        .sum
        .toString
    }
    def getCategory(list: List[String]): List[String] = {
      list.map(_.split(",")(headerCategory)).distinct
    }
    val it = getCategory(body)
    it.map(x => x + "," + go(x, body))
  }

  def createHeader(header: String): List[String] = {
    val head = header.split(",")
    head(headerCategory) + "," + head(bodyCategory) :: Nil
  }

  def func() = {
    using(scala.io.Source.fromFile("/Users/j_tsuchiya/tmp/input.csv")) { in =>
      val fileList = in.getLines.toList
      Files.write(
        Paths.get("/Users/j_tsuchiya/tmp/output.csv")
        ,createHeader(fileList.head) ::: summaryByCategory(fileList.tail))
    }
  }
}
Sample.func()