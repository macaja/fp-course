package midTermSolution.domain.deposit

import midTermSolution.DomainServiceError
import midTermSolution.domain.account.Currency
import midTermSolution.domain.domainErrors.DepositAmountLessThanZero

final case class Deposit(amount: Double, currency: Currency)

object Deposit {
  def apply(amount: Double,
            currency: String): Either[DomainServiceError, Deposit] = {
    if (amount < 0) Left(DepositAmountLessThanZero())
    else Currency(currency).map(new Deposit(amount, _))
  }
}
