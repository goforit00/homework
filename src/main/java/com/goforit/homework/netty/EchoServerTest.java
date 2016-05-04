package com.goforit.homework.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * Created by junqingfjq on 16/4/28.
 */
public class EchoServerTest {

    private final int port=18888;

    public void start(){

        NioEventLoopGroup group=new NioEventLoopGroup();
        try {

            ServerBootstrap b=new ServerBootstrap();
            b.group(group)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {

                            ch.pipeline().addLast(new EchoServerHandler());
                        }
                    });

            ChannelFuture f=b.bind().sync();
            System.err.println(EchoServerTest.class.getName() + " started and listen on " + f.channel().localAddress());
            f.channel().closeFuture().sync();
            System.err.println("sync end.");

        }catch (Exception e){

        }
    }


    public static void main(String[] args){
        new EchoServerTest().start();
    }


}
