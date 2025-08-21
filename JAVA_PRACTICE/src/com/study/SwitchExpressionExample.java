package com.study;

// 자바 버전 12 이후부터는 switch문에서 표현식(Expressions)를 사용할 수 있다
// **break문**을 없애는 대신에 화살표와 중괄호를 사용해 가독성이 좋아짐
public class SwitchExpressionExample {

	public static void main(String[] args) {
		String season = "summer";
		
		switch(season) {
		case "SPRING", "spring" -> {
			System.out.println("봄입니다.");
		}
		case "SUMMER", "summer" -> {
			System.out.println("여름입니다.");
		}
		case "FALL", "fall" -> {
			System.out.println("가을입니다.");
		}
		case "WINTER", "winter" -> {
			System.out.println("겨울입니다.");
		}
		default -> {
			System.out.println("해당하는 계절이 없습니다.");
		}
		} 
		
		// 실행문이 1개일 경우에는 {} 생략이 가능하다
		switch(season) {
			case "SPRING", "spring"  -> System.out.println("봄입니다.");
			case "SUMMER", "summer" -> System.out.println("여름입니다.");
			case "FALL", "fall" -> System.out.println("가을입니다.");
			case "WINTER", "winter" -> System.out.println("겨울입니다.");
			default -> System.out.println("해당하는 계절이 없습니다.");
		} //-> 여름입니다.(break문 없이도 작동)
		
		// 스위치된 값을 변수에 바로 대입도 가능함
		// 단일 값일 경우에는 화살표 오른쪽에 값을 기술하면 되고
		
		// 중괄호를 사용할 경우에는 yield 키워드로 값을 지정(Java 13부터 사용 가능)
		// 단, 이 경우에는 default가 반드시 존재해야 함
		int num = 6;
		String result = switch(num) {
			case 1 -> "spring";
			case 2 -> "summer";
			case 3 -> "fall";
			case 4 -> "winter";
			default -> {
				System.out.println("입력 범위에 해당하지 않습니다.");
				yield "X"; // 여러 문장이 들어간 경우 {}를 사용하고
				// yield 키워드로 값을 지정함
			}
		};
		System.out.println("result : " + result); //result : X

	}

}
