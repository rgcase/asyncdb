package dev.ryancase.asyncdb.message

// F
case class Execute(portalName: String, maxRows: Int)
object Execute {
  val identifier: Byte = 'E'.toByte
}
