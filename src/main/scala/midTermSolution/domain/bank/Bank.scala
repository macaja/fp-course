package midTermSolution.domain.bank

import midTermSolution.DomainServiceError
import midTermSolution.domain.domainErrors.BankNameNotSupported

sealed trait BankName

case object Bancolombia extends BankName
case object Davivienda extends BankName

object BankName{
  def apply(bn:String): Either[DomainServiceError,BankName] = bn.toLowerCase match{
    case "bancolombia" => Right(Bancolombia)
    case "davivienda" => Right(Davivienda)
    case _ => Left(BankNameNotSupported())
  }
}


final case class Bank(name: BankName)

object Bank{
  def apply(name:String): Either[DomainServiceError, Bank] = BankName(name).map(new Bank(_))
}