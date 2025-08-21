import java.util.Scanner;

public class Ex11_1_Statement_Quiz {
	public static void main(String[] args) {
		//메뉴를 보여주고 사용자에 선택 ....
		//원하시는 메뉴를 선택하지 않으면 강제로 다시 메뉴를 보여 주세요
				
		//1.예금
		//2.출금
		//3.잔고
		//4.종료  조건 판단 while 탈출 (어떤 조건이 일치하면 강제 break)
				
				
		//잔액 변수를 생성 (balance)
		//예금 처리  + 누적
		//출금 처리  - 누적
		//잔고      balance  출력
		//종료      프로그램 끝 (함수의 종료  , 프로그램의 강제 종료) : 
		//논리적 종료 ( return (x) , exit(x) 안되요)
		Scanner sc = new Scanner(System.in); 
		int balance = 0; // 잔고
		int num = 0; 
		int input = 0;
		
		while(true) {
			System.out.println("[1] 예금, [2]출금, [3]잔고, [999] 종료");
			System.out.print("입력 : ");
			num = Integer.parseInt(sc.nextLine());
			if(num == 999) {
				System.out.println("[프로그램 종료] 다음에 또 이용해주세요.");
				break;
			}
			switch(num) {
				case 1: 
					System.out.print("입급액 입력 : ");
					input = Integer.parseInt(sc.nextLine());
					balance += input; 
					break;
				case 2: 
					System.out.print("출금액 입력 : ");
					input = Integer.parseInt(sc.nextLine());
					if(balance < input) {
						System.out.println("현재 잔액이 부족하여 출금이 불가능 합니다.");
					} else {
						balance -= input; 
					}
					break;
				case 3:
					System.out.printf("현재 잔고는 %d원입니다.\n", balance);
					break;
				default :
					System.out.println("[입력값 오류] 다시 입력해주십시오.");
			}
			System.out.println("-----------------------------------------\n");
	
		}
	}
}
