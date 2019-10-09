package dev.ryancase.asyncdb.message

trait Message

object Message {
  type MessageSerializer[M <: Message] = M => Array[Byte]
  type MessageDeserializer[M <: Message] = Array[Byte] => Option[M]
}
