package midTermSolution.domain.services

import midTermSolution.DomainServiceError
import midTermSolution.domain.account.{Account, COP, USD}
import midTermSolution.domain.deposit.Deposit
import midTermSolution.domain.domainErrors.AmountOfInitialDepositError
import midTermSolution.dtos.AccountDTO

final case class CreateAccount(accountDto: AccountDTO) {

  def execute: Either[DomainServiceError, Account] =
    for {
      dep <- Deposit(accountDto.depositAmount, accountDto.depositCurrency)
      c <- Account(accountDto)
      _ <- validateInitialDeposit(dep)
      _ <- validateDepositWithAccountCurrency(dep.currency, c.balance.currency)
    } yield c

  private[this] def validateInitialDeposit(
      deposit: Deposit): Either[DomainServiceError, Deposit] = deposit match {
    case d @ Deposit(a, USD) =>
      if (a < 30) Left(AmountOfInitialDepositError(a, d.currency)) else Right(d)
    case d @ Deposit(a, COP) =>
      if (a < 70000) Left(AmountOfInitialDepositError(a, d.currency))
      else Right(d)
  }

}
