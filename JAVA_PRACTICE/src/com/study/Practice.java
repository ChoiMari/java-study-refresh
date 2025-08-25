package com.study;
// 컴퓨터가 1~100사이의 랜덤 숫자를 생성하고, 
// 사용자가 맞출때까지 힌트를 제공하는 게임을 만들어 보세요.

import java.util.Random;
import java.util.Scanner;

public class Practice {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // 입력 객체 생성
		Random rand = new Random(); // 난수 객체 생성
		int num = rand.nextInt(99) + 1; // 1 ~ 100까지의 난수 생성
		int count = 0; // 지역변수는 초기화해서 사용해야함
		System.out.println("1~100 사이의 숫자를 맞춰보세요!");
		while(true) {
			count++; // 반복횟수
			System.out.print("숫자 입력 : ");
			int input = Integer.parseInt(sc.nextLine()); // 입력 받음
			if(input < num) { // 입력값이 작은 경우
				System.out.println("더 큰 수 입니다.");
			} else if(input == num){
				System.out.println("정답입니다! " + count + "번 만에 맞추셨네요!");
				System.out.println("-----[프로그램 종료]-----");
				sc.close(); // 리소스 정리
				return;
			} else {
				System.out.println("더 작은 수 입니다.");
			}		
		}

		
	}	
}
