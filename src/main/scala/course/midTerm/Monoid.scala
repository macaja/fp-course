package course.midTerm

import cats.Monoid

sealed trait R2[A] {
  type P = A Tuple2 A
  type I = (A) => A
  type ∆ = (P) => P

  def Ø: P
  def → : ∆
  def ↤ : ∆
  def ↓ : ∆
  def ↑ : ∆
  def ↗ : ∆
  def ↘ : ∆
  def ↖ : ∆
  def ↙ : ∆
  def ⇌ : ∆

  def δ(f: I)(g: I): ∆ = { case (x, y) => (f(x), g(y)) }

  implicit def rm: Monoid[∆] = new Monoid[∆] {
    override def empty: ∆ = ⇌
    override def combine(f: ∆, g: ∆): ∆ = f andThen g
  }
}

case object ℤ extends R2[Int] {
  override def Ø: P = (0, 0)
  override def → : ∆ = δ(_ + 1)(identity)
  override def ↤ : ∆ = δ(_ - 1)(identity)
  override def ↓ : ∆ = δ(identity)(_ - 1)
  override def ↑ : ∆ = δ(identity)(_ + 1)
  override def ↗ : ∆ = δ(_ + 1)(_ + 1)
  override def ↘ : ∆ = δ(_ + 1)(_ - 1)
  override def ↖ : ∆ = δ(_ - 1)(_ + 1)
  override def ↙ : ∆ = δ(_ - 1)(_ - 1)
  override def ⇌ : ∆ = δ(identity)(identity)
  def move: (P) => ∆ = a1 => a2 => (a1._1 + a2._1, a1._2 + a2._2)
}
