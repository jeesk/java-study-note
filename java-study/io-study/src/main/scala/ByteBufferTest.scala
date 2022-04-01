import java.nio.ByteBuffer

/**
 * 通过观察byteBuffer 的内部结构
 */
object ByteBufferTest {
    def main(args: Array[String]): Unit = {
        testByteBufferIn()

    }

    def testByteBufferIn():Unit = {
        println("开始测试testByteBufferIn-----------------------------------")
        val bf = ByteBuffer.allocateDirect(3)
        println(s"postion ${bf.position()}" +s",limit:${bf.limit}" +s",capacity:${bf.capacity}")
        bf.put(1.asInstanceOf[Byte])
        println(s"postion ${bf.position()}" +s",limit:${bf.limit}" +s",capacity:${bf.capacity}")
        bf.put(2.asInstanceOf[Byte])
        bf.put(3.asInstanceOf[Byte])
        println(s"postion ${bf.position()}" +s",limit:${bf.limit}" +s",capacity:${bf.capacity}")
        // 切换到读取模式
        bf.flip()
        println(s"postion ${bf.position()}" +s",limit:${bf.limit}" +s",capacity:${bf.capacity}")
        println(bf.get())
        println(s"postion ${bf.position()}" +s",limit:${bf.limit}" +s",capacity:${bf.capacity}")
        println(bf.get())
        println(bf.get())
        println(s"postion ${bf.position()}" +s",limit:${bf.limit}" +s",capacity:${bf.capacity}")
        println("结束testByteBufferIn-----------------------------------")
    }

    def testRewind():Unit = {
        val bf = ByteBuffer.allocateDirect(5)
        bf.put(1.asInstanceOf[Byte])
        bf.put(2.asInstanceOf[Byte])
        bf.put(3.asInstanceOf[Byte])
        bf.put(4.asInstanceOf[Byte])
        bf.flip()
        println(bf.get())
        bf.mark()
        println(bf.get())
        println(bf.get())
        bf.rewind()
        println(s"postion ${bf.position()}" +s",limit:${bf.limit}" +s",capacity:${bf.capacity}")
    }

    /**
     * rewind 和reset 区别在于rewind 是重置到第一个位置
     */
    def testMark():Unit = {
        val bf = ByteBuffer.allocateDirect(5)
        bf.put(1.asInstanceOf[Byte])
        bf.put(2.asInstanceOf[Byte])
        bf.put(3.asInstanceOf[Byte])
        bf.put(4.asInstanceOf[Byte])
        bf.flip()
        println(bf.get())
        bf.mark()
        println(bf.get())
        println(bf.get())
        bf.reset()
        println(s"postion ${bf.position()}" +s",limit:${bf.limit}" +s",capacity:${bf.capacity}")
    }

    def compactTest():Unit = {
        val bf = ByteBuffer.allocateDirect(5)
        bf.put(1.asInstanceOf[Byte])
        bf.put(2.asInstanceOf[Byte])
        bf.put(3.asInstanceOf[Byte])
        bf.put(4.asInstanceOf[Byte])
        bf.flip()
        bf.get()
        bf.get()
        // 删除已经读过的字节， 然后重新写入
        bf.compact()
        println(s"postion ${bf.position()}" +s",limit:${bf.limit}" +s",capacity:${bf.capacity}")
        bf.put(5.asInstanceOf[Byte])
        println(s"postion ${bf.position()}" +s",limit:${bf.limit}" +s",capacity:${bf.capacity}")
        bf.clear()
        // 清除bf的所有的内容
        println(s"postion ${bf.position()}" +s",limit:${bf.limit}" +s",capacity:${bf.capacity}")
    }
}
