package course.study.midTerm.vehicle

import cats.syntax.either._

sealed trait Fuel
sealed trait Motor

case object Diesel extends Fuel
case object Plus extends Fuel
case object Regular extends Fuel

case object M4X2 extends Motor
case object M4X4 extends Motor

object Fuel {
  def apply(f: String): Either[DomainError, Fuel] = f.toLowerCase match {
    case "diesel"  => Diesel.asRight
    case "plus"    => Plus.asRight
    case "regular" => Regular.asRight
    case _         => InvalidFuelSupplied().asLeft
  }
}

object Motor {
  def apply(m: String): Either[DomainError, Motor] = m.toLowerCase match {
    case "4x2" => M4X2.asRight
    case "4x4" => M4X4.asRight
    case _     => MotorTypeDoesNotExist().asLeft
  }
}

final case class Description(fuel: Fuel, motor: Motor)
object Description {
  def apply(fuel: String, motor: String): Either[DomainError, Description] =
    for {
      f <- Fuel(fuel)
      m <- Motor(motor)
    } yield new Description(f, m)
}
