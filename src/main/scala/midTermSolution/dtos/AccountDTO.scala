package midTermSolution.dtos

sealed trait DTO

final case class AccountDTO(accountName: String, documenType: String, documentId: String,holderType: String, accountHolderName: String, bankName: String, accountType: String, city: String, depositAmount: Double, depositCurrency: String) extends DTO
