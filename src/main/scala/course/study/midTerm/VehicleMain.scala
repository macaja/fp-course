package course.study.midTerm

import course.study.midTerm.infrastructure.adapters.dtos.VehicleDTO
import course.study.midTerm.vehicle.services.SaveVehicle

import scala.concurrent.Await
import scala.concurrent.duration._
object VehicleMain extends App{

  val vehicleDto = VehicleDTO(
    `type` = "Car",
    color = "red",
    modelYear = 2015,
    fuel = "Regular",
    motor = "4X2"
  )
  val service = new SaveVehicle
  service.save(vehicleDto).fold(
    err => println(s"domain error ${err.message}"),
    f => {
      val s = Await.result(f,2.seconds) //Only with demonstrative purpose
      println(s"result => $s")
    }
  )

}
