package midTermSolution.domain.deposit

import midTermSolution.DomainServiceError
import midTermSolution.domain.domainErrors.{CurrencyNotSupportedAtTheTime, DepositAmountLessThanZero}

sealed trait Currency

case object USD extends Currency
case object COP extends Currency

object Currency{
  def apply(c: String): Either[DomainServiceError,Currency] = c.toLowerCase match{
    case "usd" => Right(USD)
    case "cop" => Right(COP)
    case _ => Left(CurrencyNotSupportedAtTheTime())
  }
}

final case class Deposit(amount:Double,currency: Currency)

object Deposit{
  def apply(amount: Double, currency: String): Either[DomainServiceError,Deposit] = {
    if(amount < 0) Left(DepositAmountLessThanZero()) else Currency(currency).map(new Deposit(amount,_))
  }
}
