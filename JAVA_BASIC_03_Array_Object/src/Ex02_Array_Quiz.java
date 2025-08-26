
public class Ex02_Array_Quiz {
	public static void main(String[] args) {
		//국문과 학생들의 기말고사 시험 점수
		int[] score = new int[] {79,88,97,54,56,95};
		int max = score[0]; // 79
		int min = score[0]; // 79
		
		// 제어문을 통해서 max라는 변수의 시험 점수 중 
		// 가장 큰 최댓 값을 담고
		// min 변수에는 시험 점수 중 가장 작은 값을 담으라.
		// 단 for문을 한번만 사용해서 max와 min값을 다 구해라
		for(int i = 0;i < score.length;i++) {
			if(max < score[i]) {
				max = score[i];
			}
			if(min > score[i]) {
				min = score[i];
			}
		}
		System.out.printf("max : %d, min : %d\n", max, min);
		
		//10개의 방의 값을 1~10까지 초기화 시키고 출력하기
		int[] numbers = new int[10];

		for(int i = 0;i < numbers.length;i++) {
			numbers[i] += i + 1; 
			System.out.print(numbers[i] + "\t");
		}
		System.out.println();
		//어느 학생의 기말고사 시험점수(5과목)
		int[] jumsu = {100,55,90,60,78};
		int sum = 0;
		float avg = 0f;
		// 1. 총 과목 수
		System.out.println("총 과목 수 : " + jumsu.length);
		
		// 2. 총 과목의 합
		// 3. 과목의 평균(총 합/과목수)
		// 2,3번은 하나의 for문으로 해결하기
		for(int i = 0;i < jumsu.length;i++) {
			sum += jumsu[i];
			if(i == jumsu.length - 1) { // 마지막 원소일 때 딱 1번 계산
				avg = sum / (float)jumsu.length;
			}
		}
		// avg = (float)sum / jumsu.length;
		System.out.println("총 과목의 합 : " + sum + ", 과목의 평균 : " + avg);
		
 	}

}
