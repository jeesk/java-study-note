package network.nio.demo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelDemo {
    public static void main(String[] args) throws IOException {
        // 8大buffer
        IntBuffer intBuffer = IntBuffer.allocate(5);
        for (int i = 0; i < intBuffer.capacity(); i++) {
            intBuffer.put(i * 2);
        }
        // 读写转换
        intBuffer.flip();
        while (intBuffer.hasRemaining()) {
            int i = intBuffer.get();
            System.out.println(i);
        }

        FileOutputStream fileOutputStream = new FileOutputStream("D:\\myProject\\indexlh\\src\\main\\java\\test.py");
        FileChannel channel = fileOutputStream.getChannel();
        ByteBuffer allocate = ByteBuffer.allocate(20 * 8000);
        allocate.put("hello world!!!".getBytes());
        allocate.flip();
        channel.write(allocate);
        channel.close();

        // MappedByteBuffer  内存映射修改文件
        ByteBuffer allocate1 = MappedByteBuffer.allocate(2);


    }


}
