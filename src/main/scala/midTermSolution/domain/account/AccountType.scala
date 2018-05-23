package midTermSolution.domain.account

import midTermSolution.DomainServiceError
import midTermSolution.domain.domainErrors.AccountTypeNotRecognised

sealed trait AccountType

case object Check extends AccountType
case object Saving extends AccountType
case object Fiduciary extends AccountType

object AccountType {
  def apply(at: String): Either[DomainServiceError, AccountType] =
    at.toLowerCase match {
      case "check"     => Right(Check)
      case "saving"    => Right(Saving)
      case "fiduciary" => Right(Fiduciary)
      case _           => Left(AccountTypeNotRecognised())
    }
}
