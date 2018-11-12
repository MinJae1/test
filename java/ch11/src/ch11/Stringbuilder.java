package ch11;

public class Stringbuilder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();

		sb.append("append");
		System.out.println(sb.toString());

		sb.insert(6, " insert");
		System.out.println(sb.toString());

		sb.setCharAt(6, 'A');
		System.out.println(sb.toString());

		sb.replace(7, 14, "replace");
		System.out.println(sb.toString());

		sb.delete(6, 7);
		System.out.println(sb.toString());

		System.out.println("length : " + sb.length());

		System.out.println("buffer string : " + sb.toString());

		System.out.println("reverse : " + sb.reverse());
	}

}
