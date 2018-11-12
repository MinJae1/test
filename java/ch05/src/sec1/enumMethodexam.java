package sec1;

public class enumMethodexam {
	public static void main(String[] args) {
		Week today = Week.SUNDAY;
		String name = today.name();
		System.out.println(name);

		int ori = today.ordinal();
		System.out.println(ori);

		Week day1 = Week.MONDAY;
		Week day2 = Week.WEDNESDAY;
		int result1 = day1.compareTo(day2);
		int result2 = day2.compareTo(day1);
		System.out.println(result1);
		System.out.println(result2);

		if (args.length == 1) {
			String strDay = args[0];
			Week weekDay = Week.valueOf(strDay);
			if (weekDay == Week.SATURDAY || weekDay == Week.SUNDAY) {
				System.out.println("�ָ�");
			} else {
				System.out.println("����");
			}
		}

		Week[] days = Week.values();
		for (Week day : days) {
			System.out.println(day);
		}

	}
}
