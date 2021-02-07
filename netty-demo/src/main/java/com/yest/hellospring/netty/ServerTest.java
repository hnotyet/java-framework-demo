package com.yest.hellospring.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.epoll.Epoll;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.epoll.EpollServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * @author :yest
 * @copyright: taofen8
 * @date: 2020/10/27
 */
public class ServerTest {

  public static void main(String[] args) throws IOException {

  }

  public void start(int port) throws Exception {
    EpollEventLoopGroup parentGroup = new EpollEventLoopGroup(); // 新建一个Epoll监听事件轮询组
    EpollEventLoopGroup childGroup = new EpollEventLoopGroup(); // 新建一个Epoll处理连接的事件轮询组Epoll
    try {
      ServerBootstrap b = new ServerBootstrap();
      b.group(parentGroup, childGroup) //将parent，child赋值给服务器引导
          .channel(EpollServerSocketChannel.class) //设置服务端通道为EpollServer类型
          .localAddress(new InetSocketAddress(port)) //设置绑定的服务端地址
          .childHandler(new ChannelInitializer<SocketChannel>() { // 初始化处理每个客户端io的通道
            @Override
            public void initChannel(SocketChannel ch)
                throws Exception {
              ch.pipeline().addLast(new EchoServer()); // 设置编解码类
            }
          });


      ChannelFuture f = b.bind().sync(); // 开始服务的入口函数（下面在源码解析的时候提及）
      System.out.println(EchoServer.class.getName() + " started and listen on "
          + f.channel().localAddress());
      f.channel().closeFuture().sync(); // 关闭服务通道
    } finally {
      parentGroup.shutdownGracefully().sync(); // 优雅地关闭事件轮询组
      childGroup.shutdownGracefully().sync(); // 优雅地关闭事件轮询组
    }
  }

  class EchoServer implements ChannelHandler {

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
      ctx.fireChannelRegistered();
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

    }
  }

}
