package midTermSolution.domain.services

import midTermSolution.DomainServiceError
import midTermSolution.domain.account.Account

final case class Transfer(accountA: Account,
                     accountB: Account,
                     amount: Double,
                     currency: String) {

  def execute: Either[DomainServiceError, (Account, Account)] =
    for {
      a <- Credit(accountA, amount, currency).execute
      b <- Debit(accountB, amount, currency).execute
    } yield (a, b)

}
