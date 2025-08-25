/*
 초기화 : static 초기화 
 1. static variable : 객체마다 같은 값을 공유할거라는 의미
 2. instance variable : 생성되는 객체마다 다른 값을 가지게 하겠다.
 
 두 자원은 default 값(초기화 할 필요 없다)
 */

class Test2{
	static int cv = 10; // 초기화
	static int cv2; // default 0 
	
	int iv = 9;
	
	// static 자원에 대한 초기화 블록 static{}
	static {
		// static 변수를 초기화 할 수 있음
		// 실행되는 시점 : static int cv = 10; 
		//또는 static int cv2;가 메모리에 올라간 직후
		// **자동 호출**
		cv = 11111;
		cv = 10;
		// 사용 목적 ? 조작된 표현이 가능함
		// 조작된 표현? 연산 또는 제어문, 조건식 가능
		cv2 = cv + 2222;
		// 생성자에서도 할 수 있지만 이건 static이니까 
		// new 객체 생성 없이도 사용 할 수 있어야 하니까
		
		// 여기서는 static자원만 쓸 수 있음
		// 이유 : 일반 인스턴스(일반 자원) 
		//variable은 메모리에 안올라가져 있으니까 쓸 수 없음
	}
	
	// 일반 자원(초기화) : 아무것도 없는 {}블록.. 근데 잘 안씀.. 
	// 이유 : 생성자 쓰면 되니까
	{ // 초기화 시점 : 객체 생성 시 호출
		// new Test2() -> heap영역 만들어지고 member field올라가고
		// 자동으로 이 초기화 블록 { }이 실행됨
		System.out.println("초기화 블록이 실행");
		if(iv < 10) iv = 10000;
	}
	
}

public class Ex07_Static_Init {

	public static void main(String[] args) {
		System.out.println(Test2.cv);
		System.out.println(Test2.cv2);
		
		Test2 test2 = new Test2(); // 초기화 블록이 실행
		System.out.println(test2.iv); // 1000
		
	}

}
