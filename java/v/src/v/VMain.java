package v;

import java.util.Scanner;

public class VMain {
	static VDTO vdto = new VDTO();
	static VDAO vdao = new VDAO();
	static Scanner sc = new Scanner(System.in);
	static int i = 1;

	public static void main(String[] args) {
//		insert();
//		insertSong();
		updateDate();
	}

	public static void insert() {
		// TODO Auto-generated method stub
		System.out.println("input " + i);
		System.out.print(
				"album_id (single : 10001~, regularity : 20001~, mini : 30001~, repackage : 40001~) >> ");
		int aID = sc.nextInt();
		System.out.print("issue_date (yyyy-mm-dd)>> ");
		String iDate = sc.next();
//		System.out.print("title_song_id >> ");
//		int sID = sc.nextInt();
//		System.out.print("album_type >> ");
//		String at = sc.next();
		sc.nextLine();
		System.out.print("Name >> ");
		String nm = sc.nextLine();
//		sc.nextLine();

		vdto = new VDTO(aID, nm, iDate);

		vdao.insert(vdto);
		i++;
		main(null);
	}
	
	public static void insertSong() {
		// TODO Auto-generated method stub
		System.out.println("input " + i);

		System.out.print("Song Title >> ");
		String st = sc.nextLine();
		
		vdto.setTitle(st);
		
		vdao.insertSong(vdto);
		i++;
		main(null);


	}
	
	private static void updateDate() {
		// TODO Auto-generated method stub
		for (int k = 2; k <= 68; k++) {
			vdao.update(k);
		}

		System.out.println("finish");
	}
}
