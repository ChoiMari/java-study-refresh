
/* 
 OOP : 여러개의 작은 클래스를 모아 모아서 하나의 큰 클래스를 만드는 행위
 클래스(큰 설계도)의 기준 : 메인 설계도가 있다, 부분 설계도(메인설계도의 부분이 되는 설계서, 클래스),
 독립적인 설계도, 메인 설계도의 하위 설계도
 
 1. 상속
 JAVA : child extends 부모클래스명
 C# : child : 부모클래스명
 
 특징 : 클래스는 다중 상속 불가(인터페이스는 가능)
 		자바에서는 단일 상속 원칙으로, 계층적 상속만 가능함
	
 인터페이스는 표준, 규칙, 규약, 약속 정의
 
 상속이란 ? 
 1. 진정한 의미 : 재사용성
 2. 단점 : 초기 설계 비용이 많이든다
 		부모 자식 관계(커플링)를 끊을 수 없다(클래스) -> 부모가 바뀌면 자식도 영향을 받음.
 		디커플링(느슨한관계)를 좋아함 -> 인터페이스 구현
 3. 커플링 관계를 최대한 줄여보자..
 
 원칙 : 모든 클래스는 메모리에 올라가야 사용 가능
 	new연산자를 통해 heap 메모리에 올라감
 	Child child = new Child();
 */

class Car{ // class Car extends Object 생략
	// 자바의 모든 클래스는 Object클래스를 자동으로 상속 받음
	// Car의 부모는 Object
	// Object는 내꺼(상속 관계에서)
	
}

class GrandFather{
	public int gmoney = 5000;
	private int pmoney = 10000; 
	//-> private이면 자식 타입에서 접근 못함
	// -> 간접 접근은 가능함(public getter, setter)
	
	public GrandFather() {
		System.out.println("GrandFather 생성자");
	}
}

class Father extends GrandFather{
	public int fmoney = 30000;
	public Father() {
		System.out.println("Father 생성자");
	}
}

class Child extends Father{
	public int cmoney = 100;
	public Child() {
		System.out.println("Child 생성자");
	}
	
}

public class Ex01_inherit {
	public static void main(String[] args) {
		// 실행하면 메모리에 어떤 객체가 올라갈까?
		// Object -> 할아버지 -> 아빠 -> 자식 순
		Car c = new Car();
		Child child = new Child();
		System.out.println(child.gmoney);
		System.out.println(child.fmoney);
		System.out.println(child.cmoney);	
		/*
		 GrandFather 생성자
 		 Father 생성자
		 Child 생성자
		 5000
		 30000
		 100 
		 */
		
		//chile.pmoney; 안 보임
	}
}
