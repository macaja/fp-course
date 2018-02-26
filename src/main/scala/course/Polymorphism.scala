package course

object Polymorphism {

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

  def factorial(n: Int): Int = {
    if (n <= 1) {
      1
    } else {
      n * factorial(n - 1)
    }
  }

  def pFactorial(factorial:Int): String = s"El factorial del número es $factorial"

  // In s _ act as _ => Eta expansion
  def factAndThen: Int => String = (factorial _ andThen pFactorial)(_) // the return of the first function is the input of the second
  def factCompose: Int => String = (pFactorial _ compose factorial)(_) // the return of the second function is the input of the first one

  def polyHO[A,B](x: A,msg: String,f: A => B): String = s"El $msg es: ${f(x)}"

}
