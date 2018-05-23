package course.classes

object CurrencyTransformation {

  sealed trait Currency
  case object USD extends Currency
  case object EUR extends Currency
  case object COP extends Currency

  case class Cash(amount: Double, currency: Currency)

  def toCop(c: Cash, trms: Map[Currency, Double]): Either[String, Double] =
    trms
      .get(c.currency)
      .fold[Either[String, Double]](
        Left(s"trm list doesn't have currency ${c.currency}")
      )(
        trmValue => Right(c.amount * trmValue)
      )

}
