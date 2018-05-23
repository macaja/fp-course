package course.study.midTerm.infrastructure.repositories

import java.util.UUID

import course.study.midTerm.vehicle.Vehicle

import scala.concurrent.Future

trait Repository

class VehicleRepository extends Repository {
  def saveNewVehicle(vehicle: Vehicle): Future[String] =
    Future.successful(s"saved vehicle ${vehicle.vehicleId}")
  def deleteVehicle(vehicleId: UUID): Future[String] =
    Future.successful(s"deleted with uuid $vehicleId")
}
