package ios

import java.io.RandomAccessFile

object RandomAccoessFileTest {
    def main(args: Array[String]): Unit = {
        val raf = new RandomAccessFile(
            "D:\\project\\java-study-note-main\\java-study\\io-study\\src\\main\\resources\\RandomAccessFile.txt","rw")
        raf.setLength(8)
        raf.seek(0)
        raf.write('h')

        raf.seek(3)
        raf.write('e')
        raf.seek(0)
        var len  = 0
        val bytes = new Array[Byte](5)
        while (len != -1){
            len = raf.read(bytes)
            if(len != -1){
                print(new String(bytes,0,len))
            }
        }
    }

}
