package course.classes

import scala.util.Try


abstract class ListOperations[A] {

  //Working with lists.
  def lastElement(list: List[A]): Option[A] = list.takeRight(1).headOption

  def penultimateElement(list: List[A]): Option[A] = list.takeRight(2).headOption

  def getKthElement(position: Int, list: List[A]): Option[A] = Try(list(position)).fold(_ => None, Some(_))

  def numberElements(list: List[A]): Int = list.size

  def reverse(list: List[A]): List[A] = list.reverse

  def isPalindrome(list: List[A]): Boolean = if (list == reverse(list)) true else false

  def flatten(list: List[List[A]]): List[A] = list.flatten

  def factorial(n: Int): Int = {
    if (n <= 1) {
      1
    } else {
      n * factorial(n - 1)
    }
  }
  def fibonnacci(n: Int): Int = {
    if(n <=1){
      1
    }else{
      fibonnacci(n-1) + fibonnacci(n-2)
    }
  }

}

object ListInt extends ListOperations[Int]
