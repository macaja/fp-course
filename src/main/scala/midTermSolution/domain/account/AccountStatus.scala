package midTermSolution.domain.account

sealed trait AccountStatus

case object Active extends AccountStatus
case object Inactive extends AccountStatus
