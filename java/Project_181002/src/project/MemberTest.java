package project;

import java.util.Scanner;

public class MemberTest {
	static MembetDAO mDAO = new MembetDAO();
	static MemberDTO mDTO = new MemberDTO();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
//		selectName();
//		Delete();
		List();
//		Update();
//		insert();
	}

	private static void selectName() {
		// TODO Auto-generated method stub
		System.out.print("Search Name >> ");
		String nm = sc.next();

		java.util.List<MemberDTO> slist = mDAO.search(nm);

		for (MemberDTO memberDTO : slist) {
			System.out.println(memberDTO.toString());
		}
		System.out.println();

	}

	private static void Delete() {
		// TODO Auto-generated method stub
		System.out.print("Delete Id >> ");
		int id = sc.nextInt();

		mDAO.deleteMember(id);

		List();
	}

	private static void Update() {
		// TODO Auto-generated method stub
		System.out.print("Update Id >> ");
		int id = sc.nextInt();
		System.out.print("new Password >> ");
		String pwd = sc.next();
		System.out.print("new Name >> ");
		String nm = sc.next();
		System.out.print("new Address >> ");
		String ad = sc.next();
		System.out.print("new Zip-Code >> ");
		int code = sc.nextInt();

		mDTO.setId(id);
		mDTO.setName(nm);
		mDTO.setAddress(ad);
		mDTO.setPassword(pwd);
		mDTO.setZipCode(code);

		mDAO.updateMember(mDTO);

		List();

		System.out.println("Change finish");
	}

	private static void List() {
		// TODO Auto-generated method stub

		java.util.List<MemberDTO> mlist = mDAO.inquiry();

		for (MemberDTO memberDTO : mlist) {
			System.out.println(memberDTO.toString());
		}
		System.out.println();

	}

	private static void insert() {
		// TODO Auto-generated method stub
		mDAO.initializeId();
		System.out.print("Password >> ");
		String pwd = sc.next();
		System.out.print("Name >> ");
		String nm = sc.next();
		System.out.print("Address >> ");
		String ad = sc.next();
		System.out.print("Zip-Code >> ");
		int code = sc.nextInt();

		mDTO.setName(nm);
		mDTO.setAddress(ad);
		mDTO.setPassword(pwd);
		mDTO.setZipCode(code);

		mDAO.insertMember(mDTO);

		System.out.println("insert finish");

	}
}
