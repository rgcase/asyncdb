package dev.ryancase.asyncdb.message

import java.nio.ByteBuffer

import dev.ryancase.asyncdb.message.Message.MessageSerializer

sealed trait ProtocolVersion { def intValue: Int }
case object Version30 extends ProtocolVersion {
  val intValue = 196608
}

// F
case class StartupMessage(
  protocolVersion: ProtocolVersion,
  user: String,
  database: Option[String] = None) extends Message

object StartupMessage {
  private val charsetName = "ascii"
  private val nullByte = '\u0000'.toByte
  private val userBytes = "user".getBytes(charsetName)
  private val databaseBytes = "database".getBytes(charsetName)

  implicit val serializer: MessageSerializer[StartupMessage] = msg => {
    // 4 (message length)
    // + 4 (protocol version)
    // + 4 ("user" string)
    // + 1 null byte
    // + length of user argument
    // + 1 null byte
    // [+ optionally length of "database" string + 1 null byte + length of database argument + 1 null byte]
    // + 1 null byte
    val size = 15 + msg.user.length + msg.database.map(db => 10 + db.length).getOrElse(0)

    val buffer = ByteBuffer.allocate(size)
      .putInt(size)
      .putInt(msg.protocolVersion.intValue)
      .put(userBytes)
      .put(nullByte)
      .put(msg.user.getBytes(charsetName))
      .put(nullByte)

    msg.database.foreach { db =>
      buffer.put(databaseBytes)
      buffer.put(nullByte)
      buffer.put(db.getBytes(charsetName))
      buffer.put(nullByte)
    }

    buffer.put(nullByte).array()
  }
}
