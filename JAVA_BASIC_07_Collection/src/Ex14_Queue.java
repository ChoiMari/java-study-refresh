//queue FIFO 선입선출 <-> stack LIFO 후입선출

import java.util.LinkedList;
import java.util.Queue;

import kr.or.kosa.Message;

public class Ex14_Queue {
	public static void main(String[] args) {
		//Stack은 클래스가 있지만, Queue는 인터페이스
		// LinkedList가 Queue를 대표적으로 구현함
		//Queue queue = new LinkedList<>();
		
		//학사관리 수강신청
		Queue<Message> messageQueue = new LinkedList<>();
		//성능을 위해 messageQueue가 노드개념이라서 삽입/삭제가 빠름
		messageQueue.offer(new Message("sendMail", "홍길동"));
		messageQueue.offer(new Message("sendSMS", "김유신"));
		messageQueue.offer(new Message("sendKakoTalk", "이순신"));
		while(!messageQueue.isEmpty()) { 
			Message message = messageQueue.poll(); // 선입선출로 나옴
			switch(message.getCommand()){
				case "sendMail" : System.out.println(message.getTo() + "님에게 메일을 보냄");
					break;
				case "sendSMS" : System.out.println(message.getTo() + "님에게 SMS을 보냄");
					break;
				case "sendKakoTalk" : System.out.println(message.getTo() + "님에게 카톡을 보냄");
					break;
			}
		}
	}
}
