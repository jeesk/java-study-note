package ios.chars;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class BufferReaderTest {
	public static void main(String[] args) throws IOException {
		testRead4Once();

	}

	/**
	 * 在BufferedReader上调用mark（）时，它将开始将从该点读取的数据向前保存在其内部缓冲区中。
	 * 当调用reset（）时，它将跳回流的标记位置，因此下一次读取（）将由内存缓冲区满足。
	 * 当您读取超过该缓冲区的末尾时，它将无缝地返回到读取新数据。
	 * BufferedInputStream以同样的方式工作。
	 *
	 *
	 *
	 * 要标记的int参数告诉它希望能够向后移动的最大字符数（对于BufferedReader）
	 * 或字节数（对于BufferedInputStream）。
	 * 如果读取的数据超过标记位置太多，则标记可能会“失效”，调用reset（）将失败，并出现异常。
	 * @throws IOException
	 */
	public static void testMarkAndReadMethod() throws IOException {
		BufferedReader r = new BufferedReader(new StringReader(
			"Happy Birthday1\n" +
				"Happy Birthday2"));
		r.mark(8);
		System.out.println("第一次读取" + r.readLine());
		r.reset();
		r.mark(32);
		System.out.println("第二次读取" + r.readLine());
		System.out.println("第三次读取" + r.readLine());
		r.reset();
		System.out.println("第四次读取" + r.readLine());
	}

	/**
	 * read 只能读一次， 读完后， 不能再读了
	 * @throws IOException
	 */
	public static void testRead4Once() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new StringReader("hello"));
		char[] chars1 = new char[5];
		char[] chars2 = new char[5];
		bufferedReader.read(chars1);
		bufferedReader.read(chars2);
		System.out.println("第一次读取: " + new String(chars1));
		System.out.println("第二次读取" + new String(chars2));
	}

	/**
	 * 读取单个字符
	 * @throws IOException
	 */
	public void readSingleChar() throws IOException {
		// 读取一个字符
		BufferedReader hello_world = new BufferedReader(new StringReader("hello world"));
		System.out.println("读取一个字符" + (char) hello_world.read());
	}
}
