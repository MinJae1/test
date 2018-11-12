package ch09;

public class Window {
	Button btn1 = new Button();
	Button btn2 = new Button();

	Button.OnClickListener listener = new Button.OnClickListener() {

		@Override
		public void onClick() {
			// TODO Auto-generated method stub
			System.out.println("call");
		}
	};

	Window() {
		// TODO Auto-generated constructor stub
		btn1.setOnclickListener(listener);
		btn2.setOnclickListener(new Button.OnClickListener() {

			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				System.out.println("send msg");
			}
		});
	}
}
