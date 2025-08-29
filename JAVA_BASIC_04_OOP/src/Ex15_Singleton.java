/*
 디자인 패턴(생성에 관련된 이야기) -> new밖에 없음
 
  싱글톤 : 객체를 하나만 만들도록 강제해서 공유하는 방식
  의도 : 하나의 객체를 공유하는 보장성 코드를 만들어라.
  
  공유프린터
  공유 IP
  
  new를 통해서 객체를 생성하지 못하게 해라
 */



public class Ex15_Singleton {
	public static void main(String[] args) {
		// Singeton singeton = new Singeton(); 접근 불가
		Singleton s = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		Singleton s3 = Singleton.getInstance();
		
		System.out.println(s == s2);
		System.out.println(s2 == s3);
		// 몇번을 호출하더라도 같은 주소가 리턴됨
	}
}
