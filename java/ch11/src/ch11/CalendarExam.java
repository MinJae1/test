package ch11;

import java.util.Calendar;

public class CalendarExam {
	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();

		int week = now.get(Calendar.DAY_OF_WEEK);
		String strWeek = null;
		switch (week) {
		case Calendar.MONDAY:
			strWeek = "��";
			break;
		case Calendar.TUESDAY:
			strWeek = "ȭ";
			break;
		case Calendar.WEDNESDAY:
			strWeek = "��";
			break;
		case Calendar.THURSDAY:
			strWeek = "��";
			break;
		case Calendar.FRIDAY:
			strWeek = "��";
			break;
		case Calendar.SATURDAY:
			strWeek = "��";
			break;

		default:
			strWeek = "��";
			break;
		}

		int amPm = now.get(Calendar.AM_PM);
		String strampm = null;
		if (amPm == Calendar.AM) {
			strampm = "����";
		} else {
			strampm = "����";
		}

		System.out
				.println(now.get(Calendar.YEAR) + "�� " + now.get(Calendar.MONTH) + "�� " + now.get(Calendar.DATE) + "��");
		System.out.println(strWeek + "����");
		System.out.println(strampm + " " + now.get(Calendar.HOUR) + "�� " + now.get(Calendar.MINUTE) + "�� "
				+ now.get(Calendar.SECOND));
	}
}
