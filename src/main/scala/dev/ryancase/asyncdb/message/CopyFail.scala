package dev.ryancase.asyncdb.message

// F
case class CopyFail(errorMessage: String)
object CopyFail {
  val identifier: Byte = 'f'
}
