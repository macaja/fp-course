package course.firstQuiz

import org.scalacheck.Prop._
import org.scalacheck.Properties

import scala.collection.immutable

object CollectionSpec extends Properties("Collection[A]") {
  property("empty") = forAll { _: Unit =>
    Collection() == Empty
  }

  property("apply") = forAll { (a: Int, b: Int, c: Int) =>
    val s = immutable.Seq(a, b, c)
    Collection(s: _*) == Cons(a, Cons(b, Cons(c, Empty))) &&
      Collection(a, b, c) == Collection(s: _*)
  }

  property("length") = forAll { (a: Int, b: Int, c: Int, d: Int) =>
    val col = Collection(a, b, c, d)
    Collection.length(col) == List(a, b, c, d).size
  }

  property("sum") = forAll { (a: Int, b: Int, c: Int) =>
    val col = Collection.apply(a, b, c)
    val sum = a + b + c
    CollectionInt.sumFold(col) == sum && CollectionInt.sumRec(col) == sum
  }

  property("product") = forAll { (a: Int, b: Int, c: Int) =>
    val col = Collection.apply(a, b, c)
    val product = a * b * c
    CollectionInt.productFold(col) == product && CollectionInt.productRec(col) == product
  }

  property("max") = forAll { (a: Int, b: Int) =>
    val col = Collection(a, b)
    val max = math.max(a, b)
    CollectionInt.maxRec(col) == max && CollectionInt.maxFold(col) == max
  }
}