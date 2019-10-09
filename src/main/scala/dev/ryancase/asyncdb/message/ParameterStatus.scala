package dev.ryancase.asyncdb.message

import java.nio.ByteBuffer

import scala.util.Try

// B
case class ParameterStatus(parameterName: String, parameterValue: String)
object ParameterStatus {
  val identifier: Byte = 'S'

  def decode(bytes: ByteBuffer, length: Int): Try[ParameterStatus] = Try {
    val key = new StringBuilder()

    var index = 4
    var byte = bytes.get(index)
    while (byte != '\u0000') {
      key.addOne(byte.toChar)
      index += 1
      byte = bytes.get(index)
    }

    val value = new StringBuilder()
    index += 1
    byte = bytes.get(index)
    while (byte != '\u0000') {
      value.addOne(byte.toChar)
      index += 1
      byte = bytes.get(index)
    }

    ParameterStatus(key.toString(), value.toString())
  }
}
