package ex11;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientEx {
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("localhost", 5001);
		OutputStream os = socket.getOutputStream();

		String filePath = "D:/Work Space/java/ch18/src/ex11/Lighthouse.jpg";

		File file = new File(filePath);

		String fileName = file.getName();

		FileInputStream fis = new FileInputStream(file);
//		byte[] bytes = new byte[100];
//		bytes = fileName.getBytes();

		byte[] imgBtyes = new byte[10000];

//		imgBtyes = Arrays.copyOf(bytes, 100);

		System.out.println("Start Sending File > " + fileName);
		int byteNo;
		while ((byteNo = fis.read(imgBtyes)) != -1) {
			os.write(imgBtyes, 0, byteNo);
//			os.write(imgBtyes, 0, byteNo);
		}

		os.flush();
		System.out.println("Finish Sending File");

		fis.close();
		os.close();
		socket.close();
	}
}
