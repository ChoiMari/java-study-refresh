package ko.or.kosa;
/*
클래스를 설계하시는데
성적 데이터 입력 기능
성적 데이터 삭제 기능
성적 데이터 정렬 기능을 가지는 함수를 만드시고요 (함수 이름만 정의하고 구현하지 마세요)

		System.out.println("************");
		System.out.println("***성적관리***");
		System.out.println("1.학생성적 입력");
		System.out.println();
		System.out.println("2.학생성적 삭제");
		System.out.println();
		System.out.println("3.학생성적 이름순 정렬");
		System.out.println();
		System.out.println("4.프로그램 종료");
		System.out.println();
위 내용을 가지는 함수를 구현하시고 함수의 리턴은 메뉴 번호로 하시고
위 번호 1 , 2 , 3 , 4 가 입력되면 선택된 값을 리턴하게 하고
그렇지 않으면 계속적으로 값을 입력받게 하는 함수는 구성하세요

구현된 DoWhileMenu 클래스를 다른 
Ex16_DoWhileMenu의 main 함수에서 실행하면
    DoWhileMenu Menu = new DoWhileMenu();
	while(true) {
			switch (Menu.displayMenu()) {
			case 1: Menu.inputRecord();
				break;
			case 2: Menu.deleteRecord();
				breakMenu
			case 3: ex17.sortRecord();	
			    break;
			case 4: System.out.println("프로그램 종료");
			    //return;  >> main 함수 종료
			    System.exit(0); //프로그램 종료(kill)
			}
		}
결과를 얻을 수 있습니다

do{

} while(true)

public int display(){

		System.out.println("************");
		System.out.println("***성적관리***");
		System.out.println("1.학생성적 입력");
		System.out.println();
		System.out.println("2.학생성적 삭제");
		System.out.println();
		System.out.println("3.학생성적 이름순 정렬");
		System.out.println();
		System.out.println("4.프로그램 종료");
		System.out.println();
		int menu = 0
		
		//입력을 받음
		do{
			//입력값 범위  : 1보다 작고, 4보다 큰 값이 나오면 -> 예외라고 봄
			// 실제는 예외는 아니지만 예외를 던져라.
			
		} while(true);
		
	return menu;
}
*/

import java.util.Scanner;

public class DoWhileMenu {
	
	Scanner sc = new Scanner(System.in); 
	
	// 기능 정의
	// 입력 메서드
	public void inputRecord() {
		System.out.println("성적 데이터 입력");
	}
	
	// 삭제 메서드
	public void deleteRecord() {
		System.out.println("성적 데이터 삭제");
	}
	// 정렬 메서드
	public void sortRecord() {
		System.out.println("성적 데이터 정렬");
	}
	// 화면 메뉴 메서드
	public int display() {
		System.out.println("************");
		System.out.println("***성적관리***");
		System.out.println("1.학생성적 입력");
		System.out.println();
		System.out.println("2.학생성적 삭제");
		System.out.println();
		System.out.println("3.학생성적 이름순 정렬");
		System.out.println();
		System.out.println("4.프로그램 종료");
		System.out.println();
		
		int menu = 0;
		do {
			try {
				menu = Integer.parseInt(sc.nextLine());
				if(menu >= 1 && menu <= 4) {
					break;
				}else {
					throw new Exception("[예외] 입력 오류 : 메뉴 번호가 잘못 되었습니다.");
				}
			} catch(Exception e){
				System.out.println("원인 파일 : " + e.getMessage());
				System.out.println("메뉴 선택 문제 발생");
				System.out.println("입력 번호는 1~4까지의 정수만 가능합니다.");
			}
			
		} while(true);
		return menu;
	}
	
}
