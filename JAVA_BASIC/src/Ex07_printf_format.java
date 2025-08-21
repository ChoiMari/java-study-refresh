import java.util.Scanner;

public class Ex07_printf_format {

	public static void main(String[] args) {
		//C#에서는 Console.WriteLine();
		System.out.println("A"); // 출력하고 줄바꿈
		System.out.println();
		System.out.println("B");
		
		int num = 1000;
		System.out.println(num);
		System.out.println("num 값은 " + num + "입니다.");
		
		//형식(format) - 내부적으로 개행은 하지 않는다
		System.out.printf("num 값은 %d입니다.\n", num);
		
		System.out.printf("num 값은 [%d]입니다 또 [%d]도 있어요.\n", num, 1);
		
		/*
		 %d 10진수 형식의 정수
		 %f 실수 
		 %s 문자열
		 %c 문자
		 
		  \t
		  \n
		  등.. 조합해서 format 생성
		 */
		float f = 3.14f;
		System.out.println(f);
		System.out.printf("f 변수값은 %f입니다.\n", f);
		
		//cmd 모드 입력값 받기
		Scanner sc = new Scanner(System.in); // 입력값 받는 클래스
		//String value = sc.nextLine(); //nextLine() : 사용자 입력까지 대기중
		// 무언가 입력하고 엔터 할 때까지 대기, 리턴타입 String
		//System.out.println("value : " + value); // 콘솔의 입력값 출력
		
		// 형변환
		//float value = sc.nextFloat(); // float 타입으로 리턴
		// 문자열 입력 시 예외발생
		// Exception in thread "main" java.util.InputMismatchException
		//System.out.println("value : " + value);
		
		//Tip
		//권장 : nextInt, nextFloat 보다는 모든 데이터를 문자열로 nextLine()
		//필요하면 타입 변환
		// Today Point
		// 문자열을 숫자로 변환 가능
		//int number = Integer.parseInt(value);
		/*
		 String data = sc.nextLine();
		 int age = Integer.parseInt(data); // 아규먼트로 넣은 문자열 -> 정수(int)로 변환
		 Integer.parseInt("1000"); -> 1000
		 Integer.parseFloat("2.14") -> 2.14 // 문자열을 float타입으로
		 * */
		System.out.print("숫자를 입력하세요 : ");
		int number2 = Integer.parseInt(sc.nextLine());
		System.out.printf("입력한 숫자는 : %d" , number2);
	}

}
