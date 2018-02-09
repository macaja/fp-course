package course

object Main extends App{
  Test
}

object Test{
  val a1 = { //The body expression of a field is run only once after which the final value is stored in the object
    println("Hello I'm a field")
    42
  }
  def method = {
    println("Hello I'm a method")
  }
}



