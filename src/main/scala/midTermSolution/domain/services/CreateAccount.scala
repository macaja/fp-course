package midTermSolution.domain.services

import midTermSolution.DomainServiceError
import midTermSolution.domain.account.Account
import midTermSolution.domain.deposit.{COP, Deposit, USD}
import midTermSolution.domain.domainErrors.AmountOfInitialDepositError
import midTermSolution.dtos.AccountDTO

final class CreateAccount(accountDto: AccountDTO) {

  def execute: Either[DomainServiceError, Account] = for{
    id <- Deposit(accountDto.depositAmount,accountDto.depositCurrency)
    _ <- validateInitialDeposit(id)
    c <- Account(accountDto)
  } yield c

    private[this] def validateInitialDeposit(deposit: Deposit): Either[DomainServiceError,Deposit] = deposit match{
      case d @ Deposit(a,USD) => if(a < 30) Left(AmountOfInitialDepositError(a,d.currency)) else Right(d)
      case d @ Deposit(a,COP) => if(a < 70000) Left(AmountOfInitialDepositError(a,d.currency)) else Right(d)
    }

}
