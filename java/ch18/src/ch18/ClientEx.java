package ch18;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientEx {
	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket();
			System.out.println("Wait for Connection");
			socket.connect(new InetSocketAddress("localhost", 5001));
			System.out.println("Connection Successful");

			byte[] bytes = null;
			String msg = null;

			OutputStream os = socket.getOutputStream();
			msg = "Hello Server";
			bytes = msg.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("Successful data transfer");

			InputStream is = socket.getInputStream();
			bytes = new byte[100];
			int readBC = is.read(bytes);
			msg = new String(bytes, 0, readBC, "UTF-8");
			System.out.println("Successful data receive > " + msg);

			os.close();
			is.close();

		} catch (Exception e) {
			// TODO: handle exception

		}

		if (!socket.isClosed()) {
			try {
				socket.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
