/*
1. 1~45 까지의 난수를 발생시켜서 6개의 정수값을 배열에 담으세요
2. 배열에 담긴 6개의 배열값은 중복값이 나오면 안되요 (중복값 검증)

3. 배열에 있는 6개의 값은 낮은 순으로 정렬 시키세요(정렬 : 자리바꿈 : swap)

4. 위 결과를 담고있는 배열을 출력하세요

main 안에서 모두 작성하셔도 되고요
static 함수를 만들어 기능 나누는 것은 가능 (x)
별도의 Lotto.java 클래스는 생성하지 마세요 ....(x)
*/

import java.util.Random;

public class Ex06_Lotto {
	public static void main(String[] args) {

		int[] numbers = new int[6];
		//int[] arrLotto = new int[6];
		for(int i = 0;i < numbers.length;i++) {
			int rand = (int) (Math.random() * 44) + 1; // 1 ~ 45
			numbers[i] = rand;
			System.out.print(numbers[i] + "\t");
		}
		
		boolean control = true;
		
		while(control) {
			for(int i = 0;i < numbers.length;i++) {
				int rand = (int) (Math.random() * 44) + 1; // 1 ~ 45
				if(i == 0) {//numbers[i] = rand; 
				continue;} // 인덱스 0일때 저장하고 건너뜀
				for(int j = 0;j < numbers.length;j++) {
					if(i == j) {
						continue;
					} else if(i < j) {
						if(numbers[i] == numbers[j]) {
							numbers[j] = rand;
							
						}
					}
				}			
			}
		}

		
		System.out.println();
	}
}
