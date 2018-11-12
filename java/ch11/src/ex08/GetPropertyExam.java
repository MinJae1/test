package ex08;

import java.util.Properties;
import java.util.Set;

public class GetPropertyExam {
	public static void main(String[] args) {
		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getProperty("user.name"));
		System.out.println(System.getProperty("user.home"));

		Properties props = System.getProperties();
		Set<Object> keys = props.keySet();
		for (Object objKey : keys) {
			String key = (String) objKey;
			String value = System.getProperty(key);
			System.out.println("[" + key + "] : " + value);
		}
	}
}
