package midTermSolution.domain.account

import midTermSolution.DomainServiceError
import midTermSolution.domain.domainErrors.CityNameIsEmpty

final case class City(value: String)

object City {
  def apply(c: String): Either[DomainServiceError, City] = if(c.isEmpty) Left(CityNameIsEmpty()) else Right(new City(c))
}
