package ch18;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReceiveEx extends Thread {
	public static void main(String[] args) throws Exception {
		DatagramSocket datagramSocket = new DatagramSocket(5001);

		Thread thread = new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Start of reception");
				try {
					DatagramPacket datagramPacket = new DatagramPacket(new byte[100],
							100);
					datagramSocket.receive(datagramPacket);

					String data = new String(datagramPacket.getData(), 0,
							datagramPacket.getLength(), "UTF-8");
					System.out.println("Receive Message ("
							+ datagramPacket.getSocketAddress() + ") >" + data);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("End of reception");
				}
			}
		};

		thread.start();

		Thread.sleep(10000);
		datagramSocket.close();
	}
}
