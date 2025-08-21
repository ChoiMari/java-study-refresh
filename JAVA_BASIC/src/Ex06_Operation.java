
public class Ex06_Operation {

	public static void main(String[] args) {
		// 대입 연산자
		// +=, -=. *=, /=
		int sum = 10;
		//sum += sum + 1;
		sum += 1;
		sum -= 1;
		System.out.println(sum);
		
		/*
		 if(조건식) {}
		 if(조건식) {} else {}
		 if(조건식) {} else if(조건식) {} else if(조건식) {} ... else{}
		 
		  간단한 학점 계산기
		  학점 : A+, A-, B+, B-, ..., F
		  
		  판단 기준 : 90점 이상이면 A -> 95점 이상 A+, 이상 A-
		  			  80점 이상이면 B -> 85점 이상 B+ 이하 B-
		  			  
		 90, 80, 70까지만 판단, 나머지 -> F
		 */
		
		int score = 94;
		String grade = ""; // 문자열 초기화 : A+, A-, C+
		//-> 지역변수는 초기화하지 않으면 쓸 수 없다
		
		System.out.println("당신의 점수는 : " + score);
		if(score >= 90) {
			grade = "A";
//			if(score >= 95) {
//				grade += "+";
//			} else {
//				grade += "-";
//			}
			grade += (score >= 95) ? "+" : "-";
		} else if(score >= 80) {
			grade = "B";
			grade = (score >= 85) ? "+" : "-";
		} else if(score >= 70) {
			grade = (score >= 75) ? "C+" : "C-";
		} else {
			grade = "F";
		}
		
		//논리구문
		System.out.println("당신의 학점은 : " + grade);
		
		// char 'A' ~ 'Z'
		// for문 사용해서 출력
		for(char i = 'A'; i <= 'Z'; i++) {
			System.out.print(i);
		}
		System.out.println();
		for(int i = 65; i <= 90; i++) {
			System.out.print((char)i);
		}
		System.out.println();
		for(int i = 1;i <= 100;i++) {
			System.out.print(i + " "); // 개행이 없음
			if(i % 10 == 0) {
				System.out.println();
			}
		}
		
		// 구구단
		// 2 ~ 9단
		// 1 ~ 9
		for(int dan = 2 ;dan < 10; dan++) {
			for(int j=1; j < 10; j++) {
				//System.out.print(dan + "*" + j + " = " + (dan*j) + "\t");
				System.out.printf("%d * %d = %d\t", dan, j, dan * j);
				// %d 10진수
			}
			System.out.println("\n-------------");
		}
		
	}

}
