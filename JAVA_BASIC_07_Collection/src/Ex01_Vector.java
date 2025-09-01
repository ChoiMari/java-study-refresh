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
 	
 	-------------------------------------
 	다수의 데이터를 다루는 방법
 		* Array 배열 -> 정적 , 고정
 			방의 개수가 한번 정해지면 방의 크기는 고정됨(변경 불가)
 		
 		예) int[] arr = new int[5];
 			int[] arr2 = new int[] {10,20,30};
 			int[] arr3 = {100, 200, 300};
 		
 		데이터가 추가 되면? 방 크기 못 늘림(변경 불가)
 			더 큰 새로운 배열 생성해서 이사 시켜야함
 			기존 데이터 이사시키고 + 새로운 데이터 추가해야함(개발자가 구현)
 			
 		* List 인터페이스를 구현하고 있는 ArrayList, Vector는
 		  1. 배열의 크기는 동적으로 확장/축소 가능하다
 		  	-> 진실은 **컴파일러**가 새로운 배열을 생성해서 데이터를 이동시킴
 		  2. 순서를 유지함(내부적으로 배열이 기반), 인덱스 사용 가능, 중복 가능
 		  3. 중복값 허용, 인덱스로 제어
 		  
 		  
 	-------------------------------------
*/

import java.util.Vector;

public class Ex01_Vector {

	public static void main(String[] args) {
		Vector v = new Vector(); //defulat로 호출해서 쓰면 기본 공간 10칸으로 만들어줌
		System.out.println("초기 용량 : " + v.capacity()); // 10
		// add()로 11개 되면 용량을 20개로 늘림(2배로), 그렇게 컴파일러가 자동으로 늘려줌 -> 동적배열
		System.out.println("size 값 크기 개수 : " + v.size()); // 0
		
		v.add("AA"); // 순서[0]
		v.add("BB"); // 순서[1]
		v.add(10); // 순서[2
		// add() 파라미터 오브젝트 타입으로 받음
		System.out.println("size 값 크기 개수 : " + v.size()); // 3
		
		System.out.println(v.toString()); 
		//[AA, BB, 10] Vector가 toString() 오버라이드함
		
		// Array 배열에서의 length() 방의 개수 -> index로 조회
		
		// 컬렉션에서 size는 저장된 값의 개수 -> 메서드로 접근 
		//-> get() 아규먼트로 인덱스를 줌
		for(int i = 0;i < v.size();i++) {
			System.out.println(v.get(i));  //get() 리턴타입 : 오브젝트
		}
		// 왜 오브젝트로 줘?
		// 반기를 듬.. 그래서 제네릭
		
		for(Object obj : v) {
			System.out.println(obj);
		}
		
		// 단점 : 같은 데이터타입으로 리턴 받고 싶음
		// 근데 오브젝트(가장 큰 타입)을 이용해서 개발자들 불만
		//----------------------------------------------------
		
		//제네릭 사용
		Vector<String> v2 = new Vector<>(); //new Vector<String>();
		//String만 쓰도록 강제함
		v2.add("hello");
		v2.add("World"); 
		for(String str : v2){
			System.out.println(str);
		}
		
		Vector v3 = new Vector();
		System.out.println(v3.capacity()); // 기본 10칸 배열
		v3.add("A");v3.add("A");v3.add("A");v3.add("A");v3.add("A");v3.add("A");v3.add("A");v3.add("A");v3.add("A");v3.add("A");v3.add("A");
		System.out.println(v3.capacity()); // 20으로 늘어남
		// 11번째 add()하는 순간 2배로 큰 새로운 배열을 만들어서 이사시킨 후 주소값을 변경함(이전 주소는 끊어버리고)
		
		//-> 백터는 이젠 쓸일이 없다(학습용)
	}

}
