package course.midTerm

import course.midTerm.ℤ._
import org.scalacheck.Prop._
import org.scalacheck.Properties
import org.scalatest._

import scala.collection.immutable

object R2Specification extends Properties("Real2[Int, Int]") {
  property("identity") = forAll { t: (Int, Int) =>
    ⇌(t) == δ(identity)(identity)(t) && ⇌.apply(t) == t
  }

  property("equality") = forAll { (f: ∆, p: P) =>
    (f andThen ⇌)(p) == f(p) && (⇌ compose f)(p) == f(p)
  }

  property("forward complement") = forAll { (p: P) =>
    (→ compose ↤)(p) == p && (↤ andThen →)(p) == p
  }

  property("diagonal complement") = forAll { (p: P) =>
    (↗ compose ↙)(p) == p && (↙ andThen ↗)(p) == p
  }

  property("back diagonal complement") = forAll { (p: P) =>
    (↘ compose ↖)(p) == p && (↖ andThen ↘)(p) == p
  }

  property("up complement") = forAll { (p: P) =>
    (↑ compose ↓)(p) == p && (↓ andThen ↑)(p) == p
  }

  property("move Ø") = forAll { (p: P) =>
    move(Ø)(p) == p && move(p)(Ø) == p
  }

  property("move to") = forAll { (p0: P, p1: P) =>
    move(p0)(p1) match {
      case (x, y) => x == (p0._1 + p1._1) && y == (p0._2 + p1._2)
    }
  }
}

class MonoidsSpec extends FreeSpec with Matchers {
  "Back to Ø" in {
    import cats.Monoid

    val ms: immutable.Seq[ℤ.∆] = List(→, ⇌, ↑, ↓, ↘, ⇌, ↓, ↗, →, ↤, ↖, ↙, ↖, ↤, ↗, ⇌, ↓)
    val m: ∆ = Monoid[∆].combineAll(ms)
    val r: P = m(Ø)
    r shouldBe Ø
  }
}
