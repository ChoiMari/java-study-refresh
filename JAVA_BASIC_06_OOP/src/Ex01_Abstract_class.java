/*
 추상 클래스
 1. 미완성 클래스 (설계도)
 1.1 완성된 코드와 미완성된 코드가 혼재
 1.2 미완성 메서드 -> {}구현 블록이 없는
 		-> public void run(); 추상메서드
 			{}가 없는 메서드
 1.3 미완성(추상클래스)는 스스로 객체 생성 불가
 		그럼 왜 만들까? **강제성**을 부여하기위해(불신)
 		
 설계도를 만드는 입장에서 
 -> 미완성 설계도를 만드는 이유는 ? 믿지 못하기 때문에..
 -> 강제적 구현을 목적으로 상속해라
 (상속과 동시에 에러가 난다.. {}를 구현하지 않으면)
 
 상속해서 미완성을 완성해라 (오버라이드 해라) {} 구현해라.
 */

abstract class Abclass {
	int pos;
	void run() {
		pos++;
	}
	abstract void stop(); // 원하는 형태로 상속을 통해서 재정의해라(내용을 바꿔라)
	//protected와의 차이점 : protected는 오버라이드 하지 않아도 에러는 안남
	// abstract가 더 강한 강제성
}

class Child extends Abclass{

	@Override
	void stop() {
		// 구현하는 사람 맘대로
		this.pos = 0;
		System.out.println("stop : " + this.pos);
	}
	
}

public class Ex01_Abstract_class {
	public static void main(String[] args) {
		Child child = new Child();
		child.run();
		child.run();
		child.stop();
		
		// 다형성 : 상속 관계에서 부모타입의 참조변수는
		// 자식객체의 주소를 가질 수 있다
		Abclass ab = child; //-> 자식 클래스에서 오버라이드한 메서드가 호출됨
		// abstract를 상속했으면 반드시 구현을 했을거기 때문에...(강제성 부여)
		ab.run();
		ab.stop();
		
	}
}
