package ios.reader

import java.io.{FileInputStream, InputStreamReader}

object InputStreamReaderTest {
    def main(args: Array[String]): Unit = {
        val reader = new InputStreamReader(new FileInputStream("D:\\project\\java-study-note-main\\java-study\\io-study\\src\\main\\resources\\name.txt"))
        val arr = Array[Char](5)
        while (reader.read(arr) > 0){
            print(new String(arr))
        }
    }
}
