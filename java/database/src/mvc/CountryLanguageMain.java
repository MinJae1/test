package mvc;

import java.util.List;
import java.util.Scanner;

public class CountryLanguageMain {
	static CountryLanguageDAO clDao = new CountryLanguageDAO();
	static CountryLanguageDTO clDto = new CountryLanguageDTO();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
//		boolean run = true;
		String key = "";
//		while (run) {
			System.out.println("* * * * * * * * * * menu * * * * * * * * *");
			System.out.println("1.select 2.insert 3.update 4.delete");
			System.out.print(">> ");
			try {
				key = sc.next();

			} catch (Exception e) {
				// TODO: handle exception
				sc = new Scanner(System.in);
			}

			switch (key) {
			case "2":
				insert();
				break;
			case "3":
				Update();
				break;
			case "4":
				Delete();
				break;
			case "1":
				select();
				break;
//			case "5":
//				run = false;
//				break;
			}
//		}
//		System.out.println("end");

	}

	private static void select() {
		// TODO Auto-generated method stub
		System.out.println("Select \n1.one 2.list");
		System.out.print(">> ");
		String inp = sc.next();

		switch (inp) {
		case "1":
			selectOne();
			break;
		case "2":
			SelectAll();
			break;
		}
	}

	private static void SelectAll() {
		// TODO Auto-generated method stub
		/* selectAll */
		System.out.println("select all");
		System.out.print("View Language about CountryCode >> ");
		String cc = sc.next();

		List<CountryLanguageDTO> cllist = clDao.selectconLan(cc);
		for (CountryLanguageDTO countryLanguageDTO : cllist) {
			System.out.println(countryLanguageDTO.toString());
		}
		System.out.println();
	}

	private static void selectOne() {
		// TODO Auto-generated method stub
		/* selectone */
		System.out.println("select one");
		System.out.print("select Country Code >> ");
		String cc = sc.next();
		System.out.print("select Language >> ");
		String lan = sc.next();

		clDto.setCc(cc);
		clDto.setLan(lan);

		clDao.selectOneconLan(clDto);
		System.out.println(clDto.toString());
		System.out.println();
	}

	private static void Delete() {
		// TODO Auto-generated method stub

		/* Delete */
		System.out.println("delete");
		System.out.print("select Country Code >> ");
		String cc = sc.next();
		System.out.print("select Language >> ");
		String lan = sc.next();

		clDto.setCc(cc);
		clDto.setLan(lan);

		clDao.deleteconLan(clDto);
		System.out.println("Delete finish");
		System.out.println();
	}

	private static void Update() {
		// TODO Auto-generated method stub
		/* Update */
		System.out.println("Update Percentage");
		System.out.print("select Country Code >> ");
		String cc = sc.next();
		System.out.print("select Language >> ");
		String lan = sc.next();
		System.out.print("input Percentage >> ");
		float per = sc.nextFloat();

		clDto.setCc(cc);
		clDto.setLan(lan);
		clDto.setPer(per);

		clDao.updateconLan(clDto);
		System.out.println("update finish");
		System.out.println();
	}

	public static void insert() {
		// TODO Auto-generated method stub
		/* insert */
		System.out.println("insert");
		System.out.print("Country Code >> ");
		String cc = sc.next();
		System.out.print("Language >> ");
		String lan = sc.next();
		System.out.print("IsOfficial(T,F) >> ");
		String isoff = sc.next();
		System.out.print("Percentage >> ");
		float per = sc.nextFloat();

		clDto.setCc(cc);
		clDto.setIsof(isoff);
		clDto.setLan(lan);
		clDto.setPer(per);

		clDao.insertCountryLanguage(clDto);

		System.out.println("insert finish");
		System.out.println();
	}
}
