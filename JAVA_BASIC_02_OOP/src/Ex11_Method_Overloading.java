/*
 OOP 객체 지향 프로그래밍 ? 여러개의 작은 조각 설계도(클래스)를 모아서
 큰 조각(설계도)을 만드는 것
 자동차를 한꺼번에 만드는게 아니고
 문, 창문, 바퀴, 엔진 등 만들어서 붙이는 것
 
  TIP) AOP : 관점지향. 주관심, 보조관심.
  계산기의 주관심 - 사칙연산
  계산 시간을 알고 싶음 - 보조관심
  이 관심을 연산마다 집어넣음
  공통관심(보조관심) 
  배 보다 배꼽이 큼
  여기다 사람 이모티콘 찍어달라. -> 고칠게 많음 
  그럼 주관심과 보조관심을 분리
  AOP프로그래밍
  주관심, 보조관심 각각 짜서
  실행
  AOP 공통 모듈을 뽑아서 따로 짬
  프록시 패턴을 사용(가짜를 만듬)
  Spring의 고민, 주관심과 보조관심을 분리해서 사용하는 방식
  
  면접에서 많이 물어본다고함
  
  OOP와 AOP의 차이점
  
  * 객체지향의 3대 요소 : 상속, 다형성, 캡슐화
  1. 상속 : 재사용성 
  2. 다형성 : 상속관계에서 부모타입으로 여러개의 자식 객체를 가질 수 있음,
  	같은 이름으로 호출했는데, 다르게 동작(오버라이드)
  	상속 관계에서 부모타입 변수는 자식 타입의 주소를 가질 수 있다.
  3. 캡슐화 : 정보 은닉. private으로 선언 -> getter & setter로 간접 할당
  
  overloading(오버로딩)
   ex) System.out.println() // -> 컴파일 입장에서는 불쾌, 개발자 편의를 위해서 사용
   파라미터 타입과 개수를 다르게 하면 같은 이름의 메서드를 다르게 인식해서
   사용이 가능.
   
   1. 오버로딩은 성능과 무관
   2. 개발자 편의 위해 사용(설계자가 개발자를 배려)
   3. 오버로딩은 사용하지 않아도 문제가 되진 않음
   
   구문
   1. 메서드의 이름은 같고 파라미터의 [타입]과 [개수]는 다름
   	1.1 메서드 명이 같아야함
   	1.2 parameter의 개수, 타입이 다르면 됨
   	1.3 리턴 타입은 오버로딩의 기준이 아님
   	1.4 parameter의 순서가 다름을 **인정**
   	m(int i, String s) , m(String s, int i) 다르게 인식 
 */
class Human {
	String name;
	int age;
}

class OverT{
	int add(int i) {
		return 100 + i;
	}
	
	int add (int i, int j) {
		return i + j;
	}
	
	String add(String str) {
		return "hello" + str;
	}
	
//	int add(String s) { //-> 안됨 : 리턴타입과는 관계 없음
//		return 0;
//	}
	
	String add(int i, String s) {
		return "hello" + s;
	}
	
	String add(String s, int i ) { //-> 순서가 다르면 다르게 봄
		return "hello" + s;
	}
	
	// 파라미터의 타입, 개수, 나열 순서만 봄
	
	//Today Point
	void add(Human human) { // 참조타입
		human.age = 100;
		human.name = "홍길동";
	}
	
	void add(Human h, Human h2) {
		System.out.println("h : " + h + ", h2: " + h2);
	}
	
}

public class Ex11_Method_Overloading {
	public static void main(String[] args) {
		OverT overt = new OverT();
		System.out.println(overt.add("A"));
		System.out.println(overt.add('A')); // char타입은 정수와 호환됨
		//(아스키 캐릭터셋에 해당하는 정수값 A는 65)
		
		//방법1
		Human human = new Human();
		overt.add(human);
		System.out.println("이름 : " + human.name +", 나이 : " + human.age);
		
		//방법2
		overt.add(new Human());
		
		Human human2 = new Human();
		overt.add(human, new Human());
		overt.add(new Human(), new Human());
		overt.add(human, human2);
	}
}
