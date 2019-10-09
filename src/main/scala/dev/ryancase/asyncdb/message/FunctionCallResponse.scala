package dev.ryancase.asyncdb.message

// B
case class FunctionCallResponse(resultData: Option[Array[Byte]])
object FunctionCallResponse {
  val identifier: Byte = 'V'
}
