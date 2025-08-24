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
		풀이 방법 : 내부 반복문은 돌때마다 i번 실행하고 끝남
	 */
	public void rightTriangle(int n) {
		for(int i = 1;i <= n;i++) { // i가 1부터 n이하까지 1씩 증가하며 총 n번 실행됨
			for(int j = 1; j <= i ;j++) { // j가 1부터 i이하까지 1씩 증가하며 총 i번 실행됨 
				System.out.print("*"); // -> 즉, i가 1일때 1번 출력, i가 2일때 2번 출력됨, ...
			}
			System.out.println(); // 내부 반복문 종료 때 마다 줄바꿈
		}
	}
	
	/*
	  입력 n을 받아 아래처럼 별을 찍어라.
		예: n = 5
		*****
		****
		***
		**
		*
		풀이 방법 : 내부 반복문 실행 횟수 n, n-1, n-2, ..., 1
	*/
	public void invertedRightTriangle(int n) {
		for(int i =1;i <= n ;i++) {  // 외부 반복문: 총 n번 반복
			for(int j = n;j >= i;j--) { // 내부 반복문: n부터 i까지 감소(i값 되면 종료)
				System.out.print("*");  // 별 출력
			}
			System.out.println();
		}
	}
	
	/*
	 문제: 피라미드 별 찍기
		입력 n을 받아 중앙 정렬된 피라미드 형태로 별을 찍어라.
		예: n = 5
		     *
		    ***
		   *****
		  *******
		 *********
	풀이 방법 : 별 홀수 개로 증가 2*i-1
	 */
	public void pyramid(int n) {
		for(int i = 1;i <= n;i++) { // 총 n번 실행
			for(int j = n;j > i;j--) { //왼쪽 공백(n-i)번 실행
				System.out.print(" ");
			}
			for(int k = 1;k <= i;k++) { // i번 실행
				System.out.print("*");
			}
			for(int l = 1;l < i;l++) { // i-1번 실행
				System.out.print("*");
			}
			System.out.println(); 
		}
	} //-> 더 단순하게 별부분만 출력할 수도 있음.
	// 별 증가식 2*i - 1,  k <= (2*i - 1) 
	 

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
			System.out.println("-----------------");
			star.invertedRightTriangle(n);
			System.out.println("-----------------");
			star.pyramid(n);
		}catch(NumberFormatException ex){ // 문자열, 실수입력 시 방어가 된다.(Integer.parseInt(sc.nextLine()); 예외처리)
			//(NumberFormatException : 문자열을 정수로 변환할 때 변환할 수 없는 값이 들어오면 발생되는 런타임 예외클래스)
			System.out.println("정수만 입력해주세요.");
		}finally {
			sc.close();
		}
		
	}

}
