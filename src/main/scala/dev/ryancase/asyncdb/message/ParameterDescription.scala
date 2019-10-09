package dev.ryancase.asyncdb.message

// B
case class ParameterDescription(parameterObjectIds: Vector[Int])
object ParameterDescription {
  val identifier: Byte = 't'
}
