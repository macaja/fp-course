package course

import course.CurrencyTransformation._
import org.scalatest.{AsyncWordSpec, Matchers}

class CurrencyTransformationSpec extends AsyncWordSpec with Matchers{

  val TRMs: Map[Currency,Double] = Map(
    USD -> 2800D,
    COP -> 1000D,
    EUR -> 3000D
  )
  val currencyTransformation = CurrencyTransformation
  "Currency transformation" should{
    "transform USD into COP" in{
      val transformation = currencyTransformation.toCop(Cash(1,USD),TRMs)
      transformation.isRight should be(true)
      transformation.fold(_ => succeed, value => value should be(2800D))
    }
  }

}
