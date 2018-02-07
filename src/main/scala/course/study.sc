import com.sun.corba.se.impl.orbutil.graph.Node

class ListP[T]   //Type Parameter

trait ListM{  // Type member
  type T
}

//Redundant code

trait IterableR[T]{
  def filter(p: T => Boolean): IterableR[T]
  def remove(p: T => Boolean): IterableR[T] = filter(x => !p(x))
}
trait ListR[T] extends IterableR[T]{
  def filter(p: T => Boolean): ListR[T]
  override def remove(p: T => Boolean): ListR[T] = filter(x => !p(x)) //redundant code
}

//Avoid duplicated code

trait IterableA[T, Container[X]]{
  def filter(p: T => Boolean): Container[T]
  def remove(p:T => Boolean): Container[T] = filter(x => !p(x))
}
trait ListA[T] extends IterableA[T,ListA]{
  override def filter(p: T => Boolean): ListA[T]
}

object ListA{
  //def apply[A](a: A): ListA[A] = new ListA(a)
/*  implicit object intList extends ListA[Int]{
    def filter(p: Int => Boolean): ListA[Int] = if(p(_) == true) ListA(1) else ListA(0)
  }*/
}

//val la: ListA[Int] = ListA.apply(1)
//val f = la.filter(_ > 2)

