package ch18;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UdpSendEx {
	public static void main(String[] args) throws Exception {
		DatagramSocket datagramSocket = new DatagramSocket();

		System.out.println("Send From");

		for (int i = 1; i < 3; i++) {
			String data = "Message " + i;
			byte[] btyeArr = data.getBytes("UTF-8");

			DatagramPacket packet = new DatagramPacket(btyeArr, btyeArr.length,
					new InetSocketAddress("localhost", 5001));

			datagramSocket.send(packet);

			System.out.println("Sending byte count > " + btyeArr.length + "byte");

		}

		System.out.println("Outgoing");

		datagramSocket.close();
	}
}
