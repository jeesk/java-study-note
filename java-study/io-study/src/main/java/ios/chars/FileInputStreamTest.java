package ios.chars;


import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest {
	public static void main(String[] args) throws IOException {
		FileInputStream fileInputStream = new FileInputStream("D:\\project\\java-study-note-main\\java-study\\io-study\\src\\main\\resources\\DataInputStreamTest.txt");
		StringBuilder sb = new StringBuilder();
		byte[] bytes = new byte[8];
		int len;
		while ((len = fileInputStream.read(bytes)) !=  -1){
			if(len != -1){
				sb.append(new String(bytes,0,len));
			}else{
			}
		}
		System.out.println(sb.toString());
		fileInputStream.close();
	}

}
