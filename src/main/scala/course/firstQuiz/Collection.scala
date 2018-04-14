package course.firstQuiz

import scala.annotation.tailrec

sealed trait Collection[+A]
case object Empty extends Collection[Nothing]
final case class Cons[+A](head: A, tail: Collection[A]) extends Collection[A]

object Collection {
  def apply[A](as: A*): Collection[A] = as.toList match {
    case cons if cons.isEmpty => Empty
    case h :: t => Cons(h, apply(t: _*))
  }

  def foldRight[A, B](col: Collection[A], z: B)(f: (A, B) => B): B = col match {
    case Empty => z
    case Cons(h, t) => f(h, foldRight(t, z)(f))
  }

  def length[A](col: Collection[A]): Int = foldRight(col, 0) { (_, acc) => acc + 1 }
}

object CollectionInt {
  def sumFold(col: Collection[Int]): Int = Collection.foldRight(col, 0) { (acc, v) => acc + v }

  def sumRec(col: Collection[Int]) = {
    @tailrec
    def sumAccumulator(l: Collection[Int], acc: Int): Int = l match {
      case Cons(h, Empty) => h + acc
      case Cons(h, t) => sumAccumulator(t, h + acc)
      case Empty => acc
    }
    sumAccumulator(col, 0)
  }

  def productFold(col: Collection[Int]) = Collection.foldRight(col, 1) { (acc, v) => acc * v }

  def productRec(col: Collection[Int]) = {
    @tailrec
    def productAccumulator(l: Collection[Int], acc: Int): Int = l match {
      case Cons(h, Empty) => h * acc
      case Cons(h, t) => productAccumulator(t, h * acc)
      case Empty => acc
    }
    productAccumulator(col, 1)
  }

  def maxFold(col: Collection[Int]) = Collection.foldRight(col, Integer.MIN_VALUE)(_ max _)

  def maxRec(col: Collection[Int]): Int = {
    @tailrec
    def maxAcc(l: Collection[Int], max: Int): Int = l match {
      case Cons(h, t) => maxAcc(t, if (h > max) h else max)
      case Empty => max
    }
    maxAcc(col, Integer.MIN_VALUE)
  }
}