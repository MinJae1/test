package ch15;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue<Message> messageQueue = new LinkedList<Message>();

		messageQueue.offer(new Message("SendMail", "Recipient1"));
		messageQueue.offer(new Message("SendSMS", "Recipient2"));
		messageQueue.offer(new Message("SendTalk", "Recipient3"));

		while (!messageQueue.isEmpty()) {
			Message message = messageQueue.poll();
			switch (message.command) {
			case "SendMail":
				System.out.println("Sending Mail to " + message.to);
				break;

			case "SendSMS":
				System.out.println("Sending SMS to " + message.to);
				break;

			case "SendTalk":
				System.out.println("Sending Chat to " + message.to);
				break;
			}
		}
	}

}
