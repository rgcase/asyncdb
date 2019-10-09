package dev.ryancase.asyncdb.message

// B
case class CopyInResponse(copyFormat: FormatCode, columnFormatCodes: Vector[FormatCode])
object CopyInResponse {
  val identifier: Byte = 'G'.toByte
}