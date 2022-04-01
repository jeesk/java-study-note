import java.io.FileInputStream
import java.nio.ByteBuffer


object FileChannelTest {
    def main(args: Array[String]): Unit = {
        val fis = new FileInputStream("D:\\project\\java-study-note-main\\java-study\\io-study\\src\\main\\resources\\FileChannelTest")
        val channel = fis.getChannel
        val bf = ByteBuffer.allocateDirect(12)
        var len = 0
        while (len != -1){
            // bf.limit == len
            len = channel.read(bf)
            if(len != -1){
                bf.flip()
                val bytes = new Array[Byte](len)
                bf.get(bytes,0,len)
                println(new String(bytes, 0, len))
            }
            bf.clear()
        }
        channel.close()
        fis.close()


    }

}
