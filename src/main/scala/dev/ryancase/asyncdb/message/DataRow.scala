package dev.ryancase.asyncdb.message

// B
case class DataRow(columnValues: Vector[Option[Array[Byte]]])
object DataRow {
  val identifier: Byte = 'D'
}
