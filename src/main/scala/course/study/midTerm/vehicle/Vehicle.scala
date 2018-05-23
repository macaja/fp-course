package course.study.midTerm.vehicle

import java.util.UUID

import course.study.midTerm.infrastructure.adapters.dtos.VehicleDTO

final case class Vehicle(vehicleId: UUID,
                         `type`: VehicleType,
                         properties: Properties)

object Vehicle {
  def apply(vehicleDTO: VehicleDTO): Either[DomainError, Vehicle] =
    for {
      vt <- VehicleType(vehicleDTO.`type`)
      p <- Properties(vehicleDTO.color,
                      vehicleDTO.modelYear,
                      vehicleDTO.fuel,
                      vehicleDTO.motor)
    } yield new Vehicle(UUID.randomUUID(), vt, p)
}
