package course.classes

import cats.data.OptionT

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import cats.implicits.catsStdInstancesForFuture

object DBMock {

  case class User(id: Int, name: String)
  case class Address(street: String, city: String)

  def getUserById(id: Int): Future[Option[User]] =
    Future.failed(new Exception("fails"))
  def getAdressByUser(user: User): Future[Option[Address]] =
    Future.successful(Some(Address("trans", "rionegro")))

  def getAddressById(id: Int): OptionT[Future, Address] =
    for {
      u <- OptionT(getUserById(id))
      a <- OptionT(getAdressByUser(u))
    } yield a

  case class FutOpt[A](value: Future[Option[A]]) {

    def map[B](f: A => B): FutOpt[B] =
      FutOpt(value.map(optA => optA.map(f)))
    def flatMap[B](f: A => FutOpt[B]): FutOpt[B] =
      FutOpt(value.flatMap(opt =>
        opt match {
          case Some(a) => f(a).value
          case None    => Future.successful(None)
      }))
  }

}
