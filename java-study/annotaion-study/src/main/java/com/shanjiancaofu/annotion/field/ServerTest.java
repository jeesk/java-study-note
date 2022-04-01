package com.shanjiancaofu.annotion.field;

import java.util.Arrays;

public class ServerTest {
	public static void main(String[] args) {
		Server server = new Server();
		// 拿到Server类上面的注解
		server.setIpAddr("127.0.0.1");
		VersionAnnotaion va = server.getClass().getDeclaredAnnotation(VersionAnnotaion.class);
		System.out.println("Server版本:" + va.version());
		System.out.println("Server兼容的版本:" + Arrays.toString(va.compatibleVersion()));
		System.out.println("Server的ip地址:" + server.getIpAddr());
	}
}
@VersionAnnotaion(compatibleVersion = {"0.4","0.5"})
class Server{
	private String ipAddr;
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public String getIpAddr() {
		return ipAddr;
	}
}
