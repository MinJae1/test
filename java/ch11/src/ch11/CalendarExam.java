package ch11;

import java.util.Calendar;

public class CalendarExam {
	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();

		int week = now.get(Calendar.DAY_OF_WEEK);
		String strWeek = null;
		switch (week) {
		case Calendar.MONDAY:
			strWeek = "월";
			break;
		case Calendar.TUESDAY:
			strWeek = "화";
			break;
		case Calendar.WEDNESDAY:
			strWeek = "수";
			break;
		case Calendar.THURSDAY:
			strWeek = "목";
			break;
		case Calendar.FRIDAY:
			strWeek = "금";
			break;
		case Calendar.SATURDAY:
			strWeek = "토";
			break;

		default:
			strWeek = "일";
			break;
		}

		int amPm = now.get(Calendar.AM_PM);
		String strampm = null;
		if (amPm == Calendar.AM) {
			strampm = "오전";
		} else {
			strampm = "오후";
		}

		System.out
				.println(now.get(Calendar.YEAR) + "년 " + now.get(Calendar.MONTH) + "월 " + now.get(Calendar.DATE) + "일");
		System.out.println(strWeek + "요일");
		System.out.println(strampm + " " + now.get(Calendar.HOUR) + "시 " + now.get(Calendar.MINUTE) + "분 "
				+ now.get(Calendar.SECOND));
	}
}
