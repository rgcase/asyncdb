package dev.ryancase.asyncdb.message

// B
case class NotificationResponse(processId: Int, channelName: String, payload: String)
object NotificationResponse {
  val identifier: Byte = 'A'
}
