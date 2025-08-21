
import java.util.Random;
import java.util.Scanner;

public class Ex_Rock_Paper_Scissors {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		//난수 객체 생성 방법
		// 1. Random 객체 사용
		Random rand = new Random();
		// 2. Math.random() static 메서드 사용

		// 지역변수는 초기화하지 않으면 에러
		int player = 0; // 플레이어 값 초기화
		int computer = 0; // 컴퓨터 값 초기화
		boolean control = true; //무한루프 제어
		
		// 실행 시 한 번만 출력할 안내문
		System.out.println("--------[가위바위보 게임 START]---------");
		while(control) {
			// 반복 출력할 안내문
			System.out.println("[1]가위, [2]바위, [3]보, [999] 종료");
			System.out.print("입력 : ");
			
			// 사용자에게 입력값 받음
			player = Integer.parseInt(sc.nextLine());
			if(player == 999) { // 프로그램 종료 조건
				System.out.println("[프로그램 종료] 다음에 또 만나요.");
				break;
			}
						
			// 반복 실행 할 때마다 난수 다르게 
			computer = rand.nextInt(3) + 1; // 0,1,2 + 1 -> 1 ~ 3
			//computer = ((int)Math.random() * 3) + 1; // 0,1,2 + 1 -> 1 ~ 3
			
			// 비기는 경우,이기는 경우, 지는 경우로 나누면 더 짧게도 가능하지만
			// 뭘 냈는지 출력을 나눠서 하려면 어차피 길어질 수 밖에 없음
			switch(player) {
			case 1:
				if(computer == 1) {
					System.out.println("[Player] 가위, [Computer] 가위");
					System.out.println("결과 : 비겼습니다.");
				} else if(computer == 2) {
					System.out.println("[Player] 가위, [Computer] 바위");
					System.out.println("결과 : 당신은 졌습니다.");
				} else {
					System.out.println("[Player] 가위, [Computer]  보");
					System.out.println("결과 : 당신은 이겼습니다!!");
					control = false;
				}
				break;
			case 2:
				if(computer == 1) {
					System.out.println("[Player] 바위, [Computer]  가위");
					System.out.println("결과 : 당신은 이겼습니다!!");
					control = false;
				} else if(computer == 2) {
					System.out.println("[Player] 바위, [Computer]  바위");
					System.out.println("결과 : 비겼습니다.");
				} else {
					System.out.println("[Player] 바위, [Computer]  보");
					System.out.println("결과 : 당신은 졌습니다.");
				}
				break;
			case 3:
				if(computer == 1) {
					System.out.println("[Player] 보, [Computer]  가위");
					System.out.println("결과 : 당신은 졌습니다.");
				} else if(computer == 2) {
					System.out.println("[Player] 보, [Computer]  바위");
					System.out.println("결과 : 당신은 이겼습니다!!");
					control = false;
				} else {
					System.out.println("[Player] 보, [Computer]  보");
					System.out.println("결과 : 비겼습니다.");
				}
				break;
			default:
				System.out.println("[입력값 오류] : 다시 입력해주세요");
		}
			System.out.println("--------------------------------\n");
		}
		
		sc.close();
		
	} //메인끝

}
