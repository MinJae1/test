package btn_exe;

public class Button {
	OnClickListener listener;

	void setOnclickListener(OnClickListener listener) {
		// TODO Auto-generated method stub
		this.listener = listener;
	}

	void touch() {
		// TODO Auto-generated method stub
		listener.onClick();
	}

	interface OnClickListener {
		void onClick();
	}
}
