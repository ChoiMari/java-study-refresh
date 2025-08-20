import kr.or.kosa.Emp;

public class Ex02_Variable {
	public static void main(String[] args) {
		
		//변수 정의 
		// 타입이란 
		// 제어문 
		
		int value; // 변수 선언 (지역변수) 선언은 되어있지만 초기화 되어있지 않음 / 초기화 : 변수의 초기화 : 변수가 할당을 통해 처음 값을 갖는 것 
//		System.out.println(value); 
		//the local variable value may not have been initialized : 지역변수는 사용시 반드시 초기화를 선행 해야 한다
		//지역변수(local) 무조건 초기화 해라 ....
		value = 100;  // 선언과 할당이 분리됨 
		
		// 선언과 할당을 동시에
		int age = 50;
		System.out.println(age);
		
		Emp emp; // 선언 (지역변수)
//		System.out.println(emp);
		// 초기화 : 메모리에 올리기 : new
		emp = new Emp(); // 주소값 할당 (초기화)
		
		// new 연산자 : 클래스 구체화 : 메모리(heap)에 할당 -> 메모리 주소 
		System.out.println(emp);
		
		// . 연산자는 주소를 찾아가는 연산자 : publc한 자원만 보임 
		System.out.println(emp.empno);    // 0 : 디트 
		Emp emp2 = emp;
		emp2.empno = 5000;
		System.out.println(emp.empno); // 주소값 할당 
	}
	
	/*
	 * 블럭 주석 
	   클래스는 설계도이고 데이터 타입이다. 데이터 타입은 작은 여러개를 가지는 큰 타입
	   클래스 변수명;
	   
	   클래스의 종류
	   1. class Car{} 이건 main 함수를 가지고 있지 않은 클래스
	    -> 독자적인 실행이 불가능하다 , 다른 클래스에 도움을 주는 클래스(이런걸 라이브러리라고 부름)
	   2. class Car{ public static void main() {}} main()함수를 가지는 클래스,
	      독자적인 실행이 가능하다.
	   3. 현재는 main 함수를 가지는 클래스가 필요하다. 결과를 확인해야 하기 때문
	   3-1. class Car{}는 new Car()로 사용.
	   3-2. new 없이도 메모리에 올릴 수 있는 방법이 있다 -> static 키워드 사용
	   3.3  필요한 변수 또는 함수가 메모리에 있다면?
	   		-> static 변수, static 함수는 new 없이 사용 가능
	   3.4 static 함수 실행 조건 main 함수(-> 이게 진입점, 약속)
	   
	   Tip) C#은 메서드 이름을 대문자로 사용함(main함수가 대문자)
	   C#) class Car {public static void Main(){}}
	   
	   변수(variable) : 데이터(자료)를 담을 수 있는 공간의 이름
	   이 공간은 컴퓨터 메모리를 뜻함
	   메모리 특정 영역의 이름
	   공간을 잡기위해서는 크기가 필요함
	   데이터 타입(자료형)
	   메모리 공간을 한정 시킬 수 있음(크기 정의)
	   메모리를 아껴써야 좋음
	   최소한 공간의 최대의 데이터 표현
	   근데, 사실은 지금은 아껴쓸 필요없다
	   자바는 기본 연산 단위가 int(4바이트)
	   int age = 150; //-> int +- 21억
	   
	   변수가 선언되는 위치(scope 유효범위)
	   1. instance variable : 객체 변수(클래스 안에서 선언되는 변수)
	   		class car { public int door }
	   2. local variable : 지역 변수(함수 안에 들어있다) 
	   		class Car {public void run(){int data = 0;}}
	   		// 여기서 메서드안의 data가 지역 변수
	   3. static variable(정적 변수) : (객체 간)공유 자원
	   		만드는법 : class Car {public static final NUM;} 
	   		// 주로 공유 데이터, 공용 기능, 상수에 사용
	   4. 함수안에 있는 제어 블록 안에 있는 변수(if문, for문 안에 있는 블록 변수)
	   		class Car {void run {for(int i = 0; i...}}
	   		스코프 범위 순서 
	   		static > instance > local > block
	 */

}
