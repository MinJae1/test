package codingstamp;

import java.util.Scanner;

//http://codingdojang.com/scode/593?answer_mode=hide
public class GCD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String t;
		Scanner scanner = new Scanner(System.in);
		System.out.println("토지의 가로 세로를 입력해 주세요");
		t = scanner.nextLine();

		String[] num = t.split(" ");

		int r = 1;
		int tmp1,tmp2;
		if (Integer.parseInt(num[0])<Integer.parseInt(num[1])) {
			tmp1 = Integer.parseInt(num[1]);
			tmp2 = Integer.parseInt(num[0]);
		} else {
			tmp1 = Integer.parseInt(num[0]);
			tmp2 = Integer.parseInt(num[1]);
		}
        while(r>0){//GCD(최대공약수)구하기
            r = tmp1 % tmp2;
            tmp1 = tmp2;
            tmp2 = r;
         }
        int cnt1,cnt2;
        cnt1 = Integer.parseInt(num[0])/tmp1;
        cnt2 = Integer.parseInt(num[1])/tmp1;
                
        System.out.println("식물의 갯수 : "+ (cnt1*cnt2));
        scanner.close();
	}

}
