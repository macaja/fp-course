package course

object CallByNameAndByValue {

  def whenByName(b:Boolean, whenTrue: Any, whenFalse: Any): Any = { //By name
    if(b) whenTrue else whenFalse
  }

  def whenByValue(b:Boolean, whenTrue: => Any, whenFalse: => Any): Any = { //By value
    if(b) whenTrue else whenFalse
  }

  whenByName(1 == 1,println("si"),println("no")) // Both prints are executed, each parameter is evaluated always
  whenByValue(1 == 1,println("si"),println("no")) // Each parameter act as a function, so is evaluated only when is called
}
