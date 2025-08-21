import java.util.Scanner;

public class Ex10_Statement {
	public static void main(String[] args) {
		//while문, do - while문
		int i = 10;
//		while(i >= 10) { // 무한루프
//			System.out.println(i);
//		}
		while(i >= 10) { // 무한루프
			// 반드시, 증가감을 명시해야한다
			// 고민
			//--i; 
			System.out.println(i);
			--i; 
		}
		
		//while 1~100까지의 합
		int sum = 0;
		int j = 1;
		while(j <= 100) {
			sum +=j;
			j++;
//			if(j == 100) {
//				break;
//			}
		}
		System.out.println("sum : " + sum);
		
		//while(true){} 무한루프 코드도 일부러 쓰기도 함
		
		int k = 2;
		int p = 1;
		while(k <= 9) {
			p = 1; //초기화해야 다음 단도 출력됨
			while(p <= 9) {
				System.out.printf("%d * %d = %d\t", k, p, k*p);
				p++;
			}
			System.out.println();
			k++;
		}
		
		// 무한루프
		// while(true){}
		// for(;;){}
		// do-while() 일단 한 번 무조건 실행되고 2번째부터 조건보고 판단
		/*
		 메뉴 구성 - 점심 메뉴를 선택하세요
		 * */
		Scanner sc = new Scanner(System.in);
		int inputData = 0;
		do {
			System.out.print("숫자 입력(0~9) : ");
			inputData = Integer.parseInt(sc.nextLine());
		} while(inputData >= 10);
			// 조건식이 true이면 do문을 계속 실행함
			// 조건식이 false do문을 탈출
		
		System.out.println("당신이 입력한 숫자는 : " + inputData);
		
	} //메인 끝
}
