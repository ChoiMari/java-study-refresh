package com.study;

import java.util.Scanner;

public class Star {
	
	/*
	 * 문제 : 입력 n을 받아 아래처럼 별을 찍어라.
	 	예: n = 5
	 	*
	 	**
	 	***
	 	****
	 	*****
	 */
	public void rightTriangle(int n) {
		for(int i = 1;i <= n;i++) { // i가 1부터 n이하까지 1씩 증가하며 총 n번 실행됨
			for(int j = 1; j <= i ;j++) { // j가 1부터 i이하까지 1씩 증가하며 총 i번 실행됨 
				System.out.print("*"); // -> 즉, i가 1일때 1번 출력, i가 2일때 2번 출력됨, ...
			}
			System.out.println(); // 내부 반복문 종료 때 마다 줄바꿈
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // 입력 객체 생성
		Star star = new Star();
		try {
			System.out.print("양의 정수 입력 : ");
			int n = Integer.parseInt(sc.nextLine());  // 입력값 문자열 -> int타입 변환
			
			if(n <= 0) { // 0이하 입력 시 실행됨 -> 0과 음수 입력 방어
				System.out.println("1이상의 정수만 입력해주세요");
				return; //-> main 함수 종료
			}
			star.rightTriangle(n);
		}catch(NumberFormatException ex){ // 문자열, 실수입력 시 방어가 된다.(Integer.parseInt(sc.nextLine()); 예외처리)
			//(NumberFormatException : 문자열을 정수로 변환할 때 변환할 수 없는 값이 들어오면 발생되는 런타임 예외클래스)
			System.out.println("정수만 입력해주세요.");
		}finally {
			sc.close();
		}
		
	}

}
