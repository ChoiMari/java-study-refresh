//Today Point

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex02_ArrayList {
	public static void main(String[] args) {
		//List 인터페이스 구현하고 있는 클래스
		// -> ArrayList -> 순서보장(내부적으로 배열로 관리), 중복 허용
		// 예) 식당 번호표, 은행 번호표(동명이인도 상관없다)
		ArrayList arrayList = new ArrayList();
		arrayList.add(100); //[0]
		arrayList.add(200); //[1]
		arrayList.add(300);
		arrayList.add(100);
		System.out.println(arrayList.toString()); // [100, 200, 300, 100]
		
		for(int i = 0;i < arrayList.size();i++) {
			System.out.println(arrayList.get(i));
		}
		
		// add() 메서드는 데이터를 순차적으로 넣는다.
		// 배열의 인덱스를 알고 있음
		arrayList.add(0, 1111); // 인덱스 0에 1111을 넣음
		//-> 뒤에 있는게 다 밀림(비집고 들어옴)
		System.out.println(arrayList); 
		// [1111, 100, 200, 300, 100] -> 성능에 안좋다
		// 빠지면 다 올려붙임
		// (인덱스 사용 가능)검색은 빠르지만 add(),remove() 추가/삭제는 성능 안좋음
		// linkedList는 노드 개념이라서 add(),remove()는 빠르지만 검색은 느림
		// 자료 알고리즘은 따로 공부하기..
		// 자바스크립트도 동적 배열이라서 밀린다고함
		
		// ArrayList 단점, 해결 방법(ArrayList와 linkedList의 차이점)
		// 지금은 잘 안 물어본다고 함
		
		//1. 비순차적으로 데이터 추가, 삭제는 성능이 좋지 않다 
		// -> 순서가 있는 데이터 집합에서는 성능이 안좋다.
		// 순차적으로 하는 데이터 추가/삭제에는 유리함
		
		// ArrayList의 다양한 메서드
		System.out.println(arrayList.contains(200));
		// 200을 포함하고 있느냐? true
		System.out.println(arrayList.size()); // 5
		arrayList.clear();
		System.out.println(arrayList.size()); // 0
		//데이터 삭제(용량은 그대로)
		
		arrayList.add(101);
		arrayList.add(102);
		arrayList.add(103);
		System.out.println(arrayList.isEmpty()); 
		// 비워져있니? false(데이터 있다)
		
		Object value = arrayList.remove(0); // [101][102][103]
		// 지우기 전의 인덱스 0번의 데이터를 넘겨줌
		// 지울건데 필요하면 이걸로 복원해라..
		System.out.println(arrayList.toString());
		// [102][103][]
		
		// Point 다형성
		// 인터페이스 부모타입
		// ArrayList list = new ArrayList();
		// 습관적으로 다형성
		List list = new ArrayList<>();
		// List인터페이스를 구현하고 있는 객체의 주소를 저장 가능
		// List에 선언된 자원만 사용 가능
		// ArrayList에서 재정의한 메서드가 호출됨
		
		list.add("가");
		list.add("나");
		list.add("다");
		list.add("라");
		System.out.println(list.toString()); // [가, 나, 다, 라]
		List list2 = list.subList(0, 2); // 내부적으로 리스트 객체를 만듬
		// List객체를 만드는데 객체는 리스트를 구현한 객체
		// List 인터페이스 타입으로 받아야함
		System.out.println(list2); //[가, 나]
		//list2.toString() 한거와 같음
		
		List alist = new ArrayList<>();
		alist.add(50);
		alist.add(1);
		alist.add(7);
		alist.add(40);
		alist.add(46);
		alist.add(3);
		alist.add(15);
		// 넣은 순서대로 
		System.out.println(alist.toString()); //[50, 1, 7, 40, 46, 3, 15]
		Collections.sort(alist); // 낮은 값부터 정렬
		System.out.println(alist);//[1, 3, 7, 15, 40, 46, 50]
		
		// 높은값부터 출력
		// 낮은값부터 정렬한거 뒤집어야된다고
		Collections.reverse(alist);
		System.out.println(alist);
	}
}
