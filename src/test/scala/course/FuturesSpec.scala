package course

import org.scalatest.concurrent.ScalaFutures
import org.scalatest.{FlatSpec, Matchers}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class FuturesSpec extends FlatSpec with Matchers with ScalaFutures{

  "Futures" should     "sum three futures" in {
    println("Begin")
    val f1: Future[Int] = Future{
      println("uno")
      1
    }
    val f2: Future[Int] = Future{
      println("dos")
      2
    }
    val f3: Future[Int] = Future{
      println("tres")
      3
    }
    val sumF = for{
      a <- f1
      b <- f2
      c <- f3
    } yield a + b + c
    whenReady(sumF){ r =>
      r should be(6)
    }
  }

  case class Name(firstName: String, lastName: String)
  case class Age(value: Int)
  case class Phone(cellphone: Int)
  case class User(name: Name,age: Age, phone: Phone)
  object User {
    def defaultUser = new User(
      Name("Aleja", "Ocampo"),
      Age(23),
      Phone(1)
    )
  }
  def getUserByFirstName(name: String): Future[Option[User]] =
    Future.successful(Some(User.defaultUser))
  def getUserByAge(age: Int): Future[Option[User]] =
    Future.successful(Some(User.defaultUser))
  def getUserByPhone(phone: Int): Future[Option[User]] =
    Future.successful(Some(User.defaultUser))

  def createUser(firstName: String, lastName: String, age: Int, phone: Int): Future[User] =
    for{
      n <- getUserByFirstName(firstName)
      a <- getUserByAge(age)
      p <- getUserByPhone(phone)
    } yield User(
      Name(firstName, lastName),
      Age(age),
      Phone(phone)
    )

  "create user" should "create an user" in{
    val cu = createUser("mauricio","cardona",21,0)
    whenReady(cu){ u =>
      u shouldBe
        User(
          Name("mauricio", "cardona"),
          Age(21),
          Phone(0)
        )
    }
  }
}
