package codingstamp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class tapTospace {
public static void main(String[] args) {
	if (args.length == 0) {                   // args.length �� �ɼ� ����
	      System.err.println("tap_test.txt");
	      System.exit(1);                         // ���� ���ϸ��� ���� �ʾ��� ���� ����
	    }

	    try {
	      ////////////////////////////////////////////////////////////////
	      BufferedReader in = new BufferedReader(new FileReader(args[0]));
	      String s;
	      String str;
	      
	      s = in.readLine();
	      str = s.replace("\t", "    ");

	      while ((s = in.readLine()) != null) {
	        System.out.println(str);
	      }
	      in.close();
	      ////////////////////////////////////////////////////////////////
	    } catch (IOException e) {
	        System.err.println(e); // ������ �ִٸ� �޽��� ���
	        System.exit(1);
	    }
}
}
