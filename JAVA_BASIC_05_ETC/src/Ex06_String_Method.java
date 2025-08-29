import java.util.StringTokenizer;

public class Ex06_String_Method {
	
	public static void main(String[] args) {
		String str = "hello";
		String concarstr = str.concat(" world"); 
	    //기존의 문자열에 연결해서 새로운 문자열로 만들어서 리턴
		System.out.println(concarstr);
		
		
		//str.contains("eloo");//false
		//문자순서(시퀀스) - 순차적으로 연결된 순서로 판단
		
		String str2 = "a b c d";
		//String은 char[]
		
		String filename = "hello java world";
		System.out.println(filename.indexOf("e")); // 1
		// 캐릭터의 인덱스값 1
		// e가 인덱스 1번 위치에 있음
		
		System.out.println(filename.indexOf("java")); // 6
		// 시작 위치를 묻는것
		// 인덱스 6번 부터 시작한다
		
		System.out.println(filename.indexOf("안녕")); //-1
		// 없으면 -1리턴
		
		if(filename.indexOf("wo") != -1) {
			System.out.println("wo 하나라도 있다"); // 출력됨
		}
		
		//indexOf() 활용 : 
		//특정 문장에서 내가 원하는 단어의 포함여부를 확인할 때 많이 사용함
		
		//String filename = "hello java world";
		System.out.println(filename.lastIndexOf("a")); //9
		// 끝에서 만난 처음 만난 a의 인덱스
		
		// 그 외 자주 만나는 함수(외우기)
		// length(), indexOf(), substring(), replace(), split()
		
		String result = "superman";
		System.out.println(result.substring(0)); //superman 
		//인덱스 0부터 끝까지 다나옴
		
		System.out.println(result.substring(1)); //uperman 
		//인덱스 1부터 끝까지
		
		System.out.println(result.substring(1,2)); // u
		
		/*
		  beginIndex the beginning index, inclusive.
		  endIndex the ending index, exclusive. (index -1)
		 */
		
		System.out.println(result.substring(0,1)); //s
		// 0,0과 같음
		System.out.println(result.substring(0,0));
		// 0, -1 -> 아무것도 안나옴. 빈 문자열
		
		//Quiz
		String filename2 = "home.jpg"; //또는 h.jpeg 또는 aaaaa.hwp
		//파일명과 확장자 분리해서 출력하기
		// 단, 위에서 배운 함수만 사용하기
		
		//String[] sstr = filename2.split(".");
		
		int index = filename2.lastIndexOf(".");
		
		//파일명
		System.out.println(filename2.substring(0,index)); // home
		// 확장자
		System.out.println(filename2.substring(++index)); // jpg
		//System.out.println(filename2.substring(index)); // .jpg
		
		System.out.println(filename2.substring(index, filename2.length()));
		//jpg
		
		String str3 = "ABCDADDDDDA";
		String result3 = str3.replace("DDDDD","오늘은 금요일");
		//DDDDD를 오늘은 금요일로 치환
		System.out.println(result3); //ABCDA오늘은 금요일A
		
		String result4 = str3.replace("A","a"); //대문자 A를 전부 a로 바꿈
		System.out.println(result4); //aBCDaDDDDDa
		
		System.out.println(str3.charAt(0)); // A
		System.out.println(str3.charAt(3)); // D
		System.out.println(str3.endsWith("DDDA")); 
		// 끝에서 부터 연결된 문자열 가지고 있니? true 리턴
		System.out.println(str3.equalsIgnoreCase("abCDADDDDDA"));
		//true 대소문자 무시하고 같은지?
		
		//Today Point
		String str4 = "슈퍼맨,팬티,노랑색,우하하,우하하";
		String[] namearray = str4.split(","); // 아큐먼트 : 정규표현식
		//,를 기준으로 쪼갬
		for(String s : namearray) {
			System.out.println(s);
		}
		System.out.println("***************");
		String str5 = "슈퍼맨.팬티.노랑색.우하하.우하하";
		String[] namearray2 = str5.split("\\."); // 아큐먼트 : 정규표현식
		//String[] namearray2 = str4.split("."); 이걸 못쪼갬 

		for(String s : namearray2) {
			System.out.println(s); // 안나옴
		}
		/*
		  IP 주소
		  192.5.1.100 - 영역대 추출 원할때
		 */
		
		// 정규 표현식 
		/*
		 	문자들을 조합해서 규칙을 만들고 그 규칙과 데이터를 비교해서 판단함
		 	
		 	ex) 우편번호 {\d3-{\3}} -> 12-123 ->false
		 	{} : 필수
		 	반드시 10진수 3자리 - 반드시 3자리
		 	
		 	123*123 -> false
		 	111-111 -> true
		 	
		 	활용 : 유효성 검사에 쓰임
		 	
		 	Pattern 클래스 활용
		 	matcher()사용으로 검증(static 메서드)
		 	
		 	예제 코드)
		 	String pattern = "^[0-9]*$"; //숫자만
            String val = "123456789"; //대상문자열
        
            boolean regex = Pattern.matches(pattern, val);
            System.out.println(regex);
		 */
		
		// 참고
		/*
		  동기화 
		  	Lock, 멀티 쓰레드
		  	
		  	한강에 놀러감
		  	화장실이 있음
		  	
		  	누가 들어감. 제일 먼저 한 행동? 문을 잠금
		  		뒤에는 줄을 섬
		  		근데 안나옴.. 그럼 계속 기다림
		  		
		  		화장실 : 공유자원(안전을 위해서 누가 쓰면 잠궈놓음)
		  		락을 검..(대기 상태) -> 성능이 떨어짐
		  	-> 동기화
		  	
		  	사람 한명 한명을 쓰레드로 봄
		  	동기는 자원 보호에는 좋지만 성능상 문제가 생김(대기 상태가 있어서 느림..)
		  	
		  이번에는, 비빔밥 만듬
		  	줄을 서시오. 비빔밥을 보호하려고 줄을서라고..
		  	과연 맞는 판단일까? 비효율
		  	그냥 둘러서서 다들 퍼먹으면 된다.
		  	그럴려면 다 접근해야할 수 있어야함
		  	단, 누가 더 많이 차지하는지는 보장을 못함
		  	성능을 고려한다면 락을 걸지 않음
		  	누가 더 많이 차지할지는 모르겠지만 빨리소진 가능
		  	-> 동기화를 보장하지 않음(락 없음, 성능 빠름)
		  	
		  	비빔밥에 참가하는 사람 한명한명이 쓰레드
		  	현재는 싱글쓰레드만 사용함(스택에 1개
		 */
		
		//StringTokenizer 클래스 -> 객체화 써서 써야함
		String str6 = "a/b,c-d.f";
		StringTokenizer sto = new StringTokenizer(str6,"/,-.");
		
		while(sto.hasMoreElements()) { //이중에 구분값이 있냐, 있으면 실행
			System.out.println(sto.nextToken());
		}
		
		//넌센스
		String str7 = "홍     길      동";
		//DB저장 -> 공백제거 -> 홍길동
		//replace() : 공백을 ""빈문자열로 치환
		System.out.println(str7.replace(" ", "")); // 홍길동
		String str8 = "   홍길동    ";
		System.out.println(str8.trim());
		
		String str9 = "  홍   길   동  ";
		System.out.println(str9.trim().replace(" ", "")); //홍길동
		// 자바 메서드 체인
		// 리턴값으로 호출 -> 호출 가능
		
		int sum = 0;
		String[] numarr = {"1", "2", "3", "4"};
		// 이 배열의 총합을 구하기
		for(String numstr : numarr) {
			sum += Integer.parseInt(numstr);
		}
		System.out.println("sum : " + sum);
		
		//주민번호 합을 구하기
		String jumin = "123456-1234567";
		String[] juminarr = jumin.replace("-", "").split("");
		int sum2 = 0;
		for(String juminstr : juminarr) {
			sum2 += Integer.parseInt(juminstr);
		}
		System.out.println("주민번호 합 : " + sum2);
	}
}
