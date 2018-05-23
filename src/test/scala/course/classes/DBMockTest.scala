package course.classes

import org.scalatest.concurrent.ScalaFutures
import org.scalatest.{AsyncWordSpec, Matchers}

class DBMockTest extends AsyncWordSpec with  ScalaFutures with Matchers{

  "DBMock" should {
    "s" in{
      val f = DBMock.getAddressById(1).value
      whenReady(f.failed){ ex =>
        ex.getMessage shouldBe "fails"
      }
    }
  }

}
