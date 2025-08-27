class Human{
	String name;
}

class OverClass{
	
	// 오버 로딩 : 파라미터 타입, 갯수를 달리해서 같은 이름의 메서드 사용(리턴 타입과 관계없음)
	int add(int i, int j) {
		return i + j;
	}
	
	void add(Human human) { // POINT : Human 객체의 주소값을 받겠다.
		// 주소값 만드는 방법 : new
		/*
		  1. add(new Human());
		  2. Human h = new Human(); -> add(h);
		 */
		
	}
	
	int add(int param) {
		return param + 100;
	}
	
	//POINT : 배열은 객체
	int[] add(int[] params) { 
		// 리턴타입 : 배열의 주소값을 리턴하겠다 
		// 파라미터 변수 : 배열의 주소값을 받겠다
		
		int[] target = new int[params.length];
		for(int i = 0;i < target.length;i++) {
			target[i] = params[i] + 1;
		}
		
		return target;
		//return null; // -> 배열은 객체(null : 주소값 없다)
	}
}

public class Ex07_Array_Method {
	public static void main(String[] args) {
		OverClass overclass = new OverClass();
		int[] source = {10, 20, 30, 40, 50};
		int[] ta = overclass.add(source); //아규먼트로 배열의 주소값을 넘김
		// ta는 리턴(target) 배열의 주소값을 받아서 저장
		
		for(int value : ta){
			System.out.println(value);
		}
	}
}

/*
 클래스도 타입
 class Emp{
 	Car carInfo(int[] param){ // int배열의 주소값을 받아서 
 	// Car객체의 주소값을 리턴하겠다
 		return new Car();
 	}
 }
  
 */
