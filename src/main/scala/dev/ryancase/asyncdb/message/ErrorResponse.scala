package dev.ryancase.asyncdb.message

// B
sealed trait ErrorResponse
object ErrorResponse {
  val identifier: Byte = 'E'
}

// Error codes: https://postgresql.org/docs/current/protocol-error-fields.html
case object UnknownErrorResponse extends ErrorResponse
