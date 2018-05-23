package course.classes

import org.scalatest.{AsyncWordSpec, Matchers}

class PartialFunctionsSpec extends AsyncWordSpec with Matchers{

  val partialFunc = PartialFunctions
  "Partial function" should{
    "calculate the factorial of any number" in{
      partialFunc.fact.isDefinedAt(-1) should be(false)
      partialFunc.fact.isDefinedAt(0) should be(true)
      partialFunc.fact.isDefinedAt(-1) should be(false)
      partialFunc.fact(0) should be(1)
      partialFunc.fact(5) should be(120)
    }
  }

}
