package com.study;

import java.util.Scanner;

public class HomeWork {
	public static void main(String[] args) {
		int unit = 10000; // 화폐단위
		int num = 0; // 화폐매수
		int sw = 0; // 스위칭 변수(화폐의 다음 단위를 위해_
		
		Scanner sc = new Scanner(System.in); // 입력 객체 생성
		System.out.print("금액 입력 : ");
		int money = Integer.parseInt(sc.nextLine()); 
		// 입력 받는 금액
		
		while(true) {
			num = (int)(money / unit);
			System.out.printf("%d %d개\n", unit, num);
			if(unit > 1) {
				money -= unit * num;
				if(sw == 0) {
					unit /= 2;
					sw = 1;
				}else {
					unit /= 5;
					sw = 0;
				}
			} else {
				System.out.println("---------[프로그램 종료]---------");
				sc.close(); // 리소스 정리
				return;
			}
		}
	}
}
