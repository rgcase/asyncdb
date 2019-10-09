package dev.ryancase.asyncdb

import scala.concurrent.Future

abstract class DbClient {

  def init(): Future[Unit]

}
