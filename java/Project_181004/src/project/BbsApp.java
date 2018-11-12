package project;

import java.util.Scanner;

public class BbsApp {
	static BbsDAO bDao = new BbsDAO();
	static BbsDTO bDto = new BbsDTO();
	static Scanner sc = new Scanner(System.in);
	static int cnt = 0;

	public static void main(String[] args) {
		bDao.check();

		if (cnt == 0) {
			login();
			cnt++;
		}

	}

	public static void login() {
		// TODO Auto-generated method stub
		System.out.print("ID(Please enter numbers only.) >> ");
		int in_id = sc.nextInt();
		System.out.print("Password >> ");
		String in_pwd = sc.next();
		int new_id = bDao.login(in_id, in_pwd);

		if (new_id == 0) {
			login();
		} else {
			menu(new_id);
		}

	}

	public static void menu(int new_id) {
		// TODO Auto-generated method stub
		String key = "";
		System.out.println(
				"* * * * * * * * * * * * * * menu * * * * * * * * * * * * *");
		System.out.println(
				"1.Write 2.List 3.Modify 4.Delete 5.Detailed Inquiry 6.End");
		System.out.print(">> ");
		try {
			key = sc.next();
		} catch (Exception e) {
			// TODO: handle exception
			main(null);
		}
		switch (key) {
		case "1":
			insert(new_id);
			break;
		case "2":
			List(new_id);
			break;
		case "3":
			Update(new_id);
			break;
		case "4":
			Delete(new_id);
			break;
		case "5":
			DetailedInquiry(new_id);
			break;
		case "6":
			System.out.println("E N D");
			break;

		default:
			System.out.println("You've entered something wrong.");
			menu(new_id);
			break;
		}
	}

	public static void DetailedInquiry(int new_id) {
		// TODO Auto-generated method stub
		System.out.println("Detailed Inquiry");
		System.out.print("Search >> ");
		int in_id = sc.nextInt();

		int after = bDao.chklistId(in_id);
		if (after == 0) {
			System.out.println("ID does not exist.");
			menu(new_id);
		} else {
			System.out.println(
					"      Title       Writer           Date            Content");
			bDto = bDao.Search(in_id);

			System.out.println(
					String.format("%-15s    %-8s    %13s     %-25s", bDto.getTitle(),
							bDto.getName(), bDto.getDate(), bDto.getContent()));

			menu(new_id);
		}
	}

	public static void Delete(int new_id) {
		// TODO Auto-generated method stub
		System.out.println("Delete");
		System.out.print("Delete id >> ");
		int id = sc.nextInt();

		int after = bDao.chklistId(id);
		if (after == 0) {
			System.out.println("ID does not exist.");
			menu(new_id);
		} else {
			int chk_mem = bDao.deleteChk(after, new_id);

			if (chk_mem == 0) {
				System.out.println("Only your own text can be deleted.");
				menu(new_id);
			} else {
				bDao.delete(after);
				List(chk_mem);
			}
		}

	}

	public static void Update(int new_id) {
		// TODO Auto-generated method stub
		System.out.println("Update");
		System.out.println("   ID         Title           Date            Content");
		java.util.List<BbsDTO> searchList = bDao.Searchmem(new_id);

		for (BbsDTO bbsDTO : searchList) {
			System.out.println(String.format("  %4d    %-15s     %13s     %-25s",
					bbsDTO.getId(), bbsDTO.getTitle(), bbsDTO.getDate(),
					bbsDTO.getContent()));
		}

		System.out.print("\nSelect modify id >> ");
		int id = sc.nextInt();

		int after = bDao.chklistId(id);
		if (after == 0) {
			System.out.println("ID does not exist.");
			menu(new_id);
		} else {
			System.out.print("Modify Title >> ");
			String title = sc.next();
			sc.nextLine();
			System.out.print("Modify content >> ");
			String cont = sc.nextLine();

			bDto.setTitle(title);
			bDto.setContent(cont);

			bDao.modify(after, new_id, bDto);
			menu(new_id);
		}

	}

	public static void List(int new_id) {
		// TODO Auto-generated method stub
		System.out.println("List");
		System.out.println("   ID         Title             Writer            Date");
		java.util.List<BbsDTO> bList = bDao.inqury();

		for (BbsDTO bbsDTO : bList) {
			System.out.println(bbsDTO.toString());
		}
		System.out.println();
		menu(new_id);
	}

	public static void insert(int new_id) {
		// TODO Auto-generated method stub
		System.out.println("insert");
		System.out.print("Title >> ");
		String title = sc.next();
		sc.nextLine();
		System.out.print("Content >> ");
		String content = sc.nextLine();

		bDto = new BbsDTO(new_id, title, content);

		bDao.write(bDto);

		menu(new_id);
	}
}
