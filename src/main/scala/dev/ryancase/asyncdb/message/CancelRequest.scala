package dev.ryancase.asyncdb.message

// F
case class CancelRequest(processId: Int, secretKey: Int)
object CancelRequest {
  val requestCode: Int = 80877102
}
