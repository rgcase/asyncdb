package dev.ryancase.asyncdb.message

// B
case class NegotiateProtocolVersion(minorVersion: Int, notRecognizedOptionNames: Vector[String])
object NegotiateProtocolVersion {
  val identifier: Byte = 'v'
}
