package ios.inputstream

import java.io.{File, FileInputStream, SequenceInputStream}

/**
 * 顺序合并流
 */
object SequenceInputStreamTest {
    def main(args: Array[String]): Unit = {
        val file1 = new File("D:\\project\\java-study-note-main\\java-study\\io-study\\src\\main\\resources\\ins1")
        val file2 = new File("D:\\project\\java-study-note-main\\java-study\\io-study\\src\\main\\resources\\ins2")
        val ins1 = new FileInputStream(file1)
        val ins2 = new FileInputStream(file2)
        val sInput  = new SequenceInputStream(ins1,ins2)
        var len = 0
        val bytes = new Array[Byte](10)
        while (len != -1){
            len = sInput.read(bytes)
            if(len != -1){
                println(new String(bytes, 0, len))
            }
        }
        sInput.close()

    }
}
