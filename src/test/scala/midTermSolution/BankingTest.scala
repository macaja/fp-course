package midTermSolution

import midTermSolution.domain.account._
import midTermSolution.domain.domainErrors.{AmountOfInitialDepositError, CurrencyMismatch}
import midTermSolution.domain.services.{CreateAccount, Credit, Transfer}
import midTermSolution.dtos.AccountDTO
import org.scalatest.{AsyncWordSpec, Matchers}

class BankingTest extends AsyncWordSpec with Matchers{
  import BankingTest._

  "The Bank" should{
    "return an error if deposit amount creating an account is less than 70000" in{
      val chain: Either[DomainServiceError, Account] = for{
        a <- CreateAccount(dto.copy(depositAmount = 10000)).execute
        _ <- Credit(a,15000,"COP").execute
      }yield a
      chain.fold(error => error shouldBe AmountOfInitialDepositError(10000,COP),_ => fail)
    }
    "create an account succesfully" in{
      CreateAccount(dto).execute.fold(_ => succeed,a => {
        a.accountType shouldBe Saving
        a.status shouldBe Active
        a.balance shouldBe new Balance(100000,COP)
      }
      )
    }
    "return an error if there is a currency mismatch between account and deposit" in{
      val chain = for{
        a1 <- CreateAccount(dto).execute
        a2 <- CreateAccount(dto).execute
        t <- Transfer(a1,a2,15000,"usd").execute
      }yield t
      chain.isRight should be(false)
      chain.fold(errors => errors shouldBe CurrencyMismatch(),_ => fail)
    }
  }

}
object BankingTest{
  val dto = AccountDTO(
    accountName = "Test",
    documenType = "cc",
    documentId = "1255",
    holderType = "naturalperson",
    accountHolderName = "Mauricio",
    bankName = "Bancolombia",
    accountType = "saving",
    city = "Medellin",
    depositAmount = 100000,
    depositCurrency = "cop"
  )
}