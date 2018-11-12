package ch11;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class DateTime {
	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);

		System.out.println(now.getYear() + " " + now.getMonthValue() + " "
				+ now.getDayOfMonth() + " " + now.getDayOfWeek() + " "
				+ now.getHour() + ":" + now.getMinute() + ":"
				+ now.getSecond() + ":" + now.getNano());

		LocalDate nowdat = now.toLocalDate();
		if (nowdat.isLeapYear()) {
			System.out.println("leap year");
		} else {
			System.out.println("common year");
		}

		ZonedDateTime seoul = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
		ZoneId seoulId = seoul.getZone();
		ZoneOffset seoulSet = seoul.getOffset();
		System.out.println("Seoul Id : " + seoulId);
		System.out.println("Seoul Offset : " + seoulSet);
	}
}
