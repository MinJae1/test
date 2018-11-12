package exam16;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ResidentRegistrationNumber {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String rrForm = "\\d(?:[0-9]{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[1,2][0-9]|3[0,1]))-[1-4]";

		System.out.print("insert : ");
		String rrN = scan.nextLine();

		if (rrN.length() != 8 || Pattern.matches(rrForm, rrN)) {
			if (rrN.length() != 8) {
				System.out.println(
						"Insert is different from Resident Registration Number length");
			} else if (Pattern.matches(rrForm, rrN)) {
				System.out.println(
						"Insert is different from Resident Registration Number format");
			}
		} else {
			try {
				checkRRN(rrN);
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("Only numbers and '-' can be entered.");
			}
		}

		scan.close();

	}

	private static void checkRRN(String rrN) {
		// TODO Auto-generated method stub

		String sex = "";
		if (rrN.charAt(7) == '1' || rrN.charAt(7) == '3') {
			sex = "Male";
		} else {
			sex = "Female";
		}

		String year = "";

		year = rrN.charAt(0) + "" + rrN.charAt(1);

		if (Integer.parseInt(year) <= 18) {
			year = "20" + year;
		} else {
			year = "19" + year;
		}

		String month_str = "";
		month_str = rrN.charAt(2) + "" + rrN.charAt(3);

		String day_str = "";
		day_str = rrN.charAt(4) + "" + rrN.charAt(5);

		printOutput(year, month_str, day_str, sex);

	}

	private static void printOutput(String year, String month_str,
			String day_str, String sex) {
		// TODO Auto-generated method stub

		LocalDate dayofW = LocalDate.of(Integer.parseInt(year),
				Integer.parseInt(month_str), Integer.parseInt(day_str));

		LocalDate now = LocalDate.now();

		System.out.print("Age : ");
		if (dayofW.getMonthValue() < now.getMonthValue()) {
			System.out.print(now.getYear() - dayofW.getYear() + 1 + "\n");
		} else if (dayofW.getMonthValue() == now.getMonthValue()
				&& dayofW.getDayOfMonth() < now.getDayOfMonth()) {
			System.out.print(now.getYear() - dayofW.getYear() + 1 + "\n");
		} else {
			System.out.print(now.getYear() - dayofW.getYear() + "\n");
		}

		System.out.println("Output : " + year + "." + month_str + "." + day_str
				+ " (" + dayofW.getDayOfWeek() + ") " + sex);
	}

}
