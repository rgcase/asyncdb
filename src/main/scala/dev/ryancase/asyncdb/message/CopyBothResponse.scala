package dev.ryancase.asyncdb.message

case class CopyBothResponse(copyFormat: FormatCode, columnFormatCodes: Vector[FormatCode])
object CopyBothResponse {
  val identifier: Byte = 'W'
}
