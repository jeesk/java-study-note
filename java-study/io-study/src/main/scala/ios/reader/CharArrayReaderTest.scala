package ios.reader

import java.io.CharArrayReader

object CharArrayReaderTest {
    def main(arges : Array[String]):Unit = {
        val arr: Array[Char] = Array('1', '2', '3','4')
        val charArrayReader = new CharArrayReader(arr)
        charArrayReader.mark(10)
        println(charArrayReader.read())
        charArrayReader.reset()
        charArrayReader.skip(1)
        println(charArrayReader.read())
    }
}
