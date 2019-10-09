package dev.ryancase.asyncdb

import io.netty.buffer.ByteBuf
import io.netty.channel.{ChannelHandlerContext, ChannelInboundHandler}

class ChannelHandler extends ChannelInboundHandler {

  override def channelRead(ctx: ChannelHandlerContext, msg: Any): Unit = {
    msg.asInstanceOf[ByteBuf].release()
  }

}
