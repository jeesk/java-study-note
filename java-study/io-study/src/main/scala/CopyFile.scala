import java.io.{File, FileInputStream, FileOutputStream, RandomAccessFile}
import java.nio.channels.FileChannel
import java.nio.{ByteBuffer, MappedByteBuffer}
import java.util.Random
import java.util.concurrent.{CountDownLatch, Executors}

object CopyFile {
    def main(args: Array[String]): Unit = {
        testFileRandomAccess4MuiltThreadopt
    }

    // 10440
    def testChannelBuffer() {
        val startTime = System.currentTimeMillis()
        val inputStream =   new FileInputStream(new File("D:\\syncfile\\soft\\ideaIC-2021.3.1.exe"))
        val  backFile = new File("D:\\syncfile\\soft\\ideaIC-2021.3.1.exe_bak")
        if(!backFile.exists()) {
            backFile.createNewFile()
        }
        val outputStream = new FileOutputStream(backFile)

        val channel = inputStream.getChannel
        val outputStreamChannel  = outputStream.getChannel
        val buf = ByteBuffer.allocateDirect(1024 * 1024 * 100)
        var len = 0
        while (len != -1){
            len = channel.read(buf)
            if(len != -1){
                buf.flip()
                outputStreamChannel.write(buf)
                buf.clear()
            }
        }
        inputStream.close()
        outputStream.close()
        println("花费时间：" +(System.currentTimeMillis()-startTime) +"ms")
    }

    //  757ms
    def testChanneltoTransferTo {
        val startTime = System.currentTimeMillis()
        val inputStream =   new FileInputStream(new File("D:\\syncfile\\soft\\ideaIC-2021.3.1.exe"))
        val  backFile = new File("D:\\syncfile\\soft\\ideaIC-2021.3.1.exe_bak1")
        if(!backFile.exists()) {
            backFile.createNewFile()
        }
        val outputStream = new FileOutputStream(backFile)

        val channel = inputStream.getChannel
        val outputStreamChannel  = outputStream.getChannel
        channel.transferTo(0,channel.size(),outputStreamChannel)
        inputStream.close()
        outputStream.close()
        println("花费时间：" +(System.currentTimeMillis()-startTime) +"ms")
    }
//    21484ms
    def testInputStreamCopyFile()  {
        val  startTime = System.currentTimeMillis()
        val  inputStream =   new FileInputStream(new File("D:\\syncfile\\soft\\ideaIC-2021.3.1.exe"))
        val  backFile = new File("D:\\syncfile\\soft\\ideaIC-2021.3.1.exe_bak")
        if(!backFile.exists()) {
            backFile.createNewFile()
        }
        val outputStream = new FileOutputStream(backFile)
        var len = 0
        val bytes  = new Array[Byte](1024 * 1024 * 100)
        while(len != -1){
            len = inputStream.read(bytes)
            if(len != -1){
                outputStream.write(bytes,0,len)
            }
        }
        inputStream.close()
        outputStream.close()
        println("花费时间：" +(System.currentTimeMillis()-startTime) +"ms")
    }

    //    21484ms
    def testRandomAccess()  {
        val  startTime = System.currentTimeMillis()
        val  inputStream =   new FileInputStream(new File("D:\\syncfile\\soft\\ideaIC-2021.3.1.exe"))
        val  backFile = new File("D:\\syncfile\\soft\\ideaIC-2021.3.1.exe_bak")
        if(!backFile.exists()) {
            backFile.createNewFile()
        }
        val outputStream = new FileOutputStream(backFile)

        val sourceFile = new RandomAccessFile("D:\\syncfile\\soft\\ideaIC-2021.3.1.exe","rwd")
        val tarFile = new RandomAccessFile("D:\\syncfile\\soft\\ideaIC-2021.3.1.exe_bak","rwd")


        inputStream.close()
        outputStream.close()
        println("花费时间：" +(System.currentTimeMillis()-startTime) +"ms")
    }

