package dev.ryancase.asyncdb.state;

abstract class ClientState {
  enum State {
    INITIALIZATION,
    AUTHENTICATION,
    ACTIVE,
    CLOSED
  }

}