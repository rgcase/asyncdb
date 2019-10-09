package dev.ryancase.asyncdb.message

// F & B
case class CopyData(data: Array[Byte])
object CopyData {
  val identifier: Byte = 'd'
}
