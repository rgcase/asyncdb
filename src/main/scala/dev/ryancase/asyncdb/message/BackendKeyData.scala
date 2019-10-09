package dev.ryancase.asyncdb.message

import java.nio.ByteBuffer

import scala.util.Try

// B
case class BackendKeyData(processId: Int, secretKey: Int)
object BackendKeyData {
  val identifier: Byte = 'K'

  def decode(bytes: ByteBuffer, length: Int): Try[BackendKeyData] =
    Try(BackendKeyData(bytes.getInt(5), bytes.getInt(9)))
}
