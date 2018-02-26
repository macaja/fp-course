package course

object PartialFunctions {

  def fact: PartialFunction[Int,Int] = {
    case 0 => 1
    case n if n > 0 => n * fact(n-1)
  }
}
