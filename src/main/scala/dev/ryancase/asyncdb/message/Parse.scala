package dev.ryancase.asyncdb.message

// F
case class Parse(
                preparedStatementName: String,
                queryString: String,
                parameterTypeObjectIds: Vector[Int])
object Parse {
  val identifier: Byte = 'P'
}
