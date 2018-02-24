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



