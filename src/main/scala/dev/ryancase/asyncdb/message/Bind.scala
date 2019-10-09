package dev.ryancase.asyncdb.message

// F
case class Bind(
                 destinationPortalName: String,
                 preparedStatementName: String,
                 parameterFormatCodes: Vector[Short],
                 parameterValues: Vector[Option[Parameter]],
                 resultColumnFormatCodes: ResultColumnFormatCodes)
object Bind {
  val identifier: Byte = 'B'
}

case class Parameter(value: Array[Byte])

sealed trait ResultColumnFormatCodes
case object AllBinary extends ResultColumnFormatCodes
case object AllText extends ResultColumnFormatCodes
case class ResultColumns(columns: Vector[FormatCode]) extends ResultColumnFormatCodes
