// 인터페이스
// ~할 수 있는 (수리할 수 있는)
// 이걸 부모타입으로 만들어주면
// 이걸 구현하는 모든 클래스 객체의 주소를 저장 가능(다형성)
interface Irepairable{
	
}

class Unit2{
	int hitpoint; // 기본 에너지
	final int MAX_HP; // 최대 에너지
	
	public Unit2(int hp) {
		this.MAX_HP = hp;
	}
}

//지상 유닛, 공중 유닛, 건물
class GroundUnit extends Unit2{

	public GroundUnit(int hp) {
		super(hp);
	}
}

// 공중 유닛
class AirUnit extends Unit2{
	public AirUnit(int hp) {
		super(hp);
	}
}

// 건물
class CommandCenter implements Irepairable{
	
}

class Tank2 extends GroundUnit implements Irepairable{

	public Tank2() {
		super(50);
		this.hitpoint = this.MAX_HP;
	}
	
	@Override
	public String toString() {
		return "tank2";
	}
	
}

class Marine2 extends GroundUnit{

	public Marine2() {
		super(50);
		this.hitpoint = this.MAX_HP;
	}
	
	@Override
	public String toString() {
		return "Marine2";
	}
	
}

//광물캐는 유닛
class Scv extends GroundUnit implements Irepairable{

	public Scv() {
		super(50);
		this.hitpoint = this.MAX_HP;
	}
	
	@Override
	public String toString() {
		return "Scv";
	}
	
	// Scv 구체화, 특수화된 고유한 기능이 있음
	// 수리 (repair)
	// 탱크, Scv, 건물 고침
	// Marine을 고치지는 못한다.
	// GroundUnit(탱크2, 마린2, Scv의 부모)
//	void repair(GroundUnit unit) { // 이렇게 해도 건물은 못고침
//		if(unit instanceof Marine2) { 
//			return;
//		}else { 
//			unit.hitpoint = unit.MAX_HP;
//		}
//	}
	
	// 해결 공통점 : 공통의 부모 -> 인터페이스 사용
	// Irepairable(수리할 수 있는)인터페이스를 구현하는 클래스 
	// -> 탱크2, Scv, 건물
	void repair(Irepairable repairUnit) {
		// 수리하는 방법이 다르다.
		// 탱크2, Scv는 HP만 올리면 됨
		// 건물은 수리 방법이 다름
		
		// 모든 인터페이스는 오브젝트 클래스 자원을 사용할 수 있다.
		//Unit2 unit = (Unit)repairUnit; 다운 캐스팅
		if(repairUnit instanceof Unit2) {
			//repairUnit이 Unit2타입이면 실행
			Unit2 unit2 = (Unit2)repairUnit; // 다운캐스팅
			if(unit2.hitpoint != unit2.MAX_HP) {
				unit2.hitpoint = unit2.MAX_HP;
			}
		} else {
			System.out.println("다른 방식으로 건물을 수리합니다.");
		}
	}
	// 서로 논리적인 연관관계가 없는 클래스들에 대해서
	// 하나로 묶어서 인터페이스로 부모를 제공할 수 있다.
	// -> 디커플링
	
}

public class Ex04_Interface_Poly {
	public static void main(String[] args) {
		Tank2 tank = new Tank2();
		Marine2 marine2 = new Marine2();
		Scv scv = new Scv();
		CommandCenter center = new CommandCenter();
		tank.hitpoint -= 20;
		System.out.println("탱크 : " + tank.hitpoint);
		
		// 수리해줘
		System.out.println("Scv 수리 요청");
		scv.repair(tank);
		System.out.println("탱크 수리 완료: " + tank.hitpoint);
		scv.repair(center);
	}
}
