package ex13;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePrintExam {
	public static void main(String[] args) {
		// ������ ��¥ ���
		// 0000�� 00�� 00�� 0���� 00�� 00�� ����
		Date date = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat(
				"yyyy�� MM�� dd�� E���� HH�� mm��");

		System.out.println(sdf.format(date));
	}
}
