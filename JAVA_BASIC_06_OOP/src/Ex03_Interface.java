/*
 인터페이스 : 약속, 규칙, 규약, 표준 이런것들을 만드는 행위
 
 설계의 최상위 단계 - 표준과 약속을 만듬
 
 인터페이스의 사용법을 아는 것이 중요
 
 인터페이스는 구현부가 없다. 
 인터페이스를 사용하는 사람이 구현함.
 
 추상 클래스와 인터페이스의 공통점
 1. 스스로 객체 생성이 불가능(new 연산자 사용불가)
 1.1 차이점 : 추상(완성 + 미완성), 인터페이스(미완성)
 
 2. 추상 클래스 extends
 	인터페이스 implements 키워드 사용
 	
 	class Car extends AbClass{} 상속
 	class Car implements Ia {} 구현
 	
 	둘 다 추상 자원을 가지고 있다(미완성 자원) -> 강제적 구현이 목적
 	-> 재정의(오버라이드)
 	
3. 추상 클래스와 인터페이스의 다른점
3.1 다중 상속(구현) : 인터페이스(다중 구현 가능)
인터페이스는 최대한 적게 만드는것이 좋다. -> 강제성이 있기 때문에
작게 작게 만들어서 모아서 써야 좋음
인터페이스는 작게 쪼개서 만들어야함, 그래야 재사용성이 좋다
그래서 여러개를 implements

class Test extends Object implements Ia, Ib, Ic {
}

인터페이스끼리 상속이 가능(extends)
원칙 : 작은 약속 여러개를 만들어서 하나의 큰 규칙으로 만드는게 좋다

4. 인터페이스(상수를 제외한 나머지는 추상 메서드)
JDK 8버전부터는 default, static을 쓸 수 있음

초급 개발자의 접근
1. 인터페이스를 [다형성] 입장으로 접근
	인터페이스가 부모타입이 된다.
2. **서로 연관성이 없는** 클래스를 하나로 묶어주는 역할(같은 부모를 가짐으로써)
같은 인터페이스를 implements함으로써 
서로 연관없는 클래스들이 하나로 묶임(그 인터페이스 타입으로)

3. JAVA API는 수많은 인터페이스가 정의 되어있음..
사용하는지에 대한 관점(다형성)
	ex) 컬렉션프레임워크
	
4. 인터페이스(~able) : 날 수 있는, 수리할 수 있는, 먹을 수 있는
5. 객체 간 연결 고리(객체 간 소통) : 다형성

* 구문
interface 
1. 실제 구현부{}를 가지고 있지 않다. -> 실행 블록이 없음
2. interface Ia {void move(int x, int y);} //-> {} 구현부 없음
	implements한 클래스에서 구현함.
3. JAVA API가 제공하는 컬렉션을 잘쓰면 된다.
	List, Set, Map

생성 방법
1. 상수 구현
public static final int VERSION = 1 
-> 어차피 인터페이스가 가지는 모든 자원은 public static final
-> 컴파일러가 알아서 public static final를 붙여준다.
->  int VERSION = 1 만 선언해도 public static final를 컴파일러가 붙여줌
-> public static final 생략 가능
2. 추상 메서드
public abstract void run(); -> void run();

인터페이스의 종류
interface able{} // 같은 가족으로 묶을 때...사용

 */

interface Ia{
	public static final int AGE = 100;
	public static final String GENDER = "남";
	public abstract String print();
	public abstract void message(String str);
}

interface Ib{ // 인터페이스에서 선언한 변수는 상수, 
	// 선언한 메서드는 추상메서드
	// 필드는 public static final와 메서드는 public abstract이 생략되어있음
	int AGE = 100;
	String GENDER = "남";
	String print();
	void message(String str);
}

interface Ic{
	
}

class Test2 implements Ib, Ic{ // 다중 상속 가능

	@Override
	public String print() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void message(String str) {
		// TODO Auto-generated method stub
		
	}
	
}



public interface Ex03_Interface {

	public static void main(String[] args) {
		Test2 t2 = new Test2();
		Ib ib = t2;
		Ib ib2 = new Test2();
		// 인터페이스(부모) 타입으로 자식객체(구현하고 있는 클래스)의 주소값을 가질 수 있다
		
		//t2에서 구현된 (재정의)메서드 호출 - 구현,오버라이드
	}
}
