package course

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
  println(dev(1.0)(0.0))

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



