package course.classes

import scala.annotation.tailrec

object TailRecursion {

  def factorial(x: Int): Int = {
    @tailrec
    def factorialLoop(n: Int, acc: Int): Int = {
      if(n<=0) acc else factorialLoop(n-1, n*acc)
    }
    factorialLoop(x,1)
  }

  def average(xx: List[Int]): Double = {
    @tailrec
    def averageLoop(list: List[Int],accSize: Int,acc: Double): Double = {
      list match {
        case h :: Nil => {
          (h + acc)/accSize
        }
        case h :: t => {
          averageLoop(t,accSize + 1, acc + h)
        }
        case Nil => {
          acc/accSize
        }
      }
    }
    averageLoop(xx , 1 , 0.0)
  }

  //TODO:  A*, A: _* => Seq[A] INVESTIGAR
  //TODO: 24/02/2018 suma de elementos sobre lista con patter matching y tailrec

}
