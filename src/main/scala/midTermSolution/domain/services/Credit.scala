package midTermSolution.domain.services

import midTermSolution.DomainServiceError
import midTermSolution.domain.account.{Account, Balance}
import midTermSolution.domain.deposit.Deposit

final case class  Credit(account: Account, amount: Double, currency: String) {
  def execute: Either[DomainServiceError, Account] =
    for {
      d <- Deposit(amount, currency)
      c <- validateDepositWithAccountCurrency(account.balance.currency,
                                              d.currency)
      b <- Balance(account.balance.amount + d.amount, c)
    } yield account.copy(balance = b)
}
