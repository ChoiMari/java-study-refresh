package com.study;

import java.util.Scanner;

/* do-while문 : 무조건 1번은 실행됨
구문
do{
	실행문;
}while(조건식); 
 * */
public class DoWhileEx {
	public static void main(String[] args) {
		System.out.println("메시지를 입력하세요.");
		System.out.println("프로그램을 종료하려면 \"exit\" 을 입력하세요.");
		String exitCmd = "exit";
		Scanner sc = new Scanner(System.in); // 입력 객체 생성
		String str; //do-while문은 무조건 한 번 실행되는 구조라서 지역변수 초기화 하지 않고 써도 사용 전에 초기화 되지 않았다는 경고 없음 
		do {
			System.out.print("입력 : ");
			str = sc.nextLine();
			System.out.println(str);
		} while(!str.toLowerCase().equals("exit")); // 반복 실행 조건
		sc.close(); // 리소스 정리
		System.out.println("------------------");
		System.out.println("프로그램이 종료되었습니다.");
	} 
}
