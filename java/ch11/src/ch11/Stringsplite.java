package ch11;

public class Stringsplite {
	public static void main(String[] args) {
		String text = "abc&def,ghi,jkl-mno";

		String[] sp_txt = text.split("&|,|-");

		for (String string : sp_txt) {
			System.out.println(string);
		}
	}
}
