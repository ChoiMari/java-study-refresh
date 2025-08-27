
/*
1. 1~45 까지의 난수를 발생시켜서 6개의 정수값을 배열에 담으세요
2. 배열에 담긴 6개의 배열값은 중복값이 나오면 안되요 (중복값 검증)

3. 배열에 있는 6개의 값은 낮은 순으로 정렬 시키세요(정렬 : 자리바꿈 : swap)

4. 위 결과를 담고있는 배열을 출력하세요

main 안에서 모두 작성하셔도 되고요
static 함수를 만들어 기능 나누는 것은 가능 (x)
별도의 Lotto.java 클래스는 생성하지 마세요 ....(x)
*/


public class Ex06_Lotto_Quiz {
	
	// 1. 1~45 까지의 난수를 발생시켜서 6개의 정수값을 배열에 담으세요
	static public int[] randomArr(int size, int number) {
		int[] numbers = new int[size];
		for(int i = 0;i < numbers.length;i++) {
			numbers[i] = (int)(Math.random() * number) + 1;
		}
		System.out.print("난수 생성 : "); // 확인용 출력
		arrayPrint(numbers);
		return numbers;
	}
	
	// 2. 배열에 담긴 6개의 배열값은 중복값이 나오면 안되요 (중복값 검증)
	static public int[] createLotto(int[] numbers) {		
		for(int i = 0;i < numbers.length;i++) {
			for(int j = 0;j < numbers.length;j++) {
				//if(i == j) continue; // 인덱스 같을 땐 건너뜀
				
				if(i < j) { // 불필요 검사 제거
					if(numbers[i] == numbers[j]) { // 중복인 경우
						numbers[j] = (int)(Math.random() * 45) + 1; // 새로 저장
						//numbers = createLotto(numbers); // 다시 검사
						i--;
						break;
					} 
				}
			}
		}
		return numbers; 
	}
	
	// 3. 배열에 있는 6개의 값은 낮은 순으로 정렬 시키세요(정렬 : 자리바꿈 : swap)
	static public int[] bubbleSort(int[] numbers) {
		int temp; // 읽히기 전에 대입(초기화)되는 경로 보장되어 있기 때문에 컴파일 에러 안남
		for(int i = 0 ;i < numbers.length;i++) {
			for(int j = 0;j < (numbers.length - 1) - i;j++) { 
				if(numbers[j] > numbers[j + 1]) { // 앞에 숫자가 더 크면 실행
					temp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp; 
					//-> 값을 바꿔서 위치 변경(큰 숫자를 뒤로 보냄)
				}
			}
		}
		return numbers;
	}

	static public void arrayPrint(int[] arr) { // 확인용 출력 메서드
		for(int i : arr) {
			System.out.print(i + "\t");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		int[] LottoNums = createLotto(randomArr(6, 45));
		// 결과 출력
		System.out.print("로또 번호 : ");
		arrayPrint(LottoNums);
		
		int[] ascSortArr = bubbleSort(LottoNums);
		// 결과 출력
		System.out.print("버블 정렬 : ");
		arrayPrint(ascSortArr);

	}
}
