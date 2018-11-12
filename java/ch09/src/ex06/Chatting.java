package ex06;

public class Chatting {
	void startChat(String chatId) {
		// TODO Auto-generated method stub
//		String nickname = null; //final 선언을 해야 익명 객체에서 사용가능
//		nickname = chatId; //final 선언시 값 수정 불가능
		final String nickname = chatId; // 해결법 1 : 초기값으로 설정
		Chat chat = new Chat() {
			@Override
			void start() {
				// TODO Auto-generated method stub
//				String new_nickname = chatId; //해결법 2 : 익명객체에서 선언
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
