
public class checkvalue_exam {
	public static void main(String[] args) {
		int i = 128;

		if ((i < Byte.MIN_VALUE || i > Byte.MAX_VALUE)) {
			System.out.println("Ÿ�� ��ȯ ����");
			System.out.println("���� Ȯ���� �ּ���");
		} else {
			byte b = (byte) i;
			System.out.println(b);
		}
	}
}