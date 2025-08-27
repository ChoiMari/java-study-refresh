import java.util.Random;
import java.util.Scanner;

import kr.or.kosa.Cinama;

public class Ex10_CinemaProgram {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // 입력 객체 생성
		
		String[][] seat = new String[3][5]; // 영화관 좌석 수 설정
		String[][] ranInfo = new String[3][5]; // 예매 정보 저장
		Cinama ci = new Cinama(seat,ranInfo); // 영화관 객체 생성
		
		boolean isOpen = true; // 반복문 제어 
		
		// 예매하기, 예매조회, 좌석조회, 예매취소, 시스템종료
		System.out.println("영화관에 오신 것을 환영합니다.");
		while(isOpen) {
			System.out.println("*****************************");
			System.out.println("☆☆☆☆영화 예매 시스템☆☆☆☆");
			System.out.println("*****************************");
			System.out.print("[1]예매하기, [2]예매조회, [3]좌석 현황 [4]예매 취소 [5]프로그램 종료\n");
			System.out.print("입력 : ");
			
			int input = Integer.parseInt(sc.nextLine()); // 사용자 입력값 저장
			//TODO 예외 처리하기
			
			switch(input) {
				case 1 : 
					ci.checkCinamaSeat(); // 좌석 현황 보여줌
					System.out.println("좌석을 선택해주세요. 예) 1-1");
					System.out.println("이미 예매된 좌석은 [ X ]로 표시 됩니다.");
					System.out.print("입력 : ");
					String[] sreatArr = sc.nextLine().split("-"); // TODO : 예외처리
					// 예매 가능한 좌석인지 확인함
					int row = Integer.parseInt(sreatArr[0]);
					int col = Integer.parseInt(sreatArr[1]);
					boolean isOk = ci.checkSeatNumber(row,col);
					if(isOk) {
						System.out.println("예매 가능합니다. 예매하시겠습니까?");
						System.out.println("[1]네 [2]아니오(초기화면으로 이동)");
						switch(sc.nextLine()) {
							case "1" : ci.ticketBuy(row, col);// 예매 메서드 호출 
								break;
							case "2" : // 초기화면으로 이동
								break;
							default : System.out.println("[입력 오류] 다시 입력해주세요.\n");
						}
					}else {
						System.out.println("예매가 불가능 합니다. 다른 좌석을 선택해 주세요.\n");
					}
					
					break;
				case 2 : 
					System.out.print("예매 번호 입력 : ");
					ci.ranBySeat(sc.nextLine());//예매 조회 메서드 호출(TODO : 예외처리)
					break;
				case 3 : ci.checkCinamaSeat(); //좌석 현황 메서드 호출
					break;
				case 4 : 
					System.out.print("[취소] 예매번호 입력 : ");
					ci.cancleTicket(sc.nextLine());//예매 취소 메서드 호출
					break;
				case 5 : 
					sc.close(); // 리소스 정리(try()로 처리해도 됨)
					isOpen = ci.closeCinama(); // 프로그램 종료
					break;
				default : System.out.println("[입력값 오류] 잘못된 입력입니다.");
			}
		}
		
	}
}
