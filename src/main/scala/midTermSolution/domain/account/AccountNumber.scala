package midTermSolution.domain.account

import java.util.UUID

final case class AccountNumber(number: UUID)

object AccountNumber{
  def apply: AccountNumber = new AccountNumber(UUID.randomUUID())
}
