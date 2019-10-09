package dev.ryancase.asyncdb.message

sealed trait FormatCode
case object Text extends FormatCode {
  val identifier: Short = 0
}
case object Binary extends FormatCode {
  val identifier: Short = 1
}
