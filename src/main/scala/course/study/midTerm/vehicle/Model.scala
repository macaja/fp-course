package course.study.midTerm.vehicle

import cats.syntax.either._
import java.util.Calendar

final case class Model(year: Int)

object Model {
  def apply(year: Int): Either[DomainError, Model] = if (year < 1886 | year > Calendar.getInstance().get(Calendar.YEAR) + 1) ModelYearOutOfEnableRange().asLeft else new Model(year).asRight
}
