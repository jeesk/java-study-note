package ios.reader

import java.io.{FileReader, LineNumberReader, StringReader}

/**
 * setNumber 只能修改行号不能修改流的指针
 */
object LineNumberReaderTest {
    def main(args: Array[String]): Unit = {
        val fileReader = new FileReader(
            "D:\\project\\java-study-note-main\\java-study\\io-study\\src\\main\\resources\\name.txt")
        val lineNumberReader = new LineNumberReader(fileReader)
        println(lineNumberReader.read().asInstanceOf[Char])
        println(lineNumberReader.read().asInstanceOf[Char])
        println(lineNumberReader.read().asInstanceOf[Char])
        println(lineNumberReader.readLine())
        println("行号:" + lineNumberReader.getLineNumber)
        lineNumberReader.setLineNumber(0)
        println(lineNumberReader.readLine())
        println("行号" + lineNumberReader.getLineNumber)

    }
}
