package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NIOServerDemo {
	public static void main(String[] args) throws IOException {
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.configureBlocking(false);
		Selector selector = Selector.open();
		serverSocketChannel.bind(new InetSocketAddress(9999));
		// 将serverSocketChannel的可接受事件注册到selector上面,
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		while (true) {
			int resultCode = selector.select(1000);
			if (resultCode == 0) {
				System.out.println("服务器等待吧1s, 无连接");
				continue;
			}
			Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();


			while (iterator.hasNext()) {
				try {
					SelectionKey selectionKey = iterator.next();
					// 当前事件是否可接受
					if (selectionKey.isAcceptable()) {
						System.out.println("client 连接成功" + serverSocketChannel.hashCode());
						// 拿到接受的socketChannel
						SocketChannel socketChannel = serverSocketChannel.accept();
						socketChannel.configureBlocking(false);
						// 将客户端channel的read事件注册到selector上面去
						socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
					}
					// 当前事件是否是可读事件
					if (selectionKey.isReadable()) {
						// 从channel 拿到消息
						SocketChannel channel = (SocketChannel) selectionKey.channel();
						ByteBuffer attachment = (ByteBuffer) selectionKey.attachment();
						channel.read(attachment);
						System.out.println("受到客户端信息:" + new String(attachment.array()));
					}
				} catch (Exception e) {
					System.out.println(e);
				} finally {
					// 最好别忘了移出key
					iterator.remove();
				}
			}
		}
	}
}
