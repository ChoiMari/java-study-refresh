package com.study;

import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class Lotto {
	private int[] nums;
	private Scanner sc;
	private Random r;
	
	public Lotto() {
		//기본값 설정
		nums = new int[6];
		sc = new Scanner(System.in);
		r = new Random();
	}
	
	// 번호 추출 기능(자동)
	private int[] random() {
		for(int i = 0;i < nums.length;i++) {
			nums[i] = r.nextInt(45) + 1;
		}		
		return nums;
	}
	
	// 반자동 추출 기능 - 오버로딩
	private int[] random(int[] userNums) {		
		for(int i = 0;i < userNums.length;i++) { // 사용자 입력 개수만큼 실행
			nums[i] = userNums[i]; // 사용자 값으로 채우기
		}
		
		for(int i = userNums.length;i < nums.length;i++) { 
			// 사용자 입력 개수부터 끝까지
			nums[i] = r.nextInt(45) +1; // 난수로 채움
		}	
		return nums; 
	}
	
	// 중복 제거 기능(자동)
	private int[] unique() {
		int[] autoNums = random(); // (자동)난수 뽑아서 저장
		for(int i = 0 ;i < autoNums.length;i++) {
			for(int j = 0;j < i;j++) { //j < i 불필요검사 제거 조건(i=j는 절대 실행 되면 안됨)
				if(autoNums[i] == autoNums[j]) { // 중복이면
					autoNums[j] = r.nextInt(45) + 1;
					//뒤의 중복값을 새로운 난수값으로 변경
				    i--; // 재검사(새로 넣은 난수가 또 중복일수 있으므로)
				    break;
				}
			}
		}		
		return autoNums;
	}
	
	// 중복 제거 기능(반자동) - 오버로딩 
	private int[] unique(int[] userNums) {
		int[] semiAutoNums = random(userNums);
		for(int i = 0;i < semiAutoNums.length;i++) {
			for(int j = 0;j < i;j++) {
				if(semiAutoNums[i] == semiAutoNums[j]) { // 중복있으면
					semiAutoNums[j] = r.nextInt(45) + 1; //뒤의 중복값을 새로운 난수로 바꿈
					i--; //재검사
					break; 
				}
			}
		}
		return semiAutoNums;
	}
	
	// 정렬 기능(자동) - 버블정렬
	private int[] bubbleSort() {
		int temp;
		int[] sortAutoNums = unique();
		// [1회전]01,12,23,34,45 [2회전]01,12,23,34 [3회전] 01,12,23 [4회전] 01,12 [5회전] 01
		for(int i = 0;i < sortAutoNums.length;i++) {
			for(int j = 0;j < (sortAutoNums.length -1) - i;j++) {
				if(sortAutoNums[j] > sortAutoNums[j+1]) { // 앞의 인덱스가 더 크면
					temp = sortAutoNums[j];
					//위치를 바꿈
					sortAutoNums[j] = sortAutoNums[j+1];  
					sortAutoNums[j+1] = temp;
				}
			}
		}
		return sortAutoNums;
	}
	
	// 정렬 기능(반자동) - 버블정렬
	private int[] bubbleSort(int[] userNums) {
		int temp;
		int[] sortSemiNums = unique(userNums);
		// [1회전]01,12,23,34,45 [2회전]01,12,23,34 [3회전] 01,12,23 [4회전] 01,12 [5회전] 01
		for(int i = 0;i < sortSemiNums.length;i++) {
			for(int j = 0;j < (sortSemiNums.length -1) - i;j++) {
				if(sortSemiNums[j] > sortSemiNums[j+1]) { // 앞의 인덱스가 더 크면
					temp = sortSemiNums[j];
					//위치를 바꿈
					sortSemiNums[j] = sortSemiNums[j+1];  
					sortSemiNums[j+1] = temp;
				}
			}
		}
		return sortSemiNums;
	}
	
	// 출력 기능(자동)
	public void print() {
		int[] autoLottoArr = bubbleSort();
		System.out.println("----------------------------------");
		System.out.print("☆ 당첨 예상 번호 : ");
		for(int num :autoLottoArr) {
			System.out.printf("%d ", num);
		}
	}
	
	// 출력 기능(반자동) - 오버로딩
	public void print(int[] userNums) {
		int[] semiLottoArr = bubbleSort(userNums);
		System.out.println("----------------------------------");
		System.out.print("☆ 당첨 예상 번호 : ");
		for(int num :semiLottoArr) {
			System.out.printf("%d ", num);
		}
	}

	//실행 - 결과 출력
	public static void main(String[] args) {
		Lotto lotto = new Lotto();
		boolean isOpen = true; // 반복문 제어에 사용
		
		System.out.println("**********************************************");
		System.out.println("로또 예상 번호를 추출해주는 프로그램 입니다.");
		System.out.println("**********************************************");
		
		try(lotto.sc){  // 자동 닫아줌
			do {
				System.out.println("[1] 자동 추출 [2] 반자동 추출(수동 가능) [777] 프로그램 종료");
				System.out.print("입력 : ");
				switch(lotto.sc.nextLine()) {
					case "1" : lotto.print(); // 자동 로또 추출 출력
						break; //반복제어 X, switch 제어용
					case "2" : 
						// 반자동 입력 받기
						System.out.println("----------------------------------------------------");
						System.out.println("원하는 숫자를 입력하시면 나머지 숫자는 자동으로 추출됩니다.");
						System.out.println("','로 구분해서 숫자를 입력해주세요 (예) 1,11,13");
						System.out.print("입력 : ");
						String[] sarr = lotto.sc.nextLine().replace(" ", "").split(",");
						if(sarr.length > 6) {
							System.out.println("[입력초과] 최대 6개의 숫자만 입력 가능합니다.");
							System.out.println("----------------------------------------");
							break;
						}
						int[] userNums = new int[sarr.length];
						for(int i = 0;i < sarr.length;i++) {
							userNums[i] = Integer.parseInt(sarr[i]);
							if(userNums[i] <= 0 || userNums[i] > 45) {
								throw new Exception("[입력오류] 숫자는 1 ~ 45까지의 정수만 가능합니다.");
							} 
						}
						lotto.print(userNums);
						break;
					case "777" : 
						System.out.println("----------------------------------------");
						System.out.println("[프로그램 종료] 다음에 또 이용해주세요.");
						isOpen = false;
						break;
					default :
						System.out.println("해당하는 메뉴번호가 없습니다.");
				}
				System.out.println("\n");
			} while(isOpen);
		} catch(NoSuchElementException | IllegalStateException ex) {
			System.out.println("[입력 오류] 알맞은 값을 입력해주세요.");
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}

	}
}
