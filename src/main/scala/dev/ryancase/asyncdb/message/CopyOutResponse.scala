package dev.ryancase.asyncdb.message

case class CopyOutResponse(copyFormat: FormatCode, columnFormatCodes: Vector[FormatCode])
object CopyOutResponse {
  val identifier: Byte = 'H'
}
