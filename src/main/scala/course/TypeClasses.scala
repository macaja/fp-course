package course

object TypeClasses extends App {

  case class Person(name: String, amount: Double)

  trait Sum[A]{
    def add(a: A,b: A): A
    def zero: A
  }

  object SumInst{
    implicit val sumInt = new Sum[Int] {
      override def add(a: Int, b: Int): Int = a + b
      override def zero: Int = 0
    }
    implicit val sumString = new Sum[String] {
      override def add(a: String, b: String): String = a + b
      override def zero: String = ""
    }
    implicit val sumNaturalPerson = new Sum[Person] {
      override def add(a: Person, b: Person): Person = Person(name = "Jurídico",amount = a.amount + b.amount)
      override def zero: Person = Person("",0.0)
    }
  }

  //TODO: practicar fold, map y flatMap

  object SumOps{
    def add[A](a:A,b: A)(implicit sm:Sum[A]) = sm.add(a,b)
    def zero[A](implicit sm:Sum[A]) = sm.zero
  }
  import course.TypeClasses.SumInst._
  import course.TypeClasses.SumOps._
  println(add(1,2))
  println(add("1","2"))
  println(add(Person("Jose",20.0),Person("Camilo",30.0)))


  val list= List(1,2,3)
  println(list.fold(zero[Int])((a,b) => add(a,b)))

  def sum(a: Int)(implicit b: Int): Int = a + b
  def sum(a: String)(b: String): String = a + b

  implicit val i: Int = "4"
  implicit def toS: Int => String = _.toString
  implicit def toI: String => Int = java.lang.Integer.valueOf(_)

  sum(2)
  sum("H")(2)


  case class PersonR(username:String, age: Int)
  implicit val p: PersonR = PersonR("the kid",3)

  def sumP(a: Int)(implicit p: PersonR): PersonR = p.copy(age = p.age + a)
  println(sumP(1))

  implicit class StringOps(s: String){ // Solo puede ir un parametro en clases implicitas, le agrego ese comportamiento a el tipo String
    def >==(s2: String): Boolean =
      s.length >= s2.length
  }

  "Hola" >== "Chaos"
}
