/*
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
 */

import ko.or.kosa.DoWhileMenu;

public class Ex16_DoWhileMenu {

	public static void main(String[] args) {
	    DoWhileMenu Menu = new DoWhileMenu();
		while(true) {
				switch (Menu.display()) {
				case 1: Menu.inputRecord();
					break;
				case 2: Menu.deleteRecord();
					break;
				case 3: Menu.sortRecord();	
				    break;
				case 4: System.out.println("프로그램 종료");
				    //return;  >> main 함수 종료
				    System.exit(0); //프로그램 종료(kill)
				}
			}
	}

}
