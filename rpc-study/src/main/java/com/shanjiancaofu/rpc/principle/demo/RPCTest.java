package com.shanjiancaofu.rpc.principle.demo;

import java.io.IOException;
import java.net.InetSocketAddress;

public class RPCTest {

	public static void main(String[] args) throws IOException {
		new Thread(() -> {
			try {
				Server serviceServer = new ServiceCenter(6258);
				serviceServer.register(HelloService.class, HelloServiceImpl.class);
				serviceServer.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();
		HelloService service = RPCClient.getRemoteProxyObj(HelloService.class, new InetSocketAddress("localhost", 6258));
		System.out.println(service.sayHi("test"));
	}
}
