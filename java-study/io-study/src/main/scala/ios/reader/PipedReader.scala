package ios.reader

import java.io.{PipedReader, PipedWriter}

object PipedReader {
    def main(args: Array[String]): Unit = {
        val writer = new PipedWriter()
        val reader = new PipedReader()
        reader.connect(writer)
        writer.write(Array('h', 'e'))
        writer.flush()
        val chars = new Array[Char](5)
        reader.read(chars)
        println(new String(chars))
        writer.write(Array('j'))
        reader.read(chars)
        println(new String(chars))

    }
}
