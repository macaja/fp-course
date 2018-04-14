package midTermSolution.domain.services

import midTermSolution.domain.account.Account
import midTermSolution.domain.deposit.Deposit

final class Debit(account: Account, deposit: Deposit) {
  def execute = account.deposit - deposit
}
