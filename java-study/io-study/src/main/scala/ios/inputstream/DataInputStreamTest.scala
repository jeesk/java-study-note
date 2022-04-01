package ios.inputstream

import java.io.FileInputStream

/**
 * scala 的while 不支持赋值
 */
object DataInputStreamTest {
    def main(args: Array[String]): Unit = {
        val fileInputStream = new FileInputStream("D:\\project\\java-study-note-main\\java-study\\io-study\\src\\main\\resources\\DataInputStreamTest.txt")
       val sb = new StringBuilder()
        val arr = Array[Byte](8)
        var len = 0
        while (len !=  -1){
            len = fileInputStream.read(arr)
            if(len != -1){
                sb.append(new String(arr,0,len))
            }
        }
        fileInputStream.close()
        println(sb.toString())
    }


}
