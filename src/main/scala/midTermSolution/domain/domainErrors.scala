package midTermSolution.domain

import midTermSolution.DomainServiceError
import midTermSolution.domain.deposit.Currency

object domainErrors {

  final case class BankNameNotSupported(message: String = "Bank name not supported") extends DomainServiceError
  final case class DocumentTypeNotSupported(message: String = "Document type not supported") extends DomainServiceError
  final case class DocumentIdIsEmpty(message: String = "Document Id is empty") extends DomainServiceError
  final case class IdSizeIncorrect(message: String = "Document Id size incorrect, should be between 1 until 10 characters ") extends DomainServiceError
  final case class HolderTypeInvalid(message: String = "holder type invalid") extends DomainServiceError
  final case class HolderNameIsEmpty(message: String = "holder name is empty") extends DomainServiceError
  final case class AccountTypeNotRecognised(message: String = "Account type not recognised") extends DomainServiceError
  final case class AddressNotSupported(message: String = "Address not supported") extends DomainServiceError
  final case class CannotCreateAnAccountWithLessThanRequiredInitialDeposit  (message: String = "Cannot create account with less than 70,000") extends DomainServiceError
  final case class CurrencyNotSupportedAtTheTime(message: String = "Currency not supported") extends DomainServiceError
  final case class DepositAmountLessThanZero(message: String = "Deposit amount less than zero") extends DomainServiceError
  final case class AmountOfInitialDepositError(message: String) extends DomainServiceError
  object AmountOfInitialDepositError{
    def apply(amount: Double, c: Currency): AmountOfInitialDepositError = new AmountOfInitialDepositError(s"the amount of initial deposit should be greater than $amount ${c.toString}")
  }
}
