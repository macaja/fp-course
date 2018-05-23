package course.classes

import org.scalatest.{AsyncWordSpec, Matchers}

class TailRecursionSpec extends AsyncWordSpec with Matchers{

  val tailRec = TailRecursion
  "TailRecursion" should{
    "return the factorial of any number" in{
      tailRec.factorial(3) should be(6)
      tailRec.factorial(5) should be(120)
    }
    "return the average of a list" in{
      val list = List(1,2,3,4,5)
      tailRec.average(list) should be(3)
    }
  }

}
