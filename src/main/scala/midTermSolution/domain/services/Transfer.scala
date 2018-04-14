package midTermSolution.domain.services

import midTermSolution.domain.account.Account
import midTermSolution.domain.deposit.Deposit

final class Transfer(accountA: Account, accountB: Account, deposit: Deposit) {

  def execute=   for{
    _ <- new Credit(accountA,deposit)
    _ <- new Debit(accountB,deposit)
  } yield deposit

}
