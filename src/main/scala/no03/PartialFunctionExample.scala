package no03

object PartialFunctionExample extends App {

  val opt = Option(123)
//  val opt: Option[Int] = None

  opt match {
    case Some(v) => println(v)
    case None => println("None")
  }

  // 警告を抑止。でもマッチしなければエラー
//  (opt: @unchecked) match {
//    case Some(v) => println(v)
//  }

}
