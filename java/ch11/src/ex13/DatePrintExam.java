package ex13;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePrintExam {
	public static void main(String[] args) {
		// 오늘의 날짜 출력
		// 0000년 00월 00일 0요일 00시 00분 형식
		Date date = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat(
				"yyyy년 MM월 dd일 E요일 HH시 mm분");

		System.out.println(sdf.format(date));
	}
}
