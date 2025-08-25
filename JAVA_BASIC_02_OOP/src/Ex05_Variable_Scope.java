/*
 1. instance variable : 객체 생성 시 만들어짐
 2. local variable : 반드시 초기화 해서 써야함(강제)
 3. block variable : 제어문에 사용되는 변수
 4. static variable : 공유 자원 변수
 
 
 Today Point
 	static variable : 공유 자원(heap에 생성된 객체간 공유 자원)
 	1. 객체 생성 이전에 메모리에 올라가는 자원(클래스(메서드) 영역에 올라감 : static자원이)
 	2. 설계도(클래스)를 구체화 시키는 방법은 new
 	3. static 자원은 new 없이도 메모리에 올라감(-> 메모리에 올라가지면 사용이 가능)
 	
*/

class VariableClass{
	int iv; // 멤버 변수(필드), 인스턴스 variable
	// iv 언제 사용 가능 할까요? (=메모리에 언제 올라가는지?) new로 객체화 할때
	// VariableClass v = new VariableClass();
	// heap메모리에 VariableClass 객체가 올라가고 객체안에 iv가 생성
	// VariableClass v2 = new VariableClass();
	// 목적 : 데이터(정보) 자료 담을 목적
	//	정보? 고유, 상태, 부품(다른 객체) 정보
	/*
	 	-> 생성되는 객체마다 다른 값을 가질 수 있다.
	 	-> 그래서 초기화 해서 값을 강제하지 않는다.
	 	default값
	 	int : 0
	 	double : 0.0
	 	char : '\u0000'
	 	boolean : false
	 	참조 타입 : null
	 * */
	
	static int cv;
	/*
	 1. class variable(클래스 변수) : 일반적으로 static variable(객체간 공유자원)
	 2. 목적 : 정보를 담는 것(생성되는 모든 객체가 공유하는 정보)
	 3. 접근 방법 : 클래스명.
	 	ex) VariableClass.cv
	 -> static키워드로 선언하면 new 안해도 메모리에 이미 올라가 있음
	 VariableClass v = new VariableClass(); v.cv
	 VariableClass v2 = new VariableClass(); v2.cv
	 //-> 중요 v.cv == v2.cv 같은 주소를 바라봄(static이여서)
	 
	 static 변수는 객체마다 따로 생성되지 않는다
	 클래스 로딩 시점에 딱 하나만 메모리(메서드 영역 Method Area)에 올라감
	 그래서 모든 객체가 같은 static변수를 공유
	 
	 ** 생성시점 **
	 Hello.java -> javac Hello.java -> Hello.class -> Hello.exe
	 static 변수 또는 static 메서드가 있다면
	 이걸 메모리 영역에 할당함
	 그런데 메서드 이름 main()이라면 정해진 규칙에 따라서 실행한다
	 Stack 영역 자원 할당
	 */
	
	void method() { 
		int lv = 0; // 메서드 안에 선언된 로컬 변수
		// 지역변수는 사용 전에 반드시 초기화 해야함
		// 생명 주기 : 메서드가 호출 되면 stack메모리에 올라가고
		// 메서드가 끝나면 소멸
	
		for(int i = 0;i <= 100;i++) {
			
		}
	}
}

public class Ex05_Variable_Scope {
	
	public static void main(String[] args) {
		VariableClass.cv = 100;
		VariableClass vc = new VariableClass();
		vc.iv = 200;
		vc.cv = 200; // 메서드 영역(클래스 영역)에 200으로 바뀜
		
		VariableClass vc2 = new VariableClass();
		System.out.println(vc2.cv); // 200
		vc.cv = 444;
		System.out.println(VariableClass.cv); // 444
	}
}
