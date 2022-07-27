package com.pandy.netty.guide;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class DiscardServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        // 打印接受的消息
        //        ByteBuf  in = (ByteBuf) msg;
//        try {
//            while (in.isReadable()) {
//                System.out.println((char)in.readByte());
//                System.out.flush();
//            }
//        }finally {
//            ReferenceCountUtil.release(msg);
//        }

        ctx.write(msg);
        ctx.flush();


    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
