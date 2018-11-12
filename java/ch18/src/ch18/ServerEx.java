package ch18;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEx {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("localhost", 5001));
			while (true) {
				System.out.println("Wait for Connection");
				Socket socket = serverSocket.accept();
				InetSocketAddress isa = (InetSocketAddress) socket
						.getRemoteSocketAddress();
				System.out.println("Accept Connection " + isa.getHostName());

				byte[] bytes = null;
				String msg = null;

				InputStream is = socket.getInputStream();
				bytes = new byte[100];
				int readBC = is.read(bytes);
				msg = new String(bytes, 0, readBC, "UTF-8");
				System.out.println("Successful data receive > " + msg);

				OutputStream os = socket.getOutputStream();
				msg = "Hello Client";
				bytes = msg.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("Successful data transfer");

				is.close();
				os.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (!serverSocket.isClosed()) {
			try {
				serverSocket.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}
}
