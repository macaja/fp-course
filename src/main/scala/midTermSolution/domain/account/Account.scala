package midTermSolution.domain.account

import midTermSolution.DomainServiceError
import midTermSolution.domain.bank.Bank
import midTermSolution.dtos.AccountDTO

final case class Account(name: String,
                         number: AccountNumber,
                         holder: AccountHolder,
                         bank: Bank,
                         accountType: AccountType,
                         address: City,
                         balance: Balance,
                         status: AccountStatus)

object Account {

  def apply(accountDTO: AccountDTO): Either[DomainServiceError, Account] =
    for {
      ah <- AccountHolder(accountDTO.documenType,
                          accountDTO.documentId,
                          accountDTO.accountHolderName,
                          accountDTO.holderType)
      b <- Bank(accountDTO.bankName)
      at <- AccountType(accountDTO.accountType)
      add <- City(accountDTO.city)
      bal <- Balance(accountDTO.depositAmount, accountDTO.depositCurrency)
    } yield
      new Account(accountDTO.accountName,
                  AccountNumber.apply,
                  ah,
                  b,
                  at,
                  add,
                  bal,
                  Active)

}
