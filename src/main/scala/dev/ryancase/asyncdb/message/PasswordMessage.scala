package dev.ryancase.asyncdb.message

// F
case class PasswordMessage(password: String)
object PasswordMessage {
  val identifier: Byte = 'p'
}
