package dev.ryancase.asyncdb.message

// B
case class NoticeResponse(noticeFields: List[NoticeField])
object NoticeResponse {
  val identifier: Byte = 'N'
}

sealed trait NoticeField
case object Unknown extends NoticeField
