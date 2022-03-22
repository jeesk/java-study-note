package nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * socket clilent 连接server
 */
public class NIOClientDemo {
    public static void main(String[] args) throws Exception {

        // 创建SocketChannel, 并且连接本地9999 端口
        SocketChannel socketChannel = SocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress("192.168.31.31", 9999);
        socketChannel.configureBlocking(false);
        if (!socketChannel.connect(inetSocketAddress)) {
            while (!socketChannel.finishConnect()) {
                System.out.println("连接需要时间");
            }
        }
        System.out.println("连接server成功");
        // 发server端发送消息
        String str = "hello world";
        ByteBuffer wrap = ByteBuffer.wrap(str.getBytes(StandardCharsets.UTF_8));
        int write = socketChannel.write(wrap);
        // 挂起程序
        System.in.read();
    }
}
