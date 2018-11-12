package btn_exe;

public class Window {
	Button btn1 = new Button();
	Button btn2 = new Button();

	Window() {
		// TODO Auto-generated constructor stub
		btn1.setOnclickListener(new TelePhone());
		btn2.setOnclickListener(new Message());
	}
}
