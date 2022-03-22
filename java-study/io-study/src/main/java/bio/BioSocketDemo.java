package bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BioSocketDemo {
    public static void main(String[] args) {


        ExecutorService executorService = Executors.newFixedThreadPool(10);
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            System.out.println("服务器启动了");
            while (true) {
                // 阻塞
                final Socket accept = serverSocket.accept();
                System.out.println("连接到一个客户端");
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        handle4broswer(accept);
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public static void handle4broswer(Socket socket) {
        byte[] bytes = new byte[10000];
        long id = Thread.currentThread().getId();
        String name = Thread.currentThread().getName();
        String prefix = id + ":" + name + "-> ";
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            StringBuilder stringBuilder = new StringBuilder();
            int read = inputStream.read(bytes);
            stringBuilder.append(new String(bytes, 0, read));
            System.out.println(prefix + stringBuilder.toString());
            outputStream.write(("<html>" + prefix + stringBuilder.toString() + "</html>").getBytes());
            outputStream.flush();
        } catch (IOException e) {
            System.out.println(prefix + "关闭");
        } finally {
            try {
                socket.close();
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
