package ios.writer

import java.io.{BufferedWriter, FileOutputStream, FileWriter, StringWriter}

object BufferedWriterTest {
    def main(args: Array[String]): Unit = {

       val fileWriter =  new FileWriter("D:\\project\\java-study-note-main\\java-study" +
                "\\io-study\\src\\main\\resources\\BufferedWriterTest.txt",true)
        val writer = new BufferedWriter(fileWriter)
        writer.write("hello world")
        writer.newLine()
        writer.write("Are you Chinese ? ")
        writer.newLine()
        writer.close()

    }
}
