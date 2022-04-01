package ios.chars;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class LineNumberReaderTestj {
	public static void main(String[] args) throws IOException {
		FileReader fileReader = new FileReader(
			"D:\\project\\java-study-note-main\\java-study\\io-study\\src\\main\\resources\\name.txt");
		LineNumberReader lineNumberReader = new LineNumberReader(fileReader);
		char[] arr = new char[100];
		System.out.println(((char) fileReader.read()));
		System.out.println((char)fileReader.read());
		System.out.println((char)fileReader.read());
		System.out.println((char)fileReader.read());
		System.out.println((char)fileReader.read());
	}
}
