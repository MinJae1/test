package ex11;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEx {
	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket();
		serverSocket.bind(new InetSocketAddress("localhost", 5001));

		System.out.println("Server Start");
		String targetpath = "C:/temp/copy_Lighthouse.jpg";

		while (true) {
			try {
				Socket socket = serverSocket.accept();
				InputStream is = socket.getInputStream();

				byte[] bytes = new byte[2000];

				FileOutputStream fos = new FileOutputStream(targetpath);
				int readBC = -1;

//				is.read(bytes, 0, 100);
//				String fileName = new String(bytes, 0, 100, "UTF-8");
				String fileName = "";
//				fileName = fileName.trim();

				System.out.println("Starting Receive File > " + fileName);
				while ((readBC = is.read(bytes)) != -1) {
//					fos.write(bytes, 100, readBC);
					fos.write(bytes, 0, readBC);
				}

				fos.flush();
				System.out.println("Finish Receiving File");

				fos.close();
				is.close();
				socket.close();
			} catch (Exception e) {
				// TODO: handle exception
				break;
			}
		}

		serverSocket.close();
		System.out.println("Disconnecting Server");

	}
}
