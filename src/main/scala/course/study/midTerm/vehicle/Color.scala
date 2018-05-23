package course.study.midTerm.vehicle

import cats.syntax.either._

sealed trait Color

case object Blue extends Color
case object Red extends Color
case object Yellow extends Color
case object Green extends Color
case object Orange extends Color

object Color {
  def apply(c: String): Either[DomainError, Color] = c.toLowerCase match {
    case "blue"   => Blue.asRight
    case "red"    => Red.asRight
    case "yellow" => Yellow.asRight
    case "green"  => Green.asRight
    case "orange" => Orange.asRight
    case _        => InvalidColor().asLeft
  }
}
