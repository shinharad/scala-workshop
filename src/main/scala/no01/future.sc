import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.util.{Failure, Success}

val future = Future(100)
Await.result(future, Duration.Inf)

val future2 = Future {
  1 + 1
}
Await.result(future2, Duration.Inf)

val future3 = future.onComplete {
  case Success(v) =>
    println(v * 2)
  case Failure(e) =>
    println(e)
    println(0)
}

def findById(a: Double): Double =
  if (a > 0) a * 2 else throw new Exception("Error")

findById(100)
//findById(0)


def f(a: Double): Future[Double] =
  Future(findById(a))

val future4 = f(100)
future4.onComplete {
  case Success(v) =>
    println(v * 2)
  case Failure(e) =>
    println(e)
    println(0)
}
Await.result(future4, Duration.Inf)

//val future5 = f(0)
//future5.onComplete {
//  case Success(v) =>
//    println(v * 2)
//  case Failure(e) =>
//    println(e)
//    println(0)
//}
//Await.result(future5, Duration.Inf)

val future6 = future flatMap { x =>
  f(x) flatMap { y =>
    f(y) map { z =>
      z
    }
  }
}
Await.result(future6, Duration.Inf)


val f1 = Future { 1 + 1 }
val f2 = Future { 2 + 2 }




for {
  x <- f1
  y <- f2
} yield (x, y)


for {
  x <- Future { 1 + 1 }
  y <- Future { 2 + 2 }
} yield (x, y)






val future7 = for {
  x <- future
  y <- f(x)
  z <- f(y)
} yield z
Await.result(future7, Duration.Inf)







