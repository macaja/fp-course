package course.study.during

case class Nombre(primerNombre: String,apellidos: String)
case class Persona(nombre: Nombre, edad: Int)

trait Trans[A]{
  def trans(a: A): String
}

object TransInstances{
  implicit val intToString = new Trans[Int]{
    override def trans(a: Int): String = a.toString
  }
  implicit val boolToString = new Trans[Boolean]{
    override def trans(a: Boolean): String = a.toString
  }
  implicit val personnToString = new Trans[Persona]{
    override def trans(a: Persona): String = s"El nombre es ${a.nombre.primerNombre}, apellido ${a.nombre.apellidos} y edad ${a.edad.toString}"
  }
}
object TransOperation{
  def transformar[A](a: A)(implicit ts: Trans[A]): String = ts.trans(a)
}

object MainTypeClass extends App{
  import TransInstances._
  import TransOperation._
  println(s"${transformar(1)}")
  println(s"${transformar(true)}")
  println(s"${transformar(Persona(Nombre("Mauricio","Cardona J"),21))}")
}

