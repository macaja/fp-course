package midTermSolution.domain.bank

import midTermSolution.DomainServiceError
import midTermSolution.domain.domainErrors.BankNameIsEmpty

final case class Bank(name: String)

object Bank {
  def apply(name: String): Either[DomainServiceError, Bank] =
    if (name.isEmpty) Left(BankNameIsEmpty()) else Right(new Bank(name))
}
