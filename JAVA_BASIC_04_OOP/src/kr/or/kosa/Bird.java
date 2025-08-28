package kr.or.kosa;

// 새 (공통 자원이 뭐가 있을까? (일반화, 추상화) 
// 날 수 있음, 빠르다
public class Bird {
	// 공통 기능
	public void fly() {
		System.out.println("flying");
	}
	
//	public void moveFast() {
//		fly();
//	}
	
	protected void moveFast() { // 상속 관계에서는 public인데
		// 상속이 아니면 default 
		// 사용하려면 상속관계에서 재정의 해야함
		fly();
	}
	
	/*  
	 class Bi extends Bird{
	 
	 }
	 
	 Bi bi = new Bi();
	 bi.fly();
	 bi.moveFast(); //-> 재정의 하길 바랬는데..
	 //-> 그냥 쓰네..?
	 //-> 오버라이드 해야 사용하게 만들자
	 //-> 그럴때 사용하는 접근자가 protected 
	 
	 	설계자의 고민
	 	그런데 모든 새가 빠르지는 않다..
	 	(닭, 타조)
	 	fly 
	 	새 : 타조(달리기)
	 	
	 	public 메서드 재정의 하길 원함
	 	근데 받는 사람입장에서는 강제성이 없음
	 	-> protected 사용해서 오버라이드 하게 만듬
	 */
	
	
}
