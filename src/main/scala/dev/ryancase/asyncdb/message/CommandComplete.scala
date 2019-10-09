package dev.ryancase.asyncdb.message

// B
case class CommandComplete(tag: CommandTag)
object CommandComplete {
  val identifier: Byte = 'C'
}

sealed trait CommandTag
case class Insert(oid: Int, rows: Int) extends CommandTag
case class Delete(rows: Int) extends CommandTag
case class Update(rows: Int) extends CommandTag
case class Select(rows: Int) extends CommandTag
case class Move(rows: Int) extends CommandTag
case class Fetch(rows: Int) extends CommandTag
case class Copt(rows: Int) extends CommandTag
