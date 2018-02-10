package course

import org.scalatest.{AsyncWordSpec, Matchers}

class ListOperationsSpec extends AsyncWordSpec with Matchers {

  val li = ListInt
  val list = List(1, 2, 3, 4, 5, 6, 7, 8, 9)

  "List Operations" should {
    "get the last element of a list" in {
      li.lastElement(list) shouldBe Some(9)
    }
    "get the penultimate element of a list" in {
      li.penultimateElement(list) shouldBe Some(8)
      li.penultimateElement(List()) shouldBe None
    }
    "get Kth value due some position" in {
      li.getKthElement(5, list) shouldBe Some(6)
      li.getKthElement(12, list) shouldBe None
    }
    "get number of elements of a list" in {
      li.numberElements(list) shouldBe 9
    }
    "get the reverse of a list" in {
      li.reverse(list) shouldBe List(9, 8, 7, 6, 5, 4, 3, 2, 1)
      li.reverse(List()) shouldBe List()
    }
    "know if a list is palindrome" in {
      li.isPalindrome(list) shouldBe false
      li.isPalindrome(List(1, 2, 3, 2, 1)) shouldBe true
    }
    "make a fletten over list" in {
      li.flatten(List(List(1, 2), List(2, 4), List(5, 6), List(7, 8))) shouldBe List(1, 2, 2, 4, 5, 6, 7, 8)
      li.flatten(List(List())) shouldBe List()
    }

    "factorial" in{
      li.factorial(5) shouldBe 120
    }
    "fibonnaci" in{
      li.fibonnacci(2) shouldBe 2
    }

  }

}
