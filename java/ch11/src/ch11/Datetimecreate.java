package ch11;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class Datetimecreate {
	public static void main(String[] args) throws InterruptedException {
		LocalDate currdate = LocalDate.now();
		System.out.println("Today : " + currdate);

		LocalDate tget = LocalDate.of(2024, 5, 10);
		System.out.println("target : " + tget);
		System.out.println();

		LocalTime currTime = LocalTime.now();
		System.out.println("now time : " + currTime);

		LocalTime tagetT = LocalTime.of(6, 30, 0, 0);
		System.out.println("Target Time : " + tagetT);
		System.out.println();

		LocalDateTime dattime = LocalDateTime.now();
		System.out.println("Today & Time : " + dattime);

		LocalDateTime targetdattime = LocalDateTime.now();
		System.out.println("target day & Time : " + targetdattime);
		System.out.println();

		ZonedDateTime utc = ZonedDateTime.now(ZoneId.of("UTC"));
		System.out.println("World time : " + utc);

		ZonedDateTime nyTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
		System.out.println("New York Time : " + nyTime);
		System.out.println();

		// timestamp
		Instant ins1 = Instant.now();
		Thread.sleep(10);
		Instant ins2 = Instant.now();

		if (ins1.isBefore(ins2)) {
			System.out.println("ins1");
		} else if (ins1.isAfter(ins2)) {
			System.out.println("ins2");
		} else {
			System.out.println("same time");
		}

		System.out.println("nanos : " + ins1.until(ins2, ChronoUnit.NANOS));
	}
}
