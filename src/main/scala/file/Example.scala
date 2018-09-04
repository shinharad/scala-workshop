package file

import java.io.PrintWriter
import java.nio.file.{Files, Paths}

import scala.collection.JavaConverters._
import scala.language.reflectiveCalls
import scala.util.Try

object Example extends App {

  val inputFilePath = "src/main/scala/file/sample.csv"
  val outputFile1Path = "src/main/scala/file/output1.txt"
  val outputFile2Path = "src/main/scala/file/output2.txt"

  final case class AmountData(category: String = "", amount: Long = 0l)

  def using[A <: {def close()}, B](resource: A)(f: A => B): Unit = {
    try {
      f(resource)
    } catch {
      case e: Exception => e.printStackTrace()
    } finally {
      if (resource != null) resource.close()
    }
  }

  // amountの合計を算出し、ファイル出力
  val calculatedData1 =
    Files.readAllLines(Paths.get(inputFilePath)).asScala
      .map {
        _.split(',') match {
          case Array(_, _, _, amount) =>
            Try(amount.toLong).fold(_ => 0, identity)

          case _ =>
            0

        }
      }
      .sum

  using(new PrintWriter(outputFile1Path)) { pw =>
    pw.write(calculatedData1.toString)
  }

  // category毎のamountの合計を算出し、category、amountをファイル出力
  val calculatedData2 =
    Files.readAllLines(Paths.get(inputFilePath)).asScala
      .map {
        _.split(',') match {
          case Array(_, category, _, amount) =>
            Try(amount.toLong).fold(
              _ => AmountData(),
              AmountData(category, _)
            )

          case _ =>
            AmountData()

        }
      }
      .filter { _.category.nonEmpty }
      .groupBy { _.category }
      .map {
        case (k, v) =>
          AmountData(k, v.map(_.amount).sum)
      }
      .toList
      .sortWith { _.category < _.category }

  using(new PrintWriter(outputFile2Path)) { pw =>
    pw.write("category, amount\n")
    calculatedData2.foreach { x =>
      pw.write(s"${x.category}, ${x.amount}\n")
    }
  }

}


