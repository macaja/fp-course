package midTermSolution.domain

import midTermSolution.DomainServiceError
import midTermSolution.domain.account.Currency
import midTermSolution.domain.domainErrors.CurrencyMismatch

package object services {

  def validateDepositWithAccountCurrency(
      accountCurrency: Currency,
      depositCurrency: Currency): Either[DomainServiceError, Currency] =
    if (accountCurrency == depositCurrency) Right(accountCurrency)
    else Left(CurrencyMismatch())

}
