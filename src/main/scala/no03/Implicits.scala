package no03

import java.time.ZonedDateTime
import java.time.format.{DateTimeFormatter, ResolverStyle}

object Implicits {

  def formatter = DateTimeFormatter.ofPattern("uuuuMMdd").withResolverStyle(ResolverStyle.STRICT)

  implicit class RichZonedDateTime(val self: ZonedDateTime) extends AnyVal {
    def formatEx = formatter.format(self)
  }

}
