package ch18;

import java.io.OutputStream;

public class SystemOutExam {
	public static void main(String[] args) throws Exception {
		OutputStream outputStream = System.out;

		for (byte b = 48; b < 58; b++) {
			outputStream.write(b);
		}
		outputStream.write(10);

		String hangul = "�����ٶ󸶹ٻ������īŸ����";
		byte[] hangulByte = hangul.getBytes();
		outputStream.write(hangulByte);

		outputStream.flush();
	}
}
