package course.study.midTerm.vehicle

final case class Properties(color: Color,model: Model,description: Description)

object Properties{
  def apply(color: String, modelYear: Int, fuel: String, motor: String): Either[DomainError,Properties] = for{
    c <- Color(color)
    m <- Model(modelYear)
    d <- Description(fuel,motor)
  } yield new Properties(c,m,d)
}
