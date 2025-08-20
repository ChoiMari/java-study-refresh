import kr.or.kosa.Emp;
import kr.or.kosa.Car;

public class Ex01 {

	public static void main(String[] args) {
		System.out.println("hello");
		
		// 모든 클래스는 메모리에 올라가야 사용가능 
		// 현실 아파트 설계도 (종이) -> 구체화 -> 땅 집을 짓는 것 -> 주소, 건물 생성 
		
		int i=10;
		Emp e = new Emp(); // 힙에 올라간 Emp()의 주소값을 할당 
		e.empno = 7788;
		e.ename = "홍길동"; // 힙에 저
//		e.data = 1000; privat로 보호 : 간접할당을 통해 
		e.Info();
		
		// 자동차 만들기
		// 메모리에 올리자 (문법) 
	
		Car samsungCar = new Car();
		samsungCar.carInfoPrint(); // -> 0 / null : 데이터 타입에 따라 기본값이 정해져 있다 
		samsungCar.setDoor(2);
		samsungCar.setCarColor("red");
		samsungCar.carInfoPrint();
		
		Car lgCar = new Car();
		
	}

}
