package midTermSolution.domain.account

import midTermSolution.DomainServiceError
import midTermSolution.domain.domainErrors.CurrencyNotSupportedAtTheTime

sealed trait Currency

case object USD extends Currency
case object COP extends Currency

object Currency {
  def apply(c: String): Either[DomainServiceError, Currency] =
    c.toLowerCase match {
      case "usd" => Right(USD)
      case "cop" => Right(COP)
      case _     => Left(CurrencyNotSupportedAtTheTime())
    }
}
