package midTermSolution.domain.account

import midTermSolution.DomainServiceError
import midTermSolution.domain.domainErrors.HolderTypeInvalid

sealed trait HolderType

case object NaturalPerson extends HolderType
case object JuridicPerson extends HolderType

object HolderType {
  def apply(ht: String): Either[DomainServiceError, HolderType] =
    ht.toLowerCase match {
      case "naturalperson" => Right(NaturalPerson)
      case "juridicPerson" => Right(JuridicPerson)
      case _               => Left(HolderTypeInvalid())
    }
}
