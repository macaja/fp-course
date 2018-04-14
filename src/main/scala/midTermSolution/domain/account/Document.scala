package midTermSolution.domain.account

import midTermSolution.DomainServiceError
import midTermSolution.domain.domainErrors.{DocumentIdIsEmpty, IdSizeIncorrect}

final case class Document(documentType: DocumentType,id: String)

object Document{
  private def validateDocumentId(id: String): Either[DomainServiceError,String] = {
    if(id.isEmpty){
      Left(DocumentIdIsEmpty())
    } else if(id.size < 0 | id.size > 10){
      Left(IdSizeIncorrect())
    } else Right(id)
  }
  def apply(documentType: String, id: String): Either[DomainServiceError,Document] = for{
    dt <- DocumentType(documentType)
    id <- validateDocumentId(id)
  }yield new Document(dt,id)
}
