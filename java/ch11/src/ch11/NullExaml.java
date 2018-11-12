package ch11;

import java.util.Objects;

public class NullExaml {
	public static void main(String[] args) {
		String str1 = "name";
		String str2 = null;

		System.out.println(Objects.requireNonNull(str1));

		try {
			String name = Objects.requireNonNull(str2);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		try {
			String name = Objects.requireNonNull(str2, "�̸��� �����ϴ�.");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		try {
			String name = Objects.requireNonNull(str2, () -> "�̸��� ���ٴϱ�.");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
}
