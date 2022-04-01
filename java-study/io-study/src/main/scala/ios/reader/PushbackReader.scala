package ios.reader

import java.io.{PushbackReader, StringReader}

object PushbackReader {
    def main(args: Array[String]): Unit = {
        // 这里设置默认的缓存区大小
        val reader = new PushbackReader(new StringReader("helloworld"),2)
        println(reader.read().asInstanceOf[Char])
        println(reader.read().asInstanceOf[Char])
        println(reader.read().asInstanceOf[Char])
        // 在前面三个char的后面的位置插入2 个char
        val arr = Array[Char]('1','2')
        // 这里回推的长度不能大于缓存区长度
        reader.unread(arr,0,2)
        println(reader.read().asInstanceOf[Char])
        println(reader.read().asInstanceOf[Char])
        println(reader.read().asInstanceOf[Char])
        println(reader.read().asInstanceOf[Char])
        println(reader.read().asInstanceOf[Char])
        println(reader.read().asInstanceOf[Char])
        println(reader.read().asInstanceOf[Char])
    }
}
