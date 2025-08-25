/*
 void m(int x){
 	//x값 출력 : 100
 	x =11111; // 파리미터 x 스코프 : 메서드가 끝나면 소멸
 }
 m(100); // 값에의한호출(call by value)
 
 메서드의 parameter 값을 전달 할 수 있고
 주소값을 전달 할 수 있음 Ref
 
 class Car{}
 void m2(Car c){ // c parameter는 Car라는 타입을 갖는 주소값을 받는다.
 	c.carName = "포드"
 }
 
 Car car = new Car()
 m2(car); //-> Call by reference 참조에 의한 전달
 줄여서 Ref
 car.carName -> 포드
 */

class Data{
	int i;
	
}

public class Ex10_Method_Call {
	static void scall(Data sdata) { // Data 타입을 가지는 객체의 주소값을 받겠다
		System.out.println("메서드 : " + sdata.i); // sdata는 0xabx..주소값
		sdata.i = 1111;  // 0xabx.i
	}
	
	static void vcall(int x) { // 값 정수값을 받겠다
		System.out.println("before : " + x); // 1111
		x = 8888;
		System.out.println("after x : " + x); //8888
	}
	public static void main(String[] args) {
		Data d = new Data();
		d.i = 100;
		System.out.println("d.i : " + d.i); // 100
		
		Ex10_Method_Call.scall(d); //자기꺼는 그냥 써도 되니까 scall(d); 생략해서 써도 됨
		System.out.println("d.i : " + d.i); // 1111
		// 주소값을 주고 주소값의 i를 바꿨으니까 원본이 바뀜(Ref)
		
		vcall(d.i); //1111을 보냄
		System.out.println("d.i : " + d.i); // 1111
		// 값을 보냈으므로 원본 변경 없음
		
		//-> 값을 전달, 주소값 전달의 차이
		// call by value, call by reference
		// 원칙 : 모든 함수의 실행은 stack 메모리
		
	}
}
