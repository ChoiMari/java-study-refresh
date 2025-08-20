/*
 클래스는 설계도이다.
 설계도는 큰 데이터 타입이다.
 Tip) 하나의 물리적인 java file에 여러개의 클래스를 만들 수 있을까?
 -> 만들 순 있지만, 안씀(실무 금지), 연습, 문법이해에 씀
 
 클래스 안에 클래스는 사용
 
 원칙적인 방법
 패키지
 kr.or.kosa.utils.Apt
 kr.or.kosa.model.AptModel
 
 * */
class Apt{
	// 클래스 - 설계도(데이터 타입 : 사용자 정의 타입)
	// 설계도는 구체화 되지 않으면 의미가 없다.(종이와 같음)
	// 메모리에 올리지 않음 의미가 없다는 뜻
	// 클래스의 목적
	// 설계도를 만들어서 Apt 설계도로 똑같은 아파트 무한히 생성하려고
	// 설계도는 목적 : 재사용성
	String doorColor; // 아파트는 문 색 가지고 있다.
	
}

public class Ex04_Object_Variable {

	public static void main(String[] args) {
		Apt apt; // apt 지역 변수는 Apt 아파트의 주소를 담을 수 있다.
		apt = new Apt(); // heap 메모리에 아파트가 만들어지고, 생성된 아파트의 주소를
		// apt라는 변수가 저장한다.
		System.out.println("apt : " + apt); // 메모리 heap공간에 있는 주소가 출력됨
		
		Apt apt2 = new Apt();
		// 이렇게 계속 아파트 만들어 낼 수 있음 
		
		// apt와 apt2는 메모리 주소가 다르다.
		// 스택 메모리에 주소가 저장
		// 증명
		System.out.printf("apt와 apt2는 같은가요? %b\n", apt == apt2);
		
		Apt apt3 = apt; //주소값 할당
		//주소값 apt 메모리를 가짐
		System.out.printf("apt3와 apt는 같은가요? %b\n", apt3 == apt);
		
		int i = 10;
		int j = i;
		j = 10000; //i 값 10
		
		apt2.doorColor = "red";
		System.out.println(apt2.doorColor);
		/*
		 * javac로 컴파일함
		 * 동작 : JVM이 OS에게 메모리를 빌려달라고 한다.
		 * OS가 빌려줌
		 * JVM이 런타임 환경 만듬(메모리 정리)
		 * 목적에 맞게 자료구조 만들거나 구조 정의, 할당
		 * main함수 실행 (-> 메모리 구조 그림 그리라고..)
		 * */
	}

}
