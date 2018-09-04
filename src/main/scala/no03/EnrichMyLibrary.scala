package no03

import java.time.ZonedDateTime
import java.time.format.{DateTimeFormatter, ResolverStyle}

import no03.Implicits._

object EnrichMyLibrary extends App {

  val zdt = ZonedDateTime.now()

  def formatter = DateTimeFormatter.ofPattern("uuuuMMdd").withResolverStyle(ResolverStyle.STRICT)
  println(formatter.format(zdt))

  println(zdt.formatEx)

}
