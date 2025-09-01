/*
  User 사용자 <-> Provider 제공자
  
   class A{}
   class B{}
   
   상속관계, 포함 관계
   A는 B를 사용합니다.
   
   1. 상속 : A extends B
   2. 포함 : A클래스 내에 B클래스 객체를 멤버필드로 사용함
   
   부분적 포함, 전체 포함
   라이프 싸이클의 동일 여부
   
   class B{}
   class A{
   	int i;
   	B b; // A는 B를 멤버필드로 사용합니다.(포함)
   	A(){
   		b = new B(); //공동 운명체, 전체집합(A가 없어지면 B에 접근 방법이 없음)
   	}
   }
   
   main(){
   	A a = new A(); 
   	a = null; 
   }
   
   
  포함관계에서
  	B는 독자 생성이 불가능함
  	A라는 객체가 만들어지면 B도 생성된다
  	
  예) 자동차와 엔진, 컴퓨터와 CPU, ... 등
  
  ======================================================================
  class B{}
  class A{
  	int i;
  	B b;
  	A(){
  	
  	}
  	
  	//method
  	void m(B b){
  		this.b = b;
  	}
  }
  
  main(){
  	A a = new A();
  	B b = new B();
  	
  	필요에 따라서 안해도 되는데 필요하다면?
  	a.m(b); // 부분적 포함 -> 메서드로 멤버필드 B b;를 초기화함
  	
  	a = null; //-> 해도 b는 살아있음
  	//예) 학교와 학생, 노트북과 마우스, 핸드폰과 충전기
  }
   
 */

interface Icall{
	void m(); // public abstract void m();과 같음
	
}

class D implements Icall{

	@Override
	public void m() {
		System.out.println("D ... Icall 인터페이스의 m() 재정의");	
	}
}

class F implements Icall{

	@Override
	public void m() {
		System.out.println("F ... Icall 인터페이스의 m() 재정의");	
	}
}

//현대적인 프로그래밍은 유연성을 중요 시 한다.
//느슨한 연결의 사용을 좋아함
//interface를 활용

class C{
	void method(Icall ic) { 
		// Icall을 구현하고 있는 모든 클래스객체의 주소를 받을수있음
		// **앞으로 구현될 객체도 올 수 있음(유지보수에 도움)**
		ic.m(); //재정의된 메서드가 호출됨
	}
}


public class Ex05_User_Provider {
	public static void main(String[] args) {
		C c = new C();
		D d = new D();
		F f = new F();
		c.method(d);
		c.method(f);
	}
}


