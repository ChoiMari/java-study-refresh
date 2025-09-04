/*
 	Set 인터페이스
 		순서 보장 X(인덱스 X), 중복 X
 		순서가 없고 중복을 허용하지 않는 데이터 집합
 		구현 클래스 : HashSet, TreeSet
 */

import java.util.HashSet;
import java.util.Set;

public class Ex08_Set {
	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<>();
		hs.add(1); // 데이터가 들어가면 true리턴
		hs.add(100);
		boolean bo = hs.add(55);
		System.out.println("정상 : " + bo); //true
		
		bo = hs.add(1);
		System.out.println("결과 : " + bo); //false -> 중복데이터 존재(저장 안됨)
		System.out.println(hs); //[1, 100, 55] toString() 재정의 함
		
		// 이런 데이터의 집합은 뭐가있을까?
		// 로또, 차량번호, 사번, 계좌번호, 주민번호, 학번, 회원 ID 등등
		HashSet<String> h2 = new HashSet<String>();
		h2.add("b");
		h2.add("A");
		h2.add("F");
		h2.add("C");
		h2.add("Z");
		h2.add("A"); // 중복 : 저장 안됨
		h2.add("H");
		h2.add("K");
		h2.add("b"); // 중복 : 저장 안됨
		h2.add("b"); // 중복 : 저장 안됨
		System.out.println(h2.toString()); //[A, b, C, F, H, Z, K] 순서를 보장하지 않는다
		// set에 넣으면 자동으로 중복은 거르고 저장됨(순서는 보장 X)
		
		String[] str = {"A","B","C","D","B","A"}; // 10000건이라고 가정
		HashSet<String> hs3 = new HashSet<String>();
		for(int i = 0;i < str.length;i++) {
			hs3.add(str[i]);
		}
		System.out.println(hs3); //[A, B, C, D]
		// 중복 데이터 배제해서 저장됨

		//Quiz
		//아래 코드를 HashSet 으로 만들고 식사하세요
		/*
		 for(int i = 0 ; i < 6 ; i++) {
			lotto[i] = (int)(Math.random()*45 + 1);
			for(int j = 0 ; j < i ; j++) { //j < i (채워진 개수 만큼 비교)
				if(lotto[i] == lotto[j]) {
					i--;
					break;
					
				}
			}
		} 
	   */
		Set set2 = new HashSet();
		int count = 0;
		while(set2.size() < 6) { //6개 저장되면 멈춤
			set2.add((int)(Math.random()*45 + 1));
			count++; //실행 횟수 계산해봄(중복이면 저장안되고 재실행되기 때문)
		}
		System.out.println(set2); // [16, 17, 36, 39, 9, 31]
		System.out.println("몇번 실행? " + count);
		
	}// main()끝
}
