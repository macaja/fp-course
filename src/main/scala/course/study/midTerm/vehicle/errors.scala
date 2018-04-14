package course.study.midTerm.vehicle

trait DomainError {
  def message: String
}

final case class InvalidColor(message: String = "Invalid input color") extends DomainError

final case class InvalidVehicleType(message: String = "VehicleType not supported") extends DomainError

final case class ModelYearOutOfEnableRange(message: String = "Model year out of enable range supported") extends DomainError

final case class InvalidFuelSupplied(message: String = "Invalid input color") extends DomainError

final case class MotorTypeDoesNotExist(message: String = "Motor Type does not exists") extends DomainError