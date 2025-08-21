
import java.util.Random;
import java.util.Scanner;

public class Ex_Rock_Paper_Scissors {

	public static void main(String[] args) {
		//난수 객체 생성
		Scanner sc = new Scanner(System.in);
//		int randomValue = (int)(Math.random() * 3) + 1; 
		//TODO :  1 ~ 3만 나오게 제어해야함
		
		Random random = new Random();
//		int randomValue = random.nextInt(3) + 1; 
//		System.out.println(randomValue);

		int player = 0;
		int computer = 0;
		boolean control = true;
		System.out.println("--------[가위바위보 게임 START]---------");
		while(control) {
			System.out.println("[1]가위, [2]바위, [3]보, [999] 종료");
			System.out.print("입력 : ");
			player = Integer.parseInt(sc.nextLine());
			if(player == 999) {
				System.out.println("[프로그램 종료] 다음에 또 만나요.");
				break;
			}
			
			//computer = (int)(Math.random() * 3) + 1; 
			computer = random.nextInt(3) + 1;  
			// random.nextInt(3) : 0 ~ 2난수 출력
			
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
						sc.close();
						control = false;
					}
					break;
				case 2:
					if(computer == 1) {
						System.out.println("[Player] 바위, [Computer]  가위");
						System.out.println("결과 : 당신은 이겼습니다!!");
						sc.close();
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
						sc.close();
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
		
	} //메인끝

}
