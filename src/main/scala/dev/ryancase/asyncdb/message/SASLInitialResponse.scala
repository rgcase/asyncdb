package dev.ryancase.asyncdb.message

// F
case class SASLInitialResponse(name: String, initialResponse: Option[Array[Byte]])
object SASLInitialResponse {
  val identifier: Byte = 'p'
}
