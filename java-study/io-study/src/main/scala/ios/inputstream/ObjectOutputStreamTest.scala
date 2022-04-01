package ios.inputstream

import java.io.{File, FileInputStream, FileOutputStream, ObjectInputStream}
import java.util

object ObjectOutputStreamTest {
    def main(args: Array[String]): Unit = {
        val file = new File("D:\\project\\java-study-note-main\\java-study\\io-study\\src\\main\\resources\\ObjectOutputStreamTest.abc")
        if(!file.exists()) {
            file.createNewFile()
        }

        val outStream = new  java.io.ObjectOutputStream (new FileOutputStream(file))
        val list = new util.ArrayList[String]()

        list.add("hello")
        list.add("word")
        outStream.writeObject(list)
        outStream.close()
        val inputStream = new ObjectInputStream(new FileInputStream(file))
        val myList = inputStream.readObject().asInstanceOf[util.ArrayList[String]]
        println(myList.toString)
    }
}
