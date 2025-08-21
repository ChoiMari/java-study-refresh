import java.util.Scanner;

public class Ex08_Operation_Quiz {

	public static void main(String[] args) {
		/*
		간단한 사칙 연산기 (+ , - , * , /)
		입력값 3개 (입력값은 nextLine() 받아서 필요하다면 숫자 변환)
		목적 : Integer.parseInt() ,  ** 구글 java equals() 활용  문자열의 비교** 

		//입력을 3개 받음
		화면
		>입력값:숫자
		>입력값(기호): +
		>입력값:숫자 
		>연산결과 :200
		-------------
		>입력값:100
		>입력값(기호): -
		>입력값:100
		>연산결과 :0 
		
		hint) 
		if문 조건 boolean
		switch문은 정수형(byte, short, int)와 문자(char), 문자열(String) 조건식 사용
		Scanner 객체를 하나 만듬
		String ch = sc.nextLint();
		 */
		Scanner sc = new Scanner(System.in);
		
		System.out.print("number1 : ");
		//int number1 = Integer.parseInt(sc.nextLine());
		
		System.out.print("연산자 : ");
		//String operator = sc.nextLine();
		
		System.out.print("number2 : ");
		//int number2 = Integer.parseInt(sc.nextLine());	
		
//		int result = 0; // 지역변수 초기화
//		
//		switch(operator) {
//			case "+" : result = number1 + number2;
//				break;
//			case "-" : result = number1 - number2;
//				break;
//			case "*" : result = number1 * number2;
//				break;
//			case "/" : if(number2 == 0) {
//				System.out.println("0으로는 나눌 수 없습니다.");
//			} 
//			else {result = number1 / number2;}
//				break;
//			default : System.out.println("잘못된 입력입니다.");
//		}
		sc.close(); // Scanner 닫음
//		System.out.printf("연산 결과 : %d\n", result);
		
		// equals 알아보기
		/*
		 *  == 값 비교 연산자
		 * */
		String str1 = "AAA"; // str1은 스택에 주소값이 저장됨
		String str2 = "AAA"; // 새로 메모리 만들지 않음. 값이 같아서
		// 같은 메모리를 참조하고 있음(메모리 주소 동일)
		System.out.printf("str1 == str2 : %b\n" , str1 == str2); // true
		
		String str3 = new String("BBB");
		String str4 = new String("BBB");
		System.out.printf("str3 == str4 : %b\n" , str3 == str4); // false
		// 저장된 메모리의 주소가 다름
		// 문자열 비교가 아니라 객체의 메모리 주소 비교 
		
		// 원하는건 문자열 비교를 원함
		// -> equals() 함수를 만듬
		// 문자열 비교는 equals()를 사용함
		// 주소값 비교 말고 그 안에 값을 비교
		System.out.println("str3 == str4 : " + str3.equals(str4)); // true
		
	}// main()끝
}
