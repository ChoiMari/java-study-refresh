package ko.or.kosa;

/*
 	기능(행위) 만드는 방법
 	-> 메서드

	method : 행위 또는 기능의 최소 단위
		하나의 메서드는 하나의 기능만을 구현해야한다
		그렇지 않으면 유지 보수가 힘들고 복잡하다.
		
		유지보수가 쉬워야 좋은 코드
	ex) 먹는 기능, 자는 기능
	
	모든 메서드는 호출에 의해서만 동작함
	누군가 메서드의 이름을 부르지 않으면 실행 되지 않음
	
	[JAVA의 메서드 종류 4가지]
	1. void, parameter가 있는거 : public void print(String str){실행구문}
	2. void, parameter가 없는거 : public void print(){실행구문}
	3. return 타입이 있으면서 파라미터가 있는거
		: public int print(int data){return 100;}
	4. return 타입이 있으면서 파라미터가 없는거
		: public int print(){return 100;}
		
	void : 리턴값 없음
	return type에는 뭐가 올 수 있을까?
	-> 기본타입, String, Array, class, interface, Collection
	
	public boolean print() {return true;}
	
	주의)
	public Car print() {Car c = new Car(); return c;} 
	// Car객체의 주소를 가지고 있는 타입을 리턴해야 함
	
	public Car print() {return new Car();}
	public String print() {return "AAA";}
	
	parameter type으로는 뭐가 올 수 있을까?
	-> 기본타입, String, Array, class, interface, Collection
	
	void print(int i) {} 호출 print(100);
	void print(String str) {} 호출 print("hello");
	void print(Car c) {} 호출 print(new Car()); 또는
		Car c = new Car(); print(c);
	
	메서드 이름 : 관습에 따름
	
	사원 테이블에서 사원의 모든 정보를 가지고 오는 메서드를 만드세요
		void getEMPAllList();
	
	사원 테이블에서 사원의 번호를 가지고 
	한 사원의 모든 정보를 가져오는 함수를 만드세요
	void getEMPAllListByEmpno(int empno)
*/

public class Fclass {
	public int data;
	
	// 메서드의 접근자(수정자)는 70%가 public
	// 메서드의 30%는 private : 
	//	목적 : 클래스 내부 사용 용도(공통 메서드)
	// 			클래스 내부에서 다른 메서드를 도와주는 메서드
	
	public void m() { // 리턴값, 파라미터 없음
		// 기능 구현
		System.out.println("일반 메서드 : void, parameter(x)");
	}
	
	public void m2(int i) {
		System.out.println("일반 메서드 : void, parameter(O)");
		System.out.println("parameter 값 활용 : " + i);
	}
	
	public int m3() { 
		return 1000;
	}
	
	public int m4(int data) {
		return 100 + data;
	}
	// 여기까지 가장 기본적인 메서드 4가지
	
	//확장
	public int sum(int i, int j, int k) { 
		// return type & parameterd 있는 메서드 
		return i + j + k;
	}
	
	private int subSum(int i) { // private 객체에서 접근 불가(클래스 내부)
		return i + 100; // 쓸때 없이 외부 노출해서 쓸까봐 private로 감춤(내부용도라)
	}
	
	public void callSubSum() {
		int result = subSum(100);
		System.out.println("call result : " + result);
	}
	
	public int opSum(int data) {
		int result = subSum(data);
		
		if(result > 0) {
			return 1;
		}else {
			return -1;
		}
	}
	
	/*
	 	메서드를 생성하는데
	 	정수타입의 parameter 2개를 받아서 둘중에 큰값을 리턴하는 함수를 만드세요
	 	
	 * */
	public int max(int num1, int num2) {
//		if(num1 > num2) {
//			return num1;
//		} else {
//			return num2;
//		}
		return (num1 > num2) ? num1 : num2;
	}
	
	
}// 클래스 끝
