/*
 클래스 : 설계도(사용자가 만드는 사용자 정의 타입)
 클래스의 구성 요소 : [필드(속성) + 메서드(기능)] + 생성자
 
 필드(멤버 변수, member field) : 데이터, 정보를 담고 있음
 	고유 정보, 상태 정보, 부품 정보

함수와 메서드 용어 구분
자바는 클래스 안에서만 함수를 정의할 수 있음
클래스 안에 정의한 함수를 메서드라고 부름
자바의 모든 함수는 메서드
(그래서, 자바는 함수가 없고 메서드만 있다는 말이 있음)

함수(method) 기능 자동차 달린다, 멈춘다, 소리가 난다, 문을 연다

생성자의 목적 : 객체가 생성될 때 호출 + 필드 초기화, (필드 초기화 목적의 메서드)

 * getter & setter(캡슐화 된 자원 - 정보 은닉, 간접 할당)
 	* getter : private 필드의 값을 반환하는 메서드(읽기)
 	* setter : private 필드의 값을 변경하는 메서드(수정)

 class 클래스명{
 	// 필드(멤버변수)
 	고유정보;
 	상태정보;
 	부품정보; // 다른 사용자 정의 클래스 타입( 그 클래스 타입의 주소만 저장 가능)
 	//-> 또 다른 설계도를 가짐
 	
 	생성자(필드 초기화)
 	
 	//메서드
 	기능(행위)
 }
 // -> 재사용성을 높이기 위해서 
 // -> 설계도 1개로 다른 객체를 계속 찍어냄
 
 클래스, 필드, 생성자, 메서드
 영역을 가지고 있음(범위, 스코프) -> 생성되는 장소, 위치에 따라서 달라지는게 있다

* 접근제어자(한정자, 수정자)
	프로그램에서 말하는 장소와 위치는 폴더(패키지) 위치를 말함
	패키지 기반으로, 클래스 내부, 제어문 내부에 따라 라이프 사이클(사용 범위 제한)
	
	public : 같은 프로젝트 전체에서 사용 가능
	private : 현재 클래스 내부에서만 (캡슐, 은닉화의 유일한 키워드) 사용 가능
	default : 생략 가능, 같은 패키지 내에서만 사용 가능
	protected : 같은 패키지 내 + 상속 관계에서만 사용 가능
	(반드시 구현하라고 강제 할 때 사용)
	
* 패키지 명 : 도메인을 거꾸로 함
	kr.or.kosa.commom 안에 클래스 Car 만듬 public class Car() {}
		프로젝트 내 전체에서 사용 가능
	kr.or.kosa.commom 안에 클래스 AirPlane 만듬 class AirPlane {} 
		default 키워드 사용(생략 가능, 생략하면 default) 같은 패키지 내에서만 사용 가능 

 * */
/*
 연습 
 하나의 클래스 안에서 클래스 만들어서 사용(원칙은 패키지 구분, 별도의 클래스 구분해야함)
 * */

class Emp{ //default class Emp
	
}

class Dept{ //default class Dept
	int deptno; // default (같은 패키지 내)
	public String dname;// (프로젝트 전체)
	// 클래스는 default인데 필드는 public
	// 여기서 public은 의미가 없음
	
	private int count;// 해당 클래스 안에서만 접근 가능
	// 설계자의 의도(왜 이렇게 만들었을까?) : 은닉, 캡슐화 
	// 이 count 필드는 클래스 내부에서만 쓰겠다
	// 다른 클래스에서 count쓰고 싶다면?
	// getter & setter 제공
	// 직접 할당 X, 간접 할당으로 제어
	
	// 메서드 하나는 하나의 기능 구현
	// getter 메서드 : 읽기 전용 
	public int getCount() {
		return count;
	}
	
	//setter 메서드 : 값 변경(쓰기) 전용
	public void setCount(int count) {
		if(count < 0) { // count가 음수이면
			count = 0; 
		} else {
			this.count = count;
		}
	
	}
}

// 연습용(같은 패키지 내에서 접근 가능) - 실무에서는 사용 X
class Test{ //default 생략
	int i; //default 생략 
	
	void print() { //default void print
		for(int i = 0;i <= 100;i++) {
			
		}
	}
}

public class ex01_Main { // .java파일 1개에서 public클래스는 오직 1개

	public static void main(String[] args) {
		Dept dept = new Dept(); // 객체생성(힙공간 메모리에 올림)
		//dept 변수는 힙공간 Dept 객체의 주소값을 스택 공간에 저장
		dept.deptno = 10;
		dept.dname = "홍길동";
		dept.setCount(-100); // private count 값 쓰기
		// 객체 지향은 클래스 내의 필드를 private를 쓴다(캡슐화)
		// 누구나 쓸 수 있고, 오랜 시간이 지나도 변경되지 않는 코드는 눈에 안보이게 된다 
		// -> 자동화(롬복), 스프링, 정형화되는 코드
		// 자동화 되어서 안보일뿐..
		
		Test t = new Test();
		t.i = 100;
		t.print();
		
	}

}
