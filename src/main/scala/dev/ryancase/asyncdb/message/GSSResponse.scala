package dev.ryancase.asyncdb.message

// F
case class GSSResponse(messageData: Array[Byte])
object GSSResponse {
  val identifier: Byte = 'p'
}
