package course.study.midTerm.vehicle.services

import cats.syntax.either._
import course.study.midTerm.infrastructure.adapters.dtos.VehicleDTO
import course.study.midTerm.infrastructure.repositories.VehicleRepository
import course.study.midTerm.vehicle.Vehicle

final class SaveVehicle extends VehicleRepository {
  def save(dto: VehicleDTO) = {
    for {
      v <- Vehicle(dto)
      s <- saveNewVehicle(v).asRight
    } yield s
  }
}
