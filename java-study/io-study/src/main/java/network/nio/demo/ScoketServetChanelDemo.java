package network.nio.demo;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * socketServer服务
 */
public class ScoketServetChanelDemo {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        Selector selector = Selector.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(9999));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            if (selector.select(1000) == 0) {
                System.out.println("服务器等待吧1s, 无连接");
                continue;
            }
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                // 连接事件
                if (key.isAcceptable()) {
                    System.out.println("client 连接成功" + serverSocketChannel.hashCode());
                    SocketChannel accept = serverSocketChannel.accept();
                    accept.configureBlocking(false);
                    accept.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }
                // 通过key 获得对应的channel, 反向操作
                if (key.isReadable()) {
                    SocketChannel channel = ((SocketChannel) key.channel());
                    ByteBuffer attachment = (ByteBuffer) key.attachment();
                    channel.read(attachment);
                    System.out.println("客户端数据是:" + new String(attachment.array()));
                }
                // 移除当前key(事件)
                iterator.remove();
            }
        }

    }
}
