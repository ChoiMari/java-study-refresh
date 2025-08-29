/*
 게임 : 유닛(unit)
 
  unit : 공통기능(이동 좌표, 이동, 멈춘다) : 추상화된 자원, 일반화된 자원
  unit : 이동 방법은 다르다. (오버라이드)
  -> 추상클래스나 인터페이스로 뺌(이동 방법은 unit마다 다르다)
  별도의 구현이 필요함 반드시.
  
class Unit{
	void move() -> 구현을 각각의 유닛마다 별도로 **강제** 하고 싶다..(불신하기 때문에)
}
  
 */

abstract class Unit{
	int x,y;
	void stop() {
		System.out.println("Unit stop");
	}
	
	// 이동 강제 구현 표현이 다르니까
	abstract void move(int x, int y); //{} 없는 추상메서드, 미완성 메서드
}

class Tank extends Unit{ // 상속 받자 말자 에러뜸.
	// 내부 구현하라고...(메서드 재정의)

	@Override
	void move(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("Tank 소리내며 이동 : " + this.x + "," + this.y);
		
	}
	
	//필요에 따라서 구체화되고 특수화된걸 구현하면 된다.
	void changeMode() {
		System.out.println("탱크모드 변환");
	}
}

class Marine extends Unit{ // 상속 받자 말자 에러뜸.
	// 내부 구현하라고...(메서드 재정의)

	@Override
	void move(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("Marine 이동 : " + this.x + "," + this.y);
		
	}
	
	//필요에 따라서 구체화되고 특수화된걸 구현하면 된다.
	void stimpack() {
		System.out.println("스팀팩기능");
	}
}

class DropShip extends Unit{

	@Override
	void move(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("DropShip 하늘로 이동 : " + this.x + "," + this.y);
	}
	
	// 특수한 기능(구체화)
	void load() {
		System.out.println("Unit load");
	}
	
	void unload() {
		System.out.println("Unit unload");
	}
	
}

public class Ex02_Abstract_class {
	public static void main(String[] args) {
		Tank tank = new Tank();
		tank.move(500, 200);
		tank.stop();
		tank.changeMode();
		
		Marine marine = new Marine();
		marine.move(200, 300);
		marine.stop();
		marine.stimpack();
		
		//Today Point(다형성 : 부모타입, 자식타입)
		// JAVA : instanceof (객체의 타입을 비교하는 연산자)
		// 맞으면 true, 틀리면 false 리턴
		// 자바스크립트에도 있음 : typeof, instanceof
		
		if(tank instanceof Unit) { // 앞에는 물어보려는 객체 뒤에는 타입
			// 앞의 객체가 뒤에 있는 타입 맞는지?
			//탱크가 유닛 타입이냐? -> 상속관계에서는 true
			System.out.println(true); // 실행
		}else {
			System.out.println(false);
		}
		
		if(tank instanceof Tank) { // 앞에는 물어보려는 객체 뒤에는 타입
			// 앞의 객체가 뒤에 있는 타입 맞는지?
			// 탱크객체가 탱크 타입이냐? -> 상속관계에서는 true
			System.out.println(true); // 실행
		}else {
			System.out.println(false);
		}
		
		// 문제의 의도 : 다형성
		//1. 탱크 3대를 만들고 같은 좌표(600, 800)로 이동 시키세요
		// Unit[] tanks = new Unit[] {new Tank(), new Tank(), new Tank()};
		Tank[] tanks = {new Tank(), new Tank(), new Tank()};
		for(Tank t : tanks) {
			t.move(600, 800);
		}
		
		System.out.println("*******************************");
		
		//2. Tank 1대, Marine 1명, DropShip 1대 생성하고 같은 좌표로 이동
		// (777,888)
		Unit[] units = new Unit[] {new Tank(), new Marine(), new DropShip()};
		//Unit[] units = {new Tank(), new Marine(), new DropShip()}; 이거와 같음
		
		for(Unit u: units) {
			u.move(777, 888);
		}
	}
}
