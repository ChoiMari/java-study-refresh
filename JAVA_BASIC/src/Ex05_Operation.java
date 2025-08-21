//import java.util.Random;
//import java.lang.*; // java.lang패키지에 있는 모든 자원을 열어놓고 쓰겠다
// -> 가독성이 떨어져서 좋지 않다고 함

//import java.lang.Math;

public class Ex05_Operation {

	public static void main(String[] args) {
		// 연산자(산술, 논리, 관계)
		int result = 100 / 100;
		System.out.println("result : " + result);
		
		result = 13/2;
		System.out.println("result : " + result); // 몫만 계산함
		
		// 나머지 알고 싶다면?
		result = 13 % 2;
		System.out.println("result 나머지 : " + result); // 나머지 1
		
		// DB로 가면 %문자열 검색 패턴으로 쓰인다
		// 오라클은 mod()함수 사용. 
		
		// 증가감 연산자 : ++ 1씩 증가, -- 1씩 감소
		int i = 10;
		++i; // 전위(전치) 증가
		System.out.println("i : " + i);
		i++; // 후위(후치) 증가
		System.out.println("i : " + i);
		
		// 중가감 연산자가 다른 연산과 결합 되지 않으면 의미가 없다.(전치, 후치)
		
		// 복습을 잘하자(8시간 배웠으면 8시간 복습해야한다)
		// Today Point 
		int i2 = 5;
		int j2 = 4;
		int result2 = i2 + ++j2; // 10
		System.out.println("result2 : " + result2 + ", j2 : " + j2);
		
		result2 = i2 + j2++; // 11 
		
		byte b = 100;
		byte b2 = 1;
		// byte b3 = b + b2; // Type mismatch: cannot convert from int to byte
		// ** 자바의 정수 연산의 기본값은 int 
		// 그래서 타입이 안 맞는다.
		// 그래서 기본 int로 쓰자고..
		// 자바의 정수 연산의 기본은 int(4byte) 공간에 값을 넣게 계산
		int b3 = b + b2;
		// byte b3 = (byte)b + b2; // 손실(권장X)
		// byte + byte > int + int 결과 -> int
		
		/*
		 * Today Point 
		 * 정수 연산은 int타입으로 변환 후 처리
		 * 	예) byte + short는 컴파일러가 내부적으로 어떻게 바꿔서 계산할까?
		 * 		int + int로 계산
		 * 
		 *  예) char + char는 컴파일러가 int + int로 계산
		 *  
		 *  정수 연산에서 int보다 작은 타입들은 내부적으로 int로 바꾸어 처리함
		 *  정수에서 long은 예외(손실나니까)
		 *  나머지 byte, char, short는 int로 변환
		 *  
		 *  예) char + int는 int
		 *     int + int는 int
		 *     int + long은 long
		 *    
		 * 정수 + 실수는 타입 크기에 상관없이 **실수**
		 * */
		
		long lo = 1000000L;
		float fo = 1.2f;
		//long result3 = lo + fo; // float로 줌(결과를)
		// long result3 = (long)lo + fo; //-> 손실 가능성
		float reulst3 = lo + fo; // 권장하는 방법
		
		//변수, 데이터 타입(값타입, 참조타입), 연산자(산술, 논리, 관계), 제어문(if, for)
		//제어문
		// for(초기값;조건;증가감){}
		int sum = 0;
		for(int j = 0; j <= 100 ;j++) { 
			// j가 0부터 1씩 증가하며 100까지 반복 101되면 종료
			//sum += j; // sum = sum + j;
			if(j % 2 == 0) { //짝수의 합
				sum += j;
			}
		}
		System.out.println(sum); // 5050
		
		//if문
		if(10 == 10.0f) { // == 타입 비교 아님 값비교, 결과 : true
			// == 연산자(값을 비교하는 연산자)
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		
		// != 부정 연산자
		if('A' != 65) {
			// 같지 않으면 실행
			System.out.println("같지 않습니다. : true");
		} else {
			// 같으면 실행
			System.out.println("같습니다. : false");
		}
		
		// Today Point
		// 연산자 중에서 제어문 역할(조건, 반복)
		// 삼항 연산자
		int p = 10;
		int k = -10;
		
		//(조건식) ? true : false 
		int result5 = (p == k) ? p : k;
		System.out.println(result5); // -10
		
		// 삼항 연산안에 삼항 연산 중첩이 가능
		
		// 삼항 연산을 if문으로 바꿔 보기
		int result6 = 0;
		if(p == k) {
			result6 = p;
		} else {
			result6 = k;
		}
		System.out.println(result6); // -10
		
		//-------------------------------------------------------
		
		/*
		 	논리 연산
		 	컴퓨터에서 보통 0이라는 숫자를 false로 본다
		 	1을 true라고 봄
		 	
		 	OR 연산, AND 연산
		 	
		 	DB 쿼리, SQL은 자연어(미국 기준)
		 	select * from emp where job='IT' and sal > 3000; // 둘 다 참이여야 만족
		 	select * from emp where job='IT' or sal > 3000; // 둘 중 하나만 만족하면 True
			
					AND			OR
			0 0      0          0
			0 1      0          1
			1 0		 0			1
			1 1	     1			1
			
			연산자 비트 연산( | or 연산, & and 연산)
			
		 * */
		int x = 3;
		int y = 5;
		
		// 비트연산(십진수를 2진수를 바꿔서 연산함 or 또는 and)
		System.out.println("x | y : OR 연산 " + (x|y)); // 7
		// 2진수로 바꿈
		/*
		 		256		128		64		16		8		4		2		1
		 3(10)									0		0		1		1   
		 5(10)									0		1		0		1
		 |(or연산)								0		1		1		1  
		 --------------------------------------------------------------------
		 or연산 결과를 더함 4+2+1 = 7
		 영상처리(판독) 쪽에서 많이 쓰고 웹개발자는 거의 쓸일 없다
		 
		 		 		256		128		64		16		8		4		2		1
		 3(10)											0		0		1		1   
		 5(10)											0		1		0		1
		 &(and연산)										0		0		0		1  
		 --------------------------------------------------------------------
		 and 연산 결과를 더함 1
		 * */
		System.out.println("x & y : AND 연산 " + (x & y));
		
		//------------------------------------------------------
		
		// Today Point
		// && AND연산
		// || or연산
		
		// if(10 > 0 && -1 > 1 && 100 > 2 && 1 > -1) {A}
		// else {B}
		// 거짓 나오는 순간 뒤는 검사하지 않는다(실행 안함)
		// 1개만 거짓이여도 false
		
		// if(10 > 0 || -1 > 1 || 100 > 2 || 1 > -1) {A}
		// else {B}
		// 참이 나오는 순간 뒤는 검사하지 않음(실행 안함)
		// 1개만 참이여도 true
		
		//------------------------------------------------------
		
		// switch문
		int data = 90;
		switch(data) {
			case 100 : System.out.println("100입니다");
			case 90 : System.out.println("90입니다");
			case 80 : System.out.println("80입니다");
			case 70 : System.out.println("70입니다");
			default : System.out.println("일치하는 data가 없습니다.");
		}
		// break가 없으면 일치하는 값 밑부터 전부 실행됨(default 포함)
		
		switch(data) {
		case 100 : System.out.println("100입니다");
			break;
		case 90 : System.out.println("90입니다");
			break;
		case 80 : System.out.println("80입니다");
			break;
		case 70 : System.out.println("70입니다");
			break;
		default : System.out.println("일치하는 data가 없습니다.");
	}
		// 난수(랜덤값, 임의의 추출값)
		// 공식 API문서(오라클회사에서 배포하고 있음)
		// http://docs.oracle.com/javase/버전/docs/api/
		// https://docs.oracle.com/javase/8/docs/api/index.html // 8버전 공식 문서
		
		/*
		 API 문서는
		 패키지 기준으로 정렬되어있다.(폴더별로 사용하는 것들을 모아두었음)
		 
		 java.lang.Math : 수학적인 작업을 할 수 있는 함수들이 들어있음

		[권장하는 import방식]
		
		import java.lang.*; 권장 X
		import java.lang.Math; 권장함
		그렇지만,
		-> import java.lang은 굳이 import하지 않아도 그냥 쓸 수 있게 만듬(기본값)
		 * */
		
		/* 
		 * java.lang.Math안에 있는
		 * public static double random()
		 * double greater than or equal to 0.0 and less than 1.0.
		 * 0.0 <= random < 1.0
		 * */
		 
		System.out.println("Math.random() : " + Math.random());
		// 0.8665346280198187
		// 같은 값이 계속 나올 수도 있음
		
		//난수 0~9까지
		System.out.println("Math.random() * 10 : " + (Math.random()) * 10);
		System.out.println((int)(Math.random() * 10) + 1); // 1~10까지
		
		//Quiz
		/*
		   int jumsu = ((int)(Math.random()* 10) + 1)*100;
		   금요일 쿼즈	  
		   우리는 백화점 경품 시스템을 만들려고 한다
	 	   경품 시스템은 나오는 점수에 따라 경품을 지급하는 시스템이다
	       경품 추첨시 1000 점수가 나오면
	       경품으로 TV , NoteBook , 냉장고 , 한우세트 , 휴지
	       경품 추첨시 900 점수가 나오면
	       경품으로  NoteBook , 냉장고 , 한우세트 , 휴지
	       경품 추첨시 800 점수가 나오면
	       경품으로  냉장고 , 한우세트 , 휴지
	       경품 추첨시 700 점수가 나오면
	       경품으로  한우세트 , 휴지
	       경품 추첨시 600 점수가 나오면
	       경품으로  휴지
	       그외 점수는 100 ~ 500 까지는 칫솔 
	       경품시스템의 점수 범위는 100 ~ 1000 점까지 한정되어 있다
	       사용자가 경품 시스템을 사용시 랜덤하게 100 ~ 1000까지의 값이 나오게 되어 있습니다.
	       
	       프로그램을 한번 실행하면 그 때 랜덤값이 나오고 그 랜덤값에 의해서 경품을 출력하면 되요
	       */
		int jumsu = ((int)(Math.random()* 10) + 1)*100;
		System.out.println("\n\n당첨 점수 : " + jumsu);
		//String product;
		System.out.println("당신의 경품은 ...??? ");
		System.out.println("------------------------");
		switch(jumsu) {
			case 1000 : System.out.printf("TV, "); 
			case 900 : 	System.out.printf("NoteBook, ");
			case 800 :  System.out.printf("냉장고, ");
			case 700 :  System.out.printf("한우세트, ");
			case 600 :  System.out.println("휴지입니다!!!");
				break;
			default : System.out.println("칫솔입니다!!");
		}
		System.out.println("축하합니다 ^__^");
		
		int jumsu2 = ((int)(Math.random()* 10) + 1)*100;
		System.out.println("\n\n당첨 점수 : " + jumsu2);
		String product = ""; // 지역변수는 초기화 시켜주지 않음 에러 
		System.out.println("당신의 경품은 ...??? ");
		System.out.println("------------------------");
		switch(jumsu2) {
			case 1000 : product += "TV, "; 
			case 900 : 	product += "NoteBook, ";
			case 800 :  product += "냉장고, ";
			case 700 :  product += "한우세트, ";
			case 600 :  product += "휴지입니다.";
				break;
			default : System.out.println("칫솔입니다.");
		}
		System.out.println("축하합니다 ^__^");
		
		
		
	}// main() 끝
	
}// 클래스 끝
