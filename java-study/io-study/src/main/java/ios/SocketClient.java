package ios;

import java.io.OutputStream;
import java.net.Socket;

public class SocketClient {

    public static void main(String[] args) throws Exception {
        // 要连接的服务端IP地址和端口
        String host = "127.0.0.1";
        int port = 55533;
        // 与服务端建立连接
        Socket socket = new Socket(host, port);
        // 建立连接后获得输出流
        OutputStream outputStream = socket.getOutputStream();
        String message = "《You Have Only One Life》" +

			"There are moments in life when you miss someone so much that you just want to pick them from your dreams and hug them for real! Dream what you want to dream;go where you want to go;be what you want to be,because you have only one life and one chance to do all the things you want to do." +

			"May you have enough happiness to make you sweet,enough trials to make you strong,enough sorrow to keep you human,enough hope to make you happy? Always put yourself in others’shoes.If you feel that it hurts you,it probably hurts the other person, too." +

			"The happiest of people don’t necessarily have the best of everything;they just make the most of everything that comes along their way.Happiness lies for those who cry,those who hurt, those who have searched,and those who have tried,for only they can appreciate the importance of people" +

			"who have touched their lives.Love begins with a smile,grows with a kiss and ends with a tear.The brightest future will always be based on a forgotten past, you can’t go on well in lifeuntil you let go of your past failures and heartaches." +

			"When you were born,you were crying and everyone around you was smiling.Live your life so that when you die,you're the one who is smiling and everyone around you is crying." +

			"Please send this message to those people who mean something to you,to those who have touched your life in one way or another,to those who make you smile when you really need it,to those that make you see the brighter side of things when you are really down,to those who you want to let them know that you appreciate their friendship.And if you don’t, don’t worry,nothing bad will happen to you,you will just miss out on the opportunity to brighten someone’s day with this message.我是一个完整的包";
        byte[] contentBytes = message.getBytes("UTF-8");
        System.out.println("contentBytes.length = " + contentBytes.length);
        int length = contentBytes.length;
        byte[] lengthBytes = Utils.int2Bytes(length);
        byte[] resultBytes = new byte[4 + length];
        System.arraycopy(lengthBytes, 0, resultBytes, 0, lengthBytes.length);
        System.arraycopy(contentBytes, 0, resultBytes, 4, contentBytes.length);

        for (int i = 0; i < 10; i++) {
            outputStream.write(resultBytes);
        }
        Thread.sleep(20000);
        outputStream.close();
        socket.close();
    }
}
  class Utils {
    //int数值转为字节数组
    public static byte[] int2Bytes(int i) {
        byte[] result = new byte[4];
        // 0XFF 这里的FF 表示8个11111111，
		// &运算的作用就是把两个二进制右边对齐，然后逐个&运算，只有两者都是1时结果才是1，等效于截取右边8位二进制数。
		result[0] = (byte) (i >> 24 & 0xFF);
        result[1] = (byte) (i >> 16 & 0xFF);
        result[2] = (byte) (i >> 8 & 0xFF);
        result[3] = (byte) (i & 0xFF);
        return result;
    }
    //字节数组转为int数值
    public static int bytes2Int(byte[] bytes){
        int num = bytes[3] & 0xFF;
        num |= ((bytes[2] & 0xFF) << 8);
        num |= ((bytes[1]& 0xFF0 )  << 16);
        num |= ((bytes[0] & 0xFF ) << 24 );
        return num;
    }
}
