package project;

import java.util.Scanner;

public class MemberApp {
	static MembetDAO mDAO = new MembetDAO();
	static MemberDTO mDTO = new MemberDTO();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		mDAO.check();

		String key = "";
		System.out.println(
				"* * * * * * * * * * * * * * menu * * * * * * * * * * * * *");
		System.out
				.println("1.join 2.inqury 3.change 4.delete 5.search 6.Login 7.end");
		System.out.print(">> ");
		try {
			key = sc.next();
		} catch (Exception e) {
			// TODO: handle exception
			main(null);
		}
		switch (key) {
		case "1":
			insert();
			break;
		case "2":
			List();
			break;
		case "3":
			Update();
			break;
		case "4":
			Delete();
			break;
		case "5":
			selectName();
			break;
		case "6":
			LoginApp log = new LoginApp();
			log.login();
		case "7":
			System.out.println("E N D");
			break;

		default:
			System.out.println("You've entered something wrong.");
			main(null);
			break;
		}

	}

	private static void selectName() {
		// TODO Auto-generated method stub
		System.out.println(
				">>>>>>>>>>>>>>>>>>>>>>>>>>>Search<<<<<<<<<<<<<<<<<<<<<<<<<<");
		System.out.print("Search Name >> ");
		String nm = sc.next();
		
		String after = mDAO.chkNm(nm);
		
		if (after.equals(null)) {
			System.out.println("Name does not exist.");
			main(null);
		} else {
			System.out.println("   ID\tPassword\tname\tZip-Code\tAddress");
			java.util.List<MemberDTO> slist = mDAO.search(nm);

			for (MemberDTO memberDTO : slist) {
				System.out.println(memberDTO.toString());
			}
			System.out.println();

			main(null);
		}
	}

	private static void Delete() {
		// TODO Auto-generated method stub
		System.out.println(">>>>>>>>>>>>>>>Delete<<<<<<<<<<<<<<<");
		System.out.print("Delete Id >> ");
		int id = sc.nextInt();

		int after = mDAO.chkId(id);
		if (after == 0) {
			System.out.println("ID does not exist.");
			main(null);
		} else {
			mDAO.deleteMember(id);
			List();
		}
	}

	private static void Update() {
		// TODO Auto-generated method stub
		System.out.println(">>>>>>>>>>>>>>>Update<<<<<<<<<<<<<<<");
		System.out.print("Update Id >> ");
		int id = sc.nextInt();

		int after = mDAO.chkId(id);
		if (after == 0) {
			System.out.println("ID does not exist.");
			main(null);
		} else {
			System.out.print("new Password >> ");
			String pwd = sc.next();
			System.out.print("new Name >> ");
			String nm = sc.next();
			System.out.print("new Address >> ");
			String ad = sc.next();
			System.out.print("new Zip-Code >> ");
			int code = sc.nextInt();

			mDTO = new MemberDTO(id, pwd, nm, code, ad);

//		mDTO.setId(id);
//		mDTO.setName(nm);
//		mDTO.setAddress(ad);
//		mDTO.setPassword(pwd);
//		mDTO.setZipCode(code);

			mDAO.updateMember(mDTO);

			List();

			System.out.println("Change finish");
		}
	}

	private static void List() {
		// TODO Auto-generated method stub
		System.out.println(
				">>>>>>>>>>>>>>>>>>>>>>>>>>>>List<<<<<<<<<<<<<<<<<<<<<<<<<<<");

		System.out.println("   ID\tPassword\tname\tZip-Code\tAddress");
		java.util.List<MemberDTO> mlist = mDAO.inquiry();

		for (MemberDTO memberDTO : mlist) {
			System.out.println(memberDTO.toString());
		}
		System.out.println();
		main(null);

	}

	private static void insert() {
		// TODO Auto-generated method stub
		mDAO.initializeId();
		System.out.println(">>>>>>>>>>>>>>>Join<<<<<<<<<<<<<<<");
		System.out.print("Password >> ");
		String pwd = sc.next();
		System.out.print("Name >> ");
		String nm = sc.next();
		System.out.print("Address >> ");
		String ad = sc.next();
		System.out.print("Zip-Code >> ");
		int code = sc.nextInt();

		mDTO = new MemberDTO(pwd, nm, code, ad);

//		mDTO.setName(nm);
//		mDTO.setAddress(ad);
//		mDTO.setPassword(pwd);
//		mDTO.setZipCode(code);

		mDAO.insertMember(mDTO);

		System.out.println("insert finish");

		main(null);
	}
}
