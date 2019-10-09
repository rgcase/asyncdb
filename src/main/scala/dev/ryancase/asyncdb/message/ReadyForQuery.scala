package dev.ryancase.asyncdb.message

import java.nio.ByteBuffer

import scala.util.{Failure, Success, Try}

// B
sealed trait ReadyForQuery
object ReadyForQuery {
  val identifier: Byte = 'Z'

  def decode(bytes: ByteBuffer, length: Int): Try[ReadyForQuery] = Try(bytes.get(5).toChar).flatMap {
    case Idle.identifier => Success(Idle)
    case Transaction.identifier => Success(Transaction)
    case FailedTransaction.identifier => Success(FailedTransaction)
    case unknown =>
      Failure(new UnsupportedOperationException(s"Found unsupported ReadyForQuery status indicator: $unknown."))
  }
}

case object Idle extends ReadyForQuery {
  val identifier: Byte = 'I'
}

case object Transaction extends ReadyForQuery {
  val identifier: Byte = 'T'
}

case object FailedTransaction extends ReadyForQuery {
  val identifier: Byte = 'E'
}
