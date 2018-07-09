package com.learning.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NIOClient {

    private Selector selector;

    public void initClient(String ip, int port) throws IOException {

        SocketChannel channel = SocketChannel.open();

        channel.configureBlocking(false);

        this.selector = Selector.open();

        /**
         * 客户端连接服务端
         * 其实方法执行并没有真正实现连接，需在listen()方法中调用channel.finishConnect()才能完成连接
         * */
        channel.connect(new InetSocketAddress(ip, port));

        channel.register(selector, SelectionKey.OP_CONNECT);
    }

    @SuppressWarnings("unchecked")
    public void listen() throws IOException {

        while (true) {
            selector.select();

            Iterator iterator = this.selector.selectedKeys().iterator();

            while (iterator.hasNext()) {
                SelectionKey key = (SelectionKey) iterator.next();

                if (key.isConnectable()) {
                    SocketChannel channel = (SocketChannel) key.channel();

                    /**
                     * 如果正在连接，则完成连接
                     * */
                    if (channel.isConnectionPending()) {
                        channel.finishConnect();
                    }

                    channel.configureBlocking(false);

                    /**
                     * 给服务端发送消息
                     * */
                    channel.write(ByteBuffer.wrap(new String("client send to server").getBytes()));

                    channel.register(selector, SelectionKey.OP_READ);

                } else if (key.isReadable()) {
                    read(key);
                }

                iterator.remove();
            }
        }
    }

    public void read(SelectionKey key) throws IOException {

        SocketChannel channel = (SocketChannel) key.channel();

        ByteBuffer buffer = ByteBuffer.allocate(10);
        channel.read(buffer);
        byte[] data = buffer.array();
        String msg = new String(data).trim();
        System.out.println("Client收到信息：" + msg);

        ByteBuffer outBuffer = ByteBuffer.wrap(msg.getBytes());
        channel.write(outBuffer);
    }

    public static void main(String[] args) throws IOException {
        NIOClient client = new NIOClient();
        client.initClient("localhost", 8000);
        client.listen();
    }
}
