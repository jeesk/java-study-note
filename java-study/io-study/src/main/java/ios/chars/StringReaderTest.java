package ios.chars;

import java.io.IOException;
import java.io.StringReader;

public class StringReaderTest {
	public static void main(String[] args) throws IOException {
		StringReader sr = new StringReader("hello word");
		System.out.println("跳过了多少个字符" + sr.skip(1));
		// 标记一下读取下一个字符的位置
		sr.mark(1000);
		System.out.println("读取一个字符是:" +(char)sr.read());
		// 回滚位置
		sr.reset();
		System.out.println("读取一个字符是" +(char)sr.read()+", 该字符和上一次读到的字符是相同的，说明位置被重置了");
		//下面读取llo 三个字符
		char[] chars = new char[5];
		// 从chars的index为2开始填充，填充3个字符
		sr.read(chars, 2, 3);
		System.out.println(new String(chars));
	}
}
