/*
  컬렉션 프레임워크의 목적 
  	다수의 데이터를 다루는 방법을 표준화 하자.
  	-> 다양한 인터페이스를 설계함
  	-> 구현한 클래스를 설계
  	
  	JAVA API -> 수많은 인터페이스와 클래스를 가지고 있음
  	그중에 하나가 Iterator 인터페이스
  	
  	Iterator 인터페이스
  		나열된 자원에 대해서 순차적으로 접근해서 값의 유무를 판단하고
  		값을 리턴하는 표준을 정의. 
  		
  		배열, ArrayList -> for, while -> 접근해서 처리 방식 표준화
  		-> Iterator 사용
  		
  	Iterator 인터페이스를 누가 구현하고 있느냐?
  	-> ArrayList가 구현(implemets)하고 있다.
  	-> Iterator 인터페이스의 추상 메서드를 ArrayList가 오버라이드(메서드 재정의)함
  	-> hasNext(), Next(), remove() 추상메서드를
  	-> ArrayList implements Iterator 
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Ex07_Collection_Iterator {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add(100);
		list.add(200);
		list.add(300);
		
		for(int i = 0;i < list.size();i++) {
			System.out.println(list.get(i).toString());
		}
		
		// 약속 컬렉션 프레임 워크
		// 순차적으로 접근해서 데이터 뽑아냄
		Iterator it  = list.iterator(); 
		// iterator() 호출 시 메서드 안에서 Iterator 인터페이스를 구현하고 있는
		// 객체의 주소를 리턴함(자식객체 주소 부모타입 변수에서 저장 가능)
		// 표준화된 방법
		while(it.hasNext()) { // 다음 번지에 데이터 있는지 물음
			System.out.println(it.next());
		}
		// 순차적으로 나열된 자원에 대해서 표준화된 방법으로 데이터를 접근하여 출력
		
		// 8가지 기본 타입 -> Generic은 객체타입만 사용가능
		// 8가지 기본 타입에 대해 클래스를 만듬 -> wrapper class
		// int -> Integer 등..
		List<Integer> intList = new ArrayList<>();
		intList.add(1);
		intList.add(2);
		intList.add(3);
		Iterator<Integer> it2 = intList.iterator();
		// Iterator를 구현하고 있는 객체의 주소를 반환
		
		while(it2.hasNext()) {
			System.out.println(it2.next());
		}
		// 단점 : 전진밖에 못함
		
		for(int i = intList.size()-1 ;i >= 0;i--) {
			System.out.println(intList.get(i));
		}
		System.out.println();
		// Iterator을 역방향으로 쓰기
		// 갔다가 돌아와야 함
		ListIterator<Integer> it3 = intList.listIterator();
		// 순방향
		while(it3.hasNext()) {
			System.out.println(it3.next());
		} //지금 현재 커서가 끝에 있음
		System.out.println("***************************");
		//역방향 
		while(it3.hasPrevious()) { // 이전값 있는지 물어봄
			System.out.println(it3.previous()); // 이전값 가져옴
		}
		
		// 참고 remove
		List<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		
		System.out.println(numbers); //[1, 2, 3, 4] toString()재정의함
		
		Iterator<Integer> itr = numbers.iterator();
		while(itr.hasNext()) {
			int num = itr.next();
			if(num % 2 == 0) {
				itr.remove(); //짝수 데이터를 삭제
			}
		}
		System.out.println(numbers);  //[1, 3]
	}
}
