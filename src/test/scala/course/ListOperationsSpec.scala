package course

import org.scalatest.{AsyncWordSpec, Matchers}

class ListOperationsSpec extends AsyncWordSpec with Matchers {

  val nnsp = new ListOperations[Int]
  val list = List(1, 2, 3, 4, 5, 6, 7, 8, 9)

  "NinetyNineScalaProblems" should {
    "get the last element of a list" in {
      nnsp.lastElement(list) shouldBe Some(9)
    }
    "get the penultimate element of a list" in {
      nnsp.penultimateElement(list) shouldBe Some(8)
      nnsp.penultimateElement(List()) shouldBe None
    }
    "get Kth value due some position" in {
      nnsp.getKthElement(5, list) shouldBe Some(6)
      nnsp.getKthElement(12, list) shouldBe None
    }
    "get number of elements of a list" in {
      nnsp.numberElements(list) shouldBe 9
    }
    "get the reverse of a list" in {
      nnsp.reverse(list) shouldBe List(9, 8, 7, 6, 5, 4, 3, 2, 1)
      nnsp.reverse(List()) shouldBe List()
    }
    "know if a list is palindrome" in {
      nnsp.isPalindrome(list) shouldBe false
      nnsp.isPalindrome(List(1, 2, 3, 2, 1)) shouldBe true
    }
    "make a fletten over list" in {
      nnsp.flatten(List(List(1, 2), List(2, 4), List(5, 6), List(7, 8))) shouldBe List(1, 2, 2, 4, 5, 6, 7, 8)
      nnsp.flatten(List(List())) shouldBe List()
    }
  }

}
