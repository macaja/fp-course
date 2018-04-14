package course.study.midTerm.vehicle

import cats.syntax.either._

trait VehicleType

case object Car extends VehicleType
case object Van extends VehicleType
case object Motorcycle extends VehicleType

object VehicleType{
  def apply(t: String): Either[DomainError,VehicleType] = t.toLowerCase match{
    case "car" => Car.asRight
    case "van" => Van.asRight
    case "motorcycle" => Motorcycle.asRight
    case _ => InvalidVehicleType().asLeft
  }
}