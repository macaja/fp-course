package course

import course.classes.monadInstances
import org.scalatest.{FlatSpec, Matchers}

import scala.util.{Failure, Success, Try}

class MonadTest extends FlatSpec with Matchers{

  "Monad" should "x" in{
    import monadInstances._
    import course.classes.monadValidations._
    type either[A] = Either[String, A]
    def fo: Int => Option[Int] = _ => Some(1)
    def fon: Int => Option[Int] = _ => None
    def go: Int => Option[Int] = _ => Some(2)
    def gon: Int => Option[Int] = _ => None
    def ft: Int => Try[Int] = _ => Success(1)
    def ftf: Int => Try[Int] = _ => Failure(new Exception("fail"))
    def gt: Int => Try[Int] = _ => Success(2)
    def gtf: Int => Try[Int] = _ => Failure(new Exception("fail"))
    def fe: Int => either[Int] = _ => Right(1)
    def fel: Int => either[Int] = _ => Left("f")
    def ge: Int => either[Int] = _ => Right(2)
    def gel: Int => either[Int] = _ => Left("f")

    rightIdentity[Option,Int](1) should be(true)
    leftIdentity(1)(fo) should be(true)
    leftIdentity(1)(fon) should be(true)
    associativity(1)(fo)(go) should be(true)
    associativity(1)(fon)(gon) should be(true)


    rightIdentity[Try,Int](1) should be(true)
    leftIdentity(1)(ft) should be(true)
    leftIdentity(1)(ftf) should be(false)  //Try its not a Monad
    associativity(1)(ft)(gt) should be(true)
    associativity(1)(ftf)(gtf) should be(false)  //Try is not a Monad


    rightIdentity[either,Int](1) should be(true)
    leftIdentity(1)(fe) should be(true)
    leftIdentity(1)(fel) should be(true)
    associativity(1)(fe)(ge) should be(true)
    associativity(1)(fel)(gel) should be(true)
  }

}
