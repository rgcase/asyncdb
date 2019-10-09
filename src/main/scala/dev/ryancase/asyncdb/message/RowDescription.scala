package dev.ryancase.asyncdb.message

// B
case class RowDescription(fields: Vector[Field])
object RowDescription {
  val identifier: Byte = 'T'
}

case class Field(
                  name: String,
                  objectId: Int,
                  attributeNumber: Short,
                  dataTypeObjectId: Int,
                  dataTypeSize: Short,
                  typeModifier: Int,
                  formatCode: FormatCode)
