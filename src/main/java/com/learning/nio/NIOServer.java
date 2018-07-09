package com.learning.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * NIO服务端
 * */
public class NIOServer {

    /**
     * 通道管理器
     * */
    private Selector selector;

    /**
     * 获得一个ServerSocket通道，并做初始化工作
     * */
    public void initServer(int port) throws IOException {

        /**
         * 获得一个ServerSocket通道
         * */
        ServerSocketChannel channel = ServerSocketChannel.open();

        /**
         * 设置通道为非阻塞
         * */
        channel.configureBlocking(false);

        /**
         * 将通道对应的Socket绑定到port端口
         * */
        channel.socket().bind(new InetSocketAddress(port));

        /**
         * 获得一个通道管理器
         * */
        this.selector = Selector.open();

        /**
         * 将通道管理器和该通道绑定，并将该通道注册为ACCEPT事件
         * 当注册的事件到达时，selector.select()会返回
         * 如果事件没到达，selector.select()会一直阻塞
         * */
        channel.register(selector, SelectionKey.OP_ACCEPT);
    }

    /**
     * 采用轮询的方式监听selector上是否有需要处理的事件
     * 如果有，则进行处理
     * */
    @SuppressWarnings("unchecked")
    public void listen() throws IOException {

        System.out.println("服务端启动成功!");

        /**
         * 轮询访问selector
         * */
        while (true) {

            /**
             * 当注册的事件到达时，方法返回；
             * 否则，该方法会一直阻塞
             * */
            selector.select();

            /**
             * 获得selector中选中的项的迭代器，选中的项为注册的事件
             * */
            Iterator iterator = this.selector.selectedKeys().iterator();

            while (iterator.hasNext()) {
                SelectionKey key = (SelectionKey) iterator.next();

                if (key.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();

                    /**
                     * 获得与客户端连接的通道
                     * */
                    SocketChannel channel = server.accept();

                    /**
                     * 设置通道为非阻塞
                     * */
                    channel.configureBlocking(false);

                    /**
                     * 给客户端发送消息
                     * */
                    channel.write(ByteBuffer.wrap(new String("server send to client").getBytes()));

                    /**
                     * 给通道设置读的权限
                     * */
                    channel.register(this.selector, SelectionKey.OP_READ);

                } else if (key.isReadable()) {
                    read(key);
                }

                /**
                 * 删除已处理的事件，以防重复处理
                 * */
                iterator.remove();
            }
        }
    }

    /**
     * 读取客户端发来的事件
     * */
    public void read(SelectionKey key) throws IOException {

        /**
         * 得到事件发生的Socket通道
         * */
        SocketChannel channel = (SocketChannel) key.channel();

        /**
         * 创建读取的缓冲区
         * */
        ByteBuffer buffer = ByteBuffer.allocate(10);
        channel.read(buffer);
        byte[] data = buffer.array();
        String msg = new String(data).trim();
        System.out.println("Server收到信息：" + msg);

        /**
         * 将消息送回给客户端
         * */
        ByteBuffer outBuffer = ByteBuffer.wrap(msg.getBytes());
        channel.write(outBuffer);
    }

    /**
     * 启动服务器测试
     * */
    public static void main(String[] args) throws IOException {
        NIOServer server = new NIOServer();
        server.initServer(8000);
        server.listen();
    }

}
