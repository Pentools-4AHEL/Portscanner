package scanner;

import java.io.IOException;
import java.net.Socket;

public class PortScanner {

	private static Socket s;

	public static void main(String[] args) {
		
		if (args.length>0) {
			System.out.println("Starting Portscan on IP: "+args[0]);
			for (int port = 0; port < 255; port++) {
				scanPort(args[0], port);
			}
		} else {
			System.out.println("Please specify a valid IP as first agrument.");
		}

	}

	private static void scanPort(String ip, int port) {
		new Thread(() -> {
			try {
				s = new Socket(ip, port);
				System.out.println("  Port: " + port);
			} catch (IOException e) {
			}
		}).start();
	}



}
