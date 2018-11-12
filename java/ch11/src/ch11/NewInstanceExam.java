package ch11;

public class NewInstanceExam {
	public static void main(String[] args) {
		try {
			Class cl1 = Class.forName("ch11.SendAction");
			Class cl2 = Class.forName("ch11.ReceiveAction");
			Action ac1 = (Action) cl1.newInstance();
			Action ac2 = (Action) cl2.newInstance();
			ac1.execute();
			ac2.execute();
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
