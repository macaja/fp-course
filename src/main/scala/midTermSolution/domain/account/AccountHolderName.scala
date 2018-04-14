package midTermSolution.domain.account

import midTermSolution.DomainServiceError
import midTermSolution.domain.domainErrors.HolderNameIsEmpty

final case class AccountHolderName(name: String)

object AccountHolderName{
  def apply(name: String): Either[DomainServiceError,AccountHolderName] = {
    if(name.isEmpty) Left(HolderNameIsEmpty()) else Right(new AccountHolderName(name))
  }
}

final case class AccountHolder(document: Document, name: AccountHolderName, holderType: HolderType)

object AccountHolder{
  def apply(documentType: String, documentId: String, name: String, holderType: String): Either[DomainServiceError,AccountHolder] = for{
    d <- Document(documentType,documentId)
    ahn <- AccountHolderName(name)
    ht <- HolderType(holderType)
  } yield new AccountHolder(d,ahn,ht)
}
