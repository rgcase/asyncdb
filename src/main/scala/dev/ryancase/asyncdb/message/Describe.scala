package dev.ryancase.asyncdb.message

// F
sealed trait Describe
object Describe  {
  val identifier: Byte = 'D'
}

case class DescribePreparedStatement(name: String) extends Describe
object DescribePreparedStatement {
  val identifier: Byte = 'S'
}

case class DescribePortal(name: String) extends Describe
object DescribePortal {
  val identifier: Byte = 'P'
}
