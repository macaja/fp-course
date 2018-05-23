package course.study.midTerm.infrastructure.adapters.dtos

sealed trait DTO

final case class VehicleDTO(`type`: String,
                            color: String,
                            modelYear: Int,
                            fuel: String,
                            motor: String)
    extends DTO
