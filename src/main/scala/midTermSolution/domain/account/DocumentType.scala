package midTermSolution.domain.account

import midTermSolution.DomainServiceError
import midTermSolution.domain.domainErrors.DocumentTypeNotSupported

sealed trait DocumentType

case object CC extends DocumentType
case object TI extends DocumentType

object DocumentType{
  def apply(t: String): Either[DomainServiceError,DocumentType] = t.toUpperCase match{
    case "CC" => Right(CC)
    case "TI" => Right(TI)
    case _ => Left(DocumentTypeNotSupported())
  }
}