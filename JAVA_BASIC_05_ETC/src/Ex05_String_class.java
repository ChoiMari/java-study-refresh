/*
  8(기본타입) + 1(String)
  
  String은 class(참조타입)
  문자열 다루기("홍길동") -> 문자열은 조작을 많이 함
   자르고, 합치고, 나누고, ... 기능들이 필요함
   -> 클래스로 만듬
   String클래스는 일반 메서드 + static 메서드를 가지고 있음
 
 */
public class Ex05_String_class {
	
	public static void main(String[] args) {
		String str = ""; // 초기화 null 또는 ""로 함
		String[] strarr = {"aaa", "bbb", "ccc"};
		
		for(String s : strarr) {
			System.out.println(s);
		}
		//사용방법 : int, double 사용법과 동일함
		
		String st = "홍길동";
		System.out.println(st.length()); // 3
		/*
		 String은 char[] 문자배열로 데이터를 관리함
		 [홍][길][동]
		 내부적으로 char[] 사용
		 */
		System.out.println(st); // 홍길동
		//String 클래스가 toString()을 오버라이드 함
		//그래서 오브젝트 클래스의 주소값이 반환되지 않음
		
		// 정식 표기
		String sdata = new String("김유신"); // 오버로딩
		System.out.println(sdata); // 김유신
		
		String name = "가나다라마";
		// 내부적으로 데이터 관리 char[] -> [가][나][다][라][마]
		
		String str1 = "AAA";
		String str2 = "AAA";
		System.out.println(str1);
		System.out.println(str2.toString());

		System.out.println(str1 == str2); 
		// == 는 주소값 비교 : true
		// 같은 데이터라서 객체 생성 또 안하고 같은 주소를 바라본다고 함
		
		// Today Point
		// 문자열 비교는 그 안에 들은 데이터(값) 비교해야함
		System.out.println(str1.equals(str2));
		// 주소를 찾아가서 그 안의 값을 비교함
		
		String str3 = new String("BBB");
		String str4 = new String("BBB");
		//-> 이러면 새로운 메모리에 할당함(같은 데이터라도)
		System.out.println(str3 == str4); // false 주소가 다르다
		
		System.out.println(str3.equals(str4)); // true
		// 주소를 가지고 값을 찾음, 값을 비교해서 리턴
		
		String s = "A";
		s += "B";
		s += "C";
		System.out.println(s);
		s = "A";
		System.out.println(s);
		// **************************************************
		// String을 문자열 누적에 사용하면 효율에 안좋다
		// 누적할수록 메모리에 할당해서 주소를 참조하기 때문에
		// 그래서 이럴땐 StringBuilder, StringBuffer 사용을 권장함
		
	}
}
