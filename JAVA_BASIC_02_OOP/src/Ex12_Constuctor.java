/*
 생성자 함수(constructor)
 1. 특수한 목적의 메서드
 2. 목적 : 필드(멤버변수)의 초기화
 	static {}, {}
 3. 일반 메서드와 다른점
 	3.1 메서드의 이름이 고정(클래스명과 동일)
 	3.2 return type 없음(객체생성과 동시에 호출)
 	3.3 new Car()하면 heap 객체 생성 -> 멤버필드 초기화 생성자 호출
 	3.4 ex) public Car(){}
 	
 	참고 ) 생성자 접근자 private 가능(싱글톤 패턴) : 객체를 하나만 만들어서 공유
 	
 4. 왜 생성자를 써야 할까?(목적)
 		[생성되는 객체] 마다 [강제적]으로 멤버 필드 초기화하기 위해서
 5. 생성자는 여러개 만들 수 있다(오버로딩)
 6. 파라미터가 있는 생성자를 만들면 컴파일러가 기본생성자를 자동으로 만들어 주지 않음
 	
 	class Car{
 		String color; 
 	} -> 설계도를 만든 사람은 색상 안해도 상관없다(안해도 어쩔 수 없다)
 	
 	class Car{
 		String color = "blue";
 	} //-> default값 
 	
 	문제) 자동차의 색상을 정하지 않고 출고
 	출고 (반드시 어떤 색상은 강제로 정하게 하고 싶을 때) -> 생성자 사용
 	
 	class Car {
 		String color;
 		
 		public Car() { //default constructor 기본 생성자 
 		
 		}
 		// 오버로딩 가능
 		public Car(String color){
 			this.color = color
 		}
 	}
 	
 */
class Car{
	String carName = "포니";
	//개발자가 강제적으로 구현하지 않는다면 기본생성자를
	// 컴파일러가 기본 생성자를 자동으로 만들어준다.
	
	// 개발자가 파라미터가 있는 생성자를 만들면
	// 컴파일러가 기본 생성자를 자동으로 만들어 주지 않음
	
	//그때는 필요 시 따로 기본 생성자를 작성 해주어야함
	
	public Car() {
		System.out.println("나는 기본 생성자");
		carName = "내마음";
	}
}

class School{
	String schoolName = "강남";
	// default 생성자가 생략 - 컴파일러가 자동으로 생성
	// public School(){}
}

class Car2{
	String carName;
}

class Car3 {
	String carName;
	
	public Car3() { // 기본 생성자를 직접 구현
		carName = "포니"; // 초기화 
	}
}

class Car4{
	String carName;
	
	public Car4() {
		carName = "기본포니";
	}
	
	public Car4(String carName) {
		this.carName = carName;
	}
	// Car4를 사용하는 개발자에게 옵션을 줌 : 기본생성자, 파라미터있는 생성자 호출 가능
}

class Car5{
	String carName;
		
	public Car5(String carName) {
		this.carName = carName;
	}
	// Car5를 사용하는 개발자에게 강제성을 줌, 
	// 객체 생성 시 carName을 반드시 초기화 해라.
	
	// 개발자가 생성자 오버로딩을 1개라도 만들면
	// 컴파일러는 기본 생성자를 자동으로 구현하지 않는다.
}

class Car8 { // 개발자의 설계 의도
	String carcolor;
	int door;
	
	// 생성자 오버로딩 - 옵션
	public Car8() { // 디폴트 값 줌 
		carcolor="blue";
		door=4;
	}
	public Car8(int num) { 
		carcolor = "blue";
		door = num;
	}
	public Car8(String color) {
		carcolor = color;
		door = 4;
	}
	public Car8(int num , String color) {
		carcolor=color;
		door = num;
	}
}

public class Ex12_Constuctor {
	public static void main(String[] args) {
		Car car = new Car();
		System.out.println(car.carName);
		
		Car4 car4 = new Car4("그랜저");
		System.out.println(car4.carName);
		
		Car5 car5 = new Car5("v6");
		System.out.println(car5.carName);
	}
}
