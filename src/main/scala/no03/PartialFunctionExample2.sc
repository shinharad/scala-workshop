val opt = Option(123)
//  val opt: Option[Int] = None


opt collect {
  case v if v == 123 => s"[$v]"
}

val pf: PartialFunction[Int, String] = {
  case v if v == 123 => s"[$v]"
}

opt collect pf


// isDefinedAt
pf.isDefinedAt(123)
pf.isDefinedAt(124)


val pf2: PartialFunction[Int, String] = {
  case v if v == 123 => s"[$v]"
}

val pf3: PartialFunction[Int, String] = {
  case v if v == 124 => s"[$v]"
}

val pf4 = pf2 orElse pf3
pf4.isDefinedAt(123)
pf4.isDefinedAt(124)

opt collect pf4




