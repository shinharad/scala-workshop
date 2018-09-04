val either: Either[String, Int] = Right(100)
val either2: Either[String, Int] = Left("error")

either.map(_ * 2)

either match {
  case Right(v) => v * 2
  case Left(_) => 0
}

either2 match {
  case Right(v) => v * 2
  case Left(e) =>
    println(e)
    0
}

either.fold(_ => 0, _ * 2)
either2.fold(_ => 0, _ * 2)


def f(a: Double, b: Double): Either[String, Double] =
  if (b != 0) Right(a / b) else Left("Error")

f(100, 2)
f(100, 0)


either flatMap { x =>
  f(x, 2) flatMap { y =>
    f(y, 2) map { z =>
      z
    }
  }
}

for {
  x <- either
  y <- f(x, 2)
  z <- f(y, 2)
} yield z


