package ios;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest1 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("D:\\project\\java-study-note-main\\java-study\\io-study\\src\\main\\resources\\FileChannelTest");
		FileChannel channel = fis.getChannel();
		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(8);
		int len = 0;
		while((len =channel.read(byteBuffer)) != -1){
			byteBuffer.flip();
			byte[] bytes = new byte[byteBuffer.limit()];
			byteBuffer.get(bytes, 0, bytes.length);
			System.out.println(new String(bytes,0,bytes.length));
			byteBuffer.clear();
		}
	}

}
