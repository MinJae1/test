package ch18;

import java.util.Date;

public class PrintfExam {
	public static void main(String[] args) {
		System.out.print("%d");
		System.out.printf(" format : %d \n", 123);
		System.out.print("%5d");
		System.out.printf(" format : %5d \n", 123);
		System.out.print("%-5d");
		System.out.printf(" format : %-5d \n\n", 123);

		Date now = new Date();

		System.out.print("%tY %tm %td");
		System.out.printf(" date format : %tY . %tm . %td \n\n", now, now, now);

		System.out.print("%1$tH %1$tM %1$tS");
		System.out.printf(" time format > %1$tH : %1$tM : %1$tS \n", now);

	}
}
