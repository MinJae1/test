package ch18;

import java.net.InetAddress;

public class InetAddressEx {
	public static void main(String[] args) {
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			System.out
					.println("Local Host Address > " + inetAddress.getHostAddress());

			InetAddress[] iaArr = InetAddress.getAllByName("www.naver.com");
			for (InetAddress inetAddress2 : iaArr) {
				System.out.println(
						"Naver IP Address > " + inetAddress2.getHostAddress());
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
