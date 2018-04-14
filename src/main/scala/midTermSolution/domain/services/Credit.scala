package midTermSolution.domain.services

import midTermSolution.domain.account.Account
import midTermSolution.domain.deposit.Deposit

final class Credit(account: Account, creditDeposit: Deposit) {
  def execute = account.copy(deposit = sumDeposits(account.deposit + creditDeposit ))

  private[this] def sumDeposits(dA:Deposit, dB: Deposit) = if(dA.currency == dB.currency) Deposit(dA.amount+dB.amount,dA.currency) else
}
