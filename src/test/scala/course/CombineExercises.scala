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

}
object X {
  trait SG[A] {
    def combine(x: A, y: A): A
  }

  object Syntax {
    implicit def combine[A](a: A,b: A)(implicit combiner: SG[A]) = combiner.combine(a,b)
  }
}
