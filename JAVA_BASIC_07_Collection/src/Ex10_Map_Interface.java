/*
 	Map 인터페이스 
 		key - value를 쌍의 구조를 갖는 배열
 			인덱스 0에 key - value 쌍으로 들어감
 			ex) 지역번호 (02, 서울), (031, 경기)
 		
 		key는 중복 불가, 값은 중복 허용
 		key -> Set
 		value -> List
 		
 		제네릭 지원함
 		
 	* Map 인터페이스를 구현하는 클래스
 		HashTable(구버전) : 동기화 보장(락을 검, 성능 떨어짐, 보안엔 좋음) 
 		HashMap(신버전) : 동기화 보장하지 않음(락은 옵션으로 걸 수 있음, 성능을 높임)
		
		개발하는 코드 -> 다수의 집합을 다룸
			Array
			ArrayList
			HashMap
			 + Generic
			=> CRUD 
			DB를 통해서 회원가입, 회원정보 조회, 회원정보 수정, 회원정보 삭제(논리적 삭제)
			
		+ I/O파일 쓰기, 읽기 -> 객체 읽기, 쓰기 -> 직렬화
		+ 성능 고려 -> Stream, 람다 -> 함수형 프로그래밍(굳이 클래스를 만들지 않고도 사용 가능)
 */

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Ex10_Map_Interface {
	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("Tiger", "1004");
		map.put("scott", "1004");
		map.put("superman", "1007");
		
		System.out.println(map.containsKey("tiger")); 
		//false : key에 대한 대소문자 구분함
		System.out.println(map.containsKey("scott")); // true
		System.out.println(map.containsValue("1004"));
		//true 1004 값 존재
		
		//key를 줄테니 value값 달라 get(키); -> value리턴
		System.out.println(map.get("Tiger")); // 1004		
		System.out.println(map.get("홍"));
		// null : 없는 key에 대해서는 null을 리턴
		System.out.println(map.size()); // 3
		
		map.put("Tiger", "1008"); // key값을 중복 사용하는 경우
		//-> **덮어씀**
		// value를 replace함
		System.out.println(map.get("Tiger")); // 1008
		System.out.println(map.size()); // 3
		System.out.println(map.toString()); //{scott=1004, superman=1007, Tiger=1008}
		// toString()재정의함
		
		Object value = map.remove("superman");
		//리턴값 : 혹시모르니까 복원하도록 보관해라 
		System.out.println(value);
		System.out.println(map.toString());
		Set set = map.keySet(); 
		// key의 집합은 중복된 데이터가 없고, 순서가 없는 데이터의 집합
		// 내부적으로 new HashSet()
		// 내부적으로 key의 집합을 가져다가
		// Set인터페이스 타입을 리턴, Set인터페이스를 구현한 객체를 만들고 
		// 그 주소값을 반환한다
		
		Iterator it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
			//scott Tiger
		}
		
		Collection cList = map.values(); // 순서가 있는, 중복 허용하는 데이터 집합 객체 생성
		// ArrayList -> 객체의 주소를 리턴
		
		System.out.println(cList.toString()); //[1004, 1008]
		// 값들의 집합을 출력
	}
}
