
public class Ex09_Statement {

	public static void main(String[] args) {
		/*
		 제어문
		 조건문 : if(3가지), switch(조건)
		 반복문 : for(반복횟수 명확),  while(진위), do{}-while(){}
		 분기문 : break(블록 탈출), continue(아래 구문 skip)
		*/
		
		int count = 0;
		if(count < 1) System.out.println("true"); // 1줄이면 {} 필요 없음
		
		if(count < 1) {
			System.out.println("true");
		}
		
		char data = 'A';
		switch(data) {
			case 'A': System.out.println("문자 비교 같아요");
				break;
			case 'B': System.out.println("....");
				break;
			default: System.out.println("나머지 처리");		
		}
		
		// for문(1~100까지의 합)
		int sum = 0;
		for(int i = 1;i<=100;i++) {
			sum += i;
		}
		System.out.printf("1~100까지의 누적 합 : %d\n" , sum);
		
		// 1~n까지의 합
		// for문과 while 사용 하지 말고 구하기(힌트 : 수학적으로)
		// n * (n+1)/2
		sum = 5 * (1 + 5) / 2; //-> 이런거 안할려고 제어문 하는거라고..
		System.out.println(sum); // 이런거는 회사에서 안좋아한다.. 재미삼아 보셨다고..
		
		// 알고리즘 시험에는 재귀함수 사용함
		
		// 1 ~ 10까지의 홀수의 합을 구하시오
		// 단, for문만 사용하시오(if문 금지)
		int sum2 = 0;
		for(int i = 1; i <= 10; i+=2) {
			sum2 += i;
		}
		System.out.println("1~10까지의 홀수의 합 : " + sum2);
		
		// for문 if문을 사용 1~1000까지 짝수의 합을 구하시오
		int sum3 = 0;
		for(int i = 1 ;i <= 1000;i++) {
			if(i % 2 == 0) {
				sum3 += i;
			}
		}
		System.out.printf("1~1000까지의 짝수의 합 : %d", sum3);
		
		//for분기문(continue, break) - 별찍기
		for(int i =2;i <= 9;i++) {
			for(int j = 1;j <= 9;j++) {
				if(i == j) {
					break;
				}
				System.out.printf("%s", "*");
			}
			System.out.println();
		}
		
		// 정렬 알고리즘(버블) 
		for(int i =2;i <= 9;i++) {
			for(int j = 1;j <= i;j++) {
				System.out.printf("%s", "*");
			}
			System.out.println();
		}
		
		// 100부터 0까지의 값을 출력하시오(시작값 100)
		for(int i = 100;i >= 0;i--) {
			if(i % 10 == 0) {
				System.out.println();
			}
			System.out.printf("%d\t", i);
		}
		
		// 피보나치 수열
		int a = 0, b = 1, c = 0;
		for(int i = 0;i < 10;i++) {
			a = b;
			b = c;
			c = a + b;
			System.out.printf("[%d] * [%d] = [%d]", a, b, c);
			System.out.println(" " + c);
			
		}
		
	}//main끝
	

	

}
