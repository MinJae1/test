
public class checkvalue_exam {
	public static void main(String[] args) {
		int i = 128;

		if ((i < Byte.MIN_VALUE || i > Byte.MAX_VALUE)) {
			System.out.println("타입 변환 실패");
			System.out.println("값을 확인해 주세요");
		} else {
			byte b = (byte) i;
			System.out.println(b);
		}
	}
}
