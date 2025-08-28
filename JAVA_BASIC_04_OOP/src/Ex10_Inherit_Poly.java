/*
  다형성
  자바에서 상속관계가 없으면 존재하지 않는다.
  
  일반적인 다형성의 의미 : 여러가지 성질(상태)를 가질 수 있는 능력
  
  자바의 다형성 : 상속관계에서 하나의 참조변수(부모 타입)가
  여러 개의 자식객체의 주소를 가질 수 있다(업캐스팅)
   -> 하나의 참조 변수(부모타입)
   -> 부모를 상속 받은 자식 객체
 */
class Tv2{
	boolean power;
	int ch;
	
	void power() {
		this.power = !this.power;
	}
	
	void chUp() {
		this.ch++;
	}
	
	void chDown() {
		this.ch--;
	}
}

// 자막 기능이 있는 Tv
class CapTv extends Tv2{
	// 특수화, 구체화
	String text;
	String captionText() {
		return this.text = "현재 자막 서비스 중입니다.";
	}
}

public class Ex10_Inherit_Poly {

	public static void main(String[] args) {
		CapTv ct = new CapTv();
		ct.power();
		ct.chUp();
		System.out.println(ct.captionText());
		//------------------------------------------
		
		Tv2 tv2 = ct; 
		// 부모타입 변수에 **자식타입의 객체주소**를 저장함
		// 상속 관계에서 부모타입 변수가 자식객체의 주소를 가질 수 있음(업캐스팅)
		// 단, 부모는 자신의 자원만 접근이 가능함
		// 단, 재정의는 제외
		// 부모꺼에 있는것 밖에 못쓴다는 말, 단 - 오버라이드 한게 있으면
		// 자식에서 오버라이드한 메서드가 호출됨
		System.out.println(tv2.toString());
		System.out.println(ct.toString());
	}

}
