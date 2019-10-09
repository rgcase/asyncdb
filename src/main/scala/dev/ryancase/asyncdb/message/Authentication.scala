package dev.ryancase.asyncdb.message

import java.nio.ByteBuffer

import scala.util.{Failure, Success, Try}

// B
sealed trait Authentication
object Authentication {
  val identifier: Byte = 'R'

  // Assumes the message has an identifier byte and 4 length bytes, with the message itself starting
  // on the 5th byte.
  def decode(bytes: ByteBuffer, length: Int): Try[Authentication] = Try(bytes.getInt(5)).flatMap {
    case AuthenticationOk.identifier => Success(AuthenticationOk)
    case AuthenticationKerberosV5.identifier => Success(AuthenticationKerberosV5)
    case AuthenticationCleartextPassword.identifier => Success(AuthenticationCleartextPassword)
    case AuthenticationMD5Password.identifier => {
      val saltBytes = new Array[Byte](4)
      Try(bytes.get(saltBytes, 9, 4)).map(_ => AuthenticationMD5Password(saltBytes))
    }
    case AuthenticationSCCredential.identifier => Success(AuthenticationSCCredential)
    case AuthenticationGSS.identifier => Success(AuthenticationGSS)
    case AuthenticationGSSContinue.identifier => Success(AuthenticationGSSContinue)
    case AuthenticationSSPI.identifier => Success(AuthenticationSSPI)
    case AuthenticationSASL.identifier =>
      Failure(new UnsupportedOperationException("AuthenticationSASL is unsupported."))
    case AuthenticationSASLContinue.identifier =>
      Failure(new UnsupportedOperationException("AuthenticationSASL is unsupported."))
    case AuthenticationSASLFinal.identifier =>
      Failure(new UnsupportedOperationException("AuthenticationSASL is unsupported."))
    case unknown =>
      Failure(new UnsupportedOperationException(s"Unsupported authentication request with identifier $unknown"))
  }
}

case object AuthenticationOk extends Authentication {
  val identifier: Int = 0
}

case object AuthenticationKerberosV5 extends Authentication {
  val identifier: Int = 2
}

case object AuthenticationCleartextPassword extends Authentication {
  val identifier: Int = 3
}

case class AuthenticationMD5Password(salt: Array[Byte]) extends Authentication
object AuthenticationMD5Password {
  val identifier: Int = 5
}

case object AuthenticationSCCredential extends Authentication {
  val identifier: Int = 6
}

case object AuthenticationGSS extends Authentication {
  val identifier: Int = 7
}

case object AuthenticationGSSContinue extends Authentication {
  val identifier: Int = 8
}

case object AuthenticationSSPI extends Authentication {
  val identifier: Int = 9
}

case class AuthenticationSASL(authenticationMechanisms: Vector[String]) extends Authentication
object AuthenticationSASL {
  val identifier: Int = 10
}

case class AuthenticationSASLContinue(saslData: Array[Byte]) extends Authentication
object AuthenticationSASLContinue {
  val identifier: Int = 11
}

case class AuthenticationSASLFinal(saslData: Array[Byte]) extends Authentication
object AuthenticationSASLFinal {
  val identifier: Int = 12
}
