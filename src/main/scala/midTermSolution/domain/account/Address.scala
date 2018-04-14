package midTermSolution.domain.account

import midTermSolution.DomainServiceError
import midTermSolution.domain.domainErrors.AddressNotSupported

trait City

case object MED extends City
case object BOG extends City

object City{
  def apply(c: String): Either[DomainServiceError, City] = c.toLowerCase match{
    case "med" => Right(MED)
    case "bog" => Right(BOG)
    case _ => Left(AddressNotSupported())
  }
}


