/*
package course

import org.scalatest.{FlatSpec, Matchers}


class CombineExercises extends FlatSpec with Matchers{

  import X.Syntax._
  it should "combine 1" in{
    implicit val int = new X.SG[Int] {
      def combine(x: Int, y: Int): Int = x + y
    }
    combine(1,1) shouldBe (2)
  }
  it should "combine Options" in{
    implicit def option[A: X.SG] = new X.SG[Option[Int]] {
      override def combine(x: Option[Int], y: Option[Int]): Option[Int] = (x,y) match {
        case (None,None) => None
        case (Some(a), None) => Some(a)
        case (Some(a), Some(b)) => Some(a+b)
        case (None, Some(b)) => Some(b)
      }
    }
    combine(Some(1),None) should be(Some(1))
    combine(None,None) should be(None)
    combine(Some(1), Some(1)) should be(Some(2))
  }

}
object X {
  trait SG[A] {
    def combine(x: A, y: A): A
  }

  object Syntax {
    implicit def combine[A](a: A,b: A)(implicit combiner: SG[A]) = combiner.combine(a,b)
  }
}*/
