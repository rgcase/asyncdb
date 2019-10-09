package dev.ryancase.asyncdb.message

// F
sealed trait Close {
  val name: String
}
object Close {
  val identifier: Byte = 'C'
}

case class ClosePreparedStatement(name: String) extends Close
object ClosePreparedStatement {
  val identifier: Byte = 'S'
}

case class ClosePortal(name: String) extends Close {
  val identifier: Byte = 'P'
}
