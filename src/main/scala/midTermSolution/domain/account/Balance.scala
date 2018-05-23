package midTermSolution.domain.account

import midTermSolution.DomainServiceError
import midTermSolution.domain.domainErrors.WrongBalanceValue

case class Balance(amount: Double, currency: Currency)

object Balance {
  def apply(amount: Double,
            currency: String): Either[DomainServiceError, Balance] =
    for {
      v <- validateAmount(amount)
      c <- Currency(currency)
    } yield new Balance(v, c)

  def apply(amount: Double,
            currency: Currency): Either[DomainServiceError, Balance] =
    validateAmount(amount).map(new Balance(_, currency))

  private[this] def validateAmount(
      amount: Double): Either[WrongBalanceValue, Double] =
    if (amount < 0) Left(WrongBalanceValue()) else Right(amount)
}
