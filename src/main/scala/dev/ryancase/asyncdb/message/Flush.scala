package dev.ryancase.asyncdb.message

case object Flush {
  val identifier: Byte = 'H'
}
