package ch11;

import java.time.LocalDateTime;

public class DateTimeOperatiom {
	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);

		LocalDateTime operation = now.plusYears(1).minusMonths(2)
				.plusDays(3).plusHours(4).minusMinutes(5).plusSeconds(6);

		System.out.println("Operation : " + operation);
	}
}
