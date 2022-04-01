package ios;


import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SocketServer {
	private final static int headerLength = 4;
    public static void main(String[] args) throws IOException {
        // 监听指定的端口
        int port = 55533;
        ServerSocket server = new ServerSocket(port);
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		// server将一直等待连接的到来
        System.out.println("server将一直等待连接的到来");

        // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
        while (true){
        	try{
				final Socket socket = server.accept();
				executorService.execute(new Process(socket));
			}catch (java.lang.Exception e){
				System.out.println(e);
			}

		}
    }

    static class Process implements Runnable{
		private Socket socket;
		public Process(Socket socket){
			this.socket = socket;
		}
		@Override
		public void run() {
			byte[] bytes = new byte[124];
			int len = 0;
			int totalLength = 0;
			byte[] totalBytes = new byte[]{};

			// 这里处理要考虑两种情况，一次read 里面有多个消息， 多个read 组合一条消息

			try(InputStream inputStream = socket.getInputStream()){
				while ((len = inputStream.read(bytes)) != -1){
					int tempLength = totalLength;
					totalLength = totalLength + len;

					byte[] tempBytes = totalBytes;
					totalBytes = new byte[totalLength];

					// 复制以前的数据
					System.arraycopy(tempBytes,0,totalBytes,0,tempLength);
					// 复制现在的数据
					System.arraycopy(bytes, 0, totalBytes, tempLength, len);

					while (totalLength > 4) {
						// 取出头长度
						byte[] headLenght = new byte[4];
						System.arraycopy(totalBytes, 0, headLenght, 0, 4);
						int contentLenght = Utils.bytes2Int(headLenght);
						if (totalLength < contentLenght + 4) {
							// 跳出循环继续读取下一次
							break;
						}
						// 读取完整数据
						byte[] contentByteArr = new byte[contentLenght];
						System.arraycopy(totalBytes, 4, contentByteArr, 0, contentLenght);

						String content = new String(contentByteArr, "UTF-8");
						System.out.println("contentLength = " + contentLenght + ", content: " + content);

						// 处理剩余数据
						totalLength -= (contentLenght + 4);
						byte[] leftBytes = new byte[totalLength];
						System.arraycopy(totalBytes, contentLenght + 4, leftBytes, 0, totalLength);
						totalBytes = leftBytes;
					}

				}

			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try{
					socket.close();
				}catch (IOException e){
					System.out.println(e);
				}
			}
		}
	}
}
