package dev.ryancase.asyncdb.message

// F
case class Query(query: String)
object Query {
  val identifier: Byte = 'Q'
}
