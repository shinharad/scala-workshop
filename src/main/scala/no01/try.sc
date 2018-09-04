import scala.util.{Failure, Success, Try}

val t = Try(100)

t.map(_ * 2)

t match {
  case Success(v) => v * 2
  case Failure(e) => 0
}



t.fold(_ => 0, _ * 2)


def javaMethod(a: Double): Double = {
  if (a > 0) a * 2 else throw new Exception("Error")
}


javaMethod(100)

//javaMethod(0)


def f(a: Double): Try[Double] = {
  Try(javaMethod(a))
}


f(100)
f(0)

t flatMap { x =>
  f(x) flatMap { y =>
    f(y) map { z =>
      z
    }
  }
}


for {
  x <- t
  y <- f(x)
  z <- f(y)
} yield z


