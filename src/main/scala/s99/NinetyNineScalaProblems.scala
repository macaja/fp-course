package s99

import scala.util.Try

class NinetyNineScalaProblems[A] {

  //Working with lists.
  def lastElement(list: List[A]): Option[A] = list.takeRight(1).headOption
  def penultimateElement(list: List[A]): Option[A] = list.takeRight(2).headOption
  def getKthElement(position: Int, list: List[A]): Option[A] = Try(list(position)).fold(_ => None,Some(_))
  def numberElements(list: List[A]): Int = list.size
  def reverse(list: List[A]): List[A] = list.reverse
  def isPalindrome(list: List[A]): Boolean = if(list == reverse(list)) true else false
  def flatten(list: List[List[A]]): List[A] = list.flatten
}
