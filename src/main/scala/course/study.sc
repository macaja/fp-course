class ListP[T] //Type Parameter

trait ListM { // Type member
type T
}

//Redundant code

trait IterableR[T] {
  def filter(p: T => Boolean): IterableR[T]

  def remove(p: T => Boolean): IterableR[T] = filter(x => !p(x))
}

trait ListR[T] extends IterableR[T] {
  def filter(p: T => Boolean): ListR[T]

  override def remove(p: T => Boolean): ListR[T] = filter(x => !p(x)) //redundant code
}

//Avoid duplicated code

trait IterableA[T, Container[X]] {
  def filter(p: T => Boolean): Container[T]

  def remove(p: T => Boolean): Container[T] = filter(x => !p(x))
}

trait ListA[T] extends IterableA[T, ListA] {
  override def filter(p: T => Boolean): ListA[T]
}

case class TxDTO(
                sku:String,
                departmen: Int,
                subdepartment: Int,
                `class`: Int,
                subclass: Int
                )

object TxDTO{

  def validate

}


trait State {
  val code: Int
}

case class Department(code: Int) extends State

case class SubDepartment(code: Int, department: Department) extends State

case class Class(code: Int, subDepartment: SubDepartment) extends State

case class SubClass(code: Int, `class`: Class) extends State

case class Tx(
               sku: String,
               department: Department,
               subDepartment: SubDepartment,
               `class`: Class,
               subClass: SubClass
             )

