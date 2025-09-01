/*
 자바 문법 END
 (변수, 데이터 타입, 연산자, 제어문, 객체지향(상속, 다형성, 은닉), 추상클래스, 인터페이스, ...)
 
 자바가 제공하는 클래스 -> 컬렉션(Collection)
 [다수의 데이터]를 다루는 방법을 [표준화된 인터페이스]로 구현하는 클래스를 제공(API)
 
 Collection 인터페이스를 상속하고 있는 List를 구현하고 있는 Vector, ArrayList
 Collection 인터페이스를 상속하고 있는 Set를 구현하고 있는 HashSet
 
 Map 인터페이스(key-value 쌍의 배열)를 구현하고 있는 HashMap
 
 Collection 인터페이스에 정의된 것을 구현하고있음
 	ArrayList의 부모 타입은 List이다(다형성, List 인터페이스를 구현하고 있으니까)
 	Collection인터페이스는 ArrayList의 부모타입이다
 	-> (Collection 인터페이스를 상속하고 있는 List를 구현하고 있으니까)
 	
 1. List (줄을 서시오)
 	순서가 있는 데이터 집합(순서? 저장된 순서대로 인덱스를 가짐)
 	중복 데이터 가능
 	
 	이런 데이터를 관리하는 클래스 -> Vector(구버전), ArrayList(신버전)
 	Tip) 내부적으로 Array(배열)로 관리 
 	
 	1-1 Vector는 동기화를 보장
 	동기화는 싱글쓰레드 방식(메모리에 stack 1개)에서 의미 없음 
 
 	멀티 쓰레드는 메모리에서 stack을 여러개 잡음(예시 - 3개)
 	3개의 stack은 CPU를 점유하기 위해서 실행 될 수 있음
 	락을 건다 -> 동기화 보장
 	락을 걸어놓고 기다리게 만듬. 작업을 끝내면 락을 품
 	
 	동기화를 보장하면 공유자원(자기자신 Vector)에 락을 검(작업중에)
 	기본값이 Lock을 검
 	성능 떨어짐(대기시간 존재하니까)
 	보안성은 높음(락을 걸기 때문에)
 	
 	1-2 ArrayList은 동기화를 보장하지 않음
 		필요 여부에 따라서 Lock설정 가능
 		기본값이 Lock이 아니다.
 		성능은 높이고 보안성은 떨어짐
 		
 	개발할 때 Vector 잘 안씀(레거시 유지보수나 학습용도)
 	지금은 ArrayList사용
*/
public class Ex01_Vector {

	public static void main(String[] args) {
		

	}

}