    def testFileRandomAccess(): Unit ={
        import java.io.{FileInputStream, RandomAccessFile}
        import java.nio.channels.FileChannel
        val start = System.currentTimeMillis
        val read = new FileInputStream("D:\\syncfile\\soft\\ideaIC-2021.3.1.exe").getChannel
        val writer = new RandomAccessFile("D:\\syncfile\\soft\\ideaIC-2021.3.1.exe_5", "rw").getChannel
        var i:Long = 0
        val size = (read.size / 30)
        var bb:MappedByteBuffer = null
        var cc:MappedByteBuffer = null
        while ( {
            i < read.size && (read.size - i) > size
        }) {
            bb = read.map(FileChannel.MapMode.READ_ONLY, i, size)
            cc = writer.map(FileChannel.MapMode.READ_WRITE, i, size)
            cc.put(bb)
            i = size + i
            bb.clear()
            cc.clear()
        }
        bb = read.map(FileChannel.MapMode.READ_ONLY, i, read.size - i)
        cc = writer.map(FileChannel.MapMode.READ_WRITE, i, read.size - i)
        cc.put(bb)
        bb.clear()
        cc.clear()
        read.close()
        writer.close()
        val end = System.currentTimeMillis
        System.out.println("用时：" + (end - start) + "毫秒")
    }

    def testFileRandomAccess4MuiltThread(): Unit = {
        import java.io.{FileInputStream, RandomAccessFile}
        import java.nio.channels.FileChannel
        val start = System.currentTimeMillis
        val fileInputStream = new FileInputStream("D:\\syncfile\\soft\\ideaIC-2021.3.1.exe")
        val randomAccessFile = new RandomAccessFile("D:\\syncfile\\soft\\ideaIC-2021.3.12.exe" + new Random().nextInt(), "rws")

        val read =  fileInputStream.getChannel
        randomAccessFile.setLength(read.size)
        val writer =  randomAccessFile.getChannel

        val size:Long = (read.size / 30)
        var position:Long = 0
        while ( {
            position < read.size && (read.size - position) > size
        }) {
            val bb = read.map(FileChannel.MapMode.READ_ONLY, position, size)
            val cc = writer.map(FileChannel.MapMode.READ_WRITE, position, size)
            new Thread(() => {
                cc.put(bb)
                bb.clear()
                cc.clear()
            }).start()
            position = size + position
        }
        var bb: MappedByteBuffer = read.map(FileChannel.MapMode.READ_ONLY, position, read.size - position)
        var cc: MappedByteBuffer = writer.map(FileChannel.MapMode.READ_WRITE, position, read.size - position)
        cc.put(bb)
        bb.clear()
        cc.clear()
        read.close()
        writer.close()
        val end = System.currentTimeMillis
        System.out.println("用时：" + (end - start) + "毫秒")
    }

    def testFileRandomAccess4MuiltThreadopt(): Unit = {
        val start = System.currentTimeMillis
        val fileInputStream = new FileInputStream("D:\\syncfile\\soft\\ideaIC-2021.3.1.exe")
        val randomAccessFile = new RandomAccessFile("D:\\syncfile\\soft\\ideaIC-2021.3.12.exe" + new Random().nextInt(), "rws")
        var threadCount = 10;
        val read = fileInputStream.getChannel
        randomAccessFile.setLength(read.size)
        val writer = randomAccessFile.getChannel
        val size:Long  =
         {
            if ( (read.size % threadCount) != 0) {
                threadCount += 1
            }
            read.size / threadCount
         }
        val executors = Executors.newFixedThreadPool(threadCount)
        val countDownLatch = new CountDownLatch(threadCount)
        var position: Long = 0
        while (position < read.size) {
            val realSize = {
                if((read.size - position) > size){
                     read.size - position
                }
                size
            }
            val readerBf = read.map(FileChannel.MapMode.READ_ONLY, position, realSize)
            val writeBf = writer.map(FileChannel.MapMode.READ_WRITE, position, realSize)
            executors.submit(new Runnable {
                override def run(): Unit = {
                    writeBf.put(readerBf)
                    readerBf.clear()
                    writeBf.clear()
                    countDownLatch.countDown()
                }
            })
            position = position + realSize
        }
        countDownLatch.await()
        executors.shutdown()
        read.close()
        writer.close()
        System.out.println("用时：" + (System.currentTimeMillis - start) + "毫秒")
    }

}
