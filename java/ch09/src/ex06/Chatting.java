package ex06;

public class Chatting {
	void startChat(String chatId) {
		// TODO Auto-generated method stub
//		String nickname = null; //final ������ �ؾ� �͸� ��ü���� ��밡��
//		nickname = chatId; //final ����� �� ���� �Ұ���
		final String nickname = chatId; // �ذ�� 1 : �ʱⰪ���� ����
		Chat chat = new Chat() {
			@Override
			void start() {
				// TODO Auto-generated method stub
//				String new_nickname = chatId; //�ذ�� 2 : �͸�ü���� ����
				while (true) {
					String inputData = "Hello";
					String msg = "[" + nickname + "] " + inputData;
					sendMSG(msg);
				}
			}
		};
		chat.start();
	}

	class Chat {
		void start() {
			// TODO Auto-generated method stub

		}

		void sendMSG(String msg) {
			// TODO Auto-generated method stub

		}
	}
}
