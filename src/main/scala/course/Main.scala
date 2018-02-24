package course

import scala.annotation.tailrec
import scala.util.{Success, Try}

object Main extends App {
  Test

  def ifElse[A](condition: Boolean, whenTrue: Any,whenFalse: Any): Any = {
    if(condition) whenTrue else whenFalse
  }

  def ifElseIfElse(c1: Boolean, wT1: Any)(c2:Boolean, wT2: Any)(wF: Any) = {
    if(c1){
      wT1
    }else if(c2){
      wT2
    }else{
      wF
    }
  }

  def whenByName(b:Boolean, whenTrue: Any, whenFalse: Any): Any = { //By name
    if(b) whenTrue else whenFalse
  }

  def whenByValue(b:Boolean, whenTrue: => Any, whenFalse: => Any): Any = { //By value
    if(b) whenTrue else whenFalse
  }

  whenByName(1 == 1,println("si"),println("no")) // Both prints are executed, each parameter is evaluated always
  whenByValue(1 == 1,println("si"),println("no")) // Each parameter act as a function, so is evaluated only when is called

  def factorial(n: Int): Int = {
    if (n <= 1) {
      1
    } else {
      n * factorial(n - 1)
    }
  }

  def pFactorial(factorial:Int): String = s"El factorial del número es $factorial"

  // In s _ act as _ => Eta expansion
  val s: String = (factorial _ andThen pFactorial)(3) // the return of the first function is the input of the second
  val s1: String = (pFactorial _ compose factorial)(3) // the return of the second function is the input of the first one
//  val s2 = (factorial _ compose pFactorial)(3)

  println(s"andThen => $s")
  println(s"compose => $s1")

  def print[A <: String](a: A) = s"Imprimiendo $a ..." // A have to be a String or a subtype of String
  // def printN[A <: Numeric[A]](a: A) = s"Imprimiendo $a ..." Need a implicit
  println(print("hola"))

  def polyHO[A,B](x: A,msg: String,f: A => B): String = s"El $msg es: ${f(x)}"
  println(polyHO(3,"factorial",factorial))

  def dev: Double => Double => Double = x => y => y match {
    case y if(y != 0) => x/y
  }
  //println(dev(1.0)(0.0))

  def factO: PartialFunction[Int,Int] = {case 0 => 1}
  def factR: PartialFunction[Int,Int] = {case n => n * factR(n-1)}

  def factC: Int => Int = factO orElse factR
  //println(factC(2))

  def factTail(x: Int): Int = {
    @tailrec
    def factLoop(n: Int, acc: Int): Int = {
      if(n<=0) acc else factLoop(n-1, n*acc)
    }
    factLoop(x,1)
  }

  println(factTail(5))
  // A*, A: _* => Seq[A] INVESTIGAR

  /*Producto -> Colección de tipos
  Tupla -> Colección de valores
  Pensar en clases como productos, no como objetos
   Una clase es lo mismo que una tupla la diferencia es el nombre y la forma de instanciar => Clases y Traits son producto
  Traits son coproductos o sumas
  Class(a: Int, b: Int) <- Tengo que dar todos los tipos*/
  sealed trait A
  class B extends A
  class C extends A
  class D extends A
  def f[a <: A](x: a) = ??? // Solo puedo pasar uno de los cuatro A o B o C o D
  /*Producto y coproducto los vamos a llamar ADT
  los ADT no pueden tener comportamiento*/

  sealed trait Currency{val value: Double}
  case class USD(value: Double) extends Currency
  case class EUR(value: Double) extends Currency
  case class COP(value: Double) extends Currency

  def findValueTerm(c: Currency,trms: List[(Currency, Double)]): Double = trms.find{
    case(_:Currency, trm) => true
  }   .get._2

  def toCop(c: Currency, trms: List[(Currency, Double)]): Double = c.value * findValueTerm(c,trms)

  case class AAA(a: Int, b: Int)
  val rrr = AAA(1,2) match{
    case AAA(a,b) => AAA(a + 1, b + 1)
  }
  println(s"rrr => $rrr")

  Nil :+ 1

  //TODO: 24/02/2018 suma de elementos sobre lista con patter matching

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
  val ssr = average(List(1,2,3,4,5))
  println(s"average => $ssr")

/*  def sum(l: List[Int]) = {
    @tailrec
    def sumLoop(list: List[Int],i: Int,result: List[Int]) = {
      if(i == 0){
        result
      }else{
        sumLoop(l,i-1,result :: list(i))
      }
      result
    }
    sumLoop(l,0,Nil)
  }

  val sss = List(1,2,3,4,5) match {
    case h :: Nil => h + 1 :: Nil
    case h :: t => (h + 1) :: sum(t)
    case _ => Nil
  }

  println(s"sss => $sss")*/


  trait MessageError{val error: String}
  case class Message(text: String,sha: Int)
  object Message{
    def apply(text: String, sha: Int): Either[MessageError,Message] = {
      for{
        s <- validateSha(sha)
        t <- validateText(text)
      }yield new Message(t,s)
    }
  }
  private def validateSha(sha:Int): Either[MessageError,Int] = ???
  private def validateText(text: String): Either[MessageError,String] = ???
}



object Test {
  val a1 = { //The body expression of a field is run only once after which the final value is stored in the object
    println("Hello I'm a field")
    42
  }
  def method = {
    println("Hello I'm a method")
  }
}



