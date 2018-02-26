package course

import org.scalatest.{AsyncWordSpec, Matchers}

class PolymorphismSpec extends AsyncWordSpec with Matchers{

  val poli = Polymorphism
  "Polymorphism" should{
    "return a message given any higher order function" in{
      poli.polyHO(3,"factorial",poli.factorial) should be("El factorial es: 6")
    }
    "return the same string with andThen and compose functions" in{
      val n = 3
      poli.factAndThen(n) should be(poli.factCompose(n))
    }
  }

}
