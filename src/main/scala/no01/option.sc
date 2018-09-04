val opt = Option(100)

val opt2 = Option {
  1 + 1
}

val opt3: Option[Int] = None

opt.map(x => x * 2)

opt.map(_ * 2)

opt match {
  case Some(v) => v * 2
  case None => 0
}

opt3 match {
  case Some(v) => v * 2
  case None => 0
}

opt.fold(0)(_ * 2)
opt3.fold(0)(_ * 2)

def f(a: Double, b: Double): Double = a / b

f(100, 2)
f(100, 0)

def g(a: Double, b: Double): Option[Double] =
  if (b != 0) Some(a / b) else None

g(100, 2)
g(100, 0)



opt flatMap { x =>
  g(x, 2) flatMap { y =>
    g(y, 2) map { z =>
      z
    }
  }
}

for {
  x <- opt
  y <- g(x, 2)
  z <- g(y, 2)
} yield z




