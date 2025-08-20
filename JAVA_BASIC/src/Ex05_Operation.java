
public class Ex05_Operation {

	public static void main(String[] args) {
		// 연산자(산술, 논리, 관계)
		int result = 100 / 100;
		System.out.println("result : " + result);
		
		result = 13/2;
		System.out.println("result : " + result); // 몫만 계산함
		
		// 나머지 알고 싶다면?
		result = 13 % 2;
		System.out.println("result 나머지 : " + result); // 나머지 1
		
		// DB로 가면 %문자열 검색 패턴으로 쓰인다
		// 오라클은 mod()함수 사용. 
		
		// 증가감 연산자 : ++ 1씩 증가, -- 1씩 감소
		int i = 10;
		++i; // 전위(전치) 증가
		System.out.println("i : " + i);
		i++; // 후위(후치) 증가
		System.out.println("i : " + i);
		
		// 중가감 연산자가 다른 연산과 결합 되지 않으면 의미가 없다.(전치, 후치)
		
		// 복습을 잘하자(8시간 배웠으면 8시간 복습해야한다)
		// Today Point 
		int i2 = 5;
		int j2 = 4;
		int result2 = i2 + ++j2; // 10
		System.out.println("result2 : " + result2 + ", j2 : " + j2);
		
		result2 = i2 + j2++; // 11 
		
		byte b = 100;
		byte b2 = 1;
		// byte b3 = b + b2; // Type mismatch: cannot convert from int to byte
		// ** 자바의 정수 연산의 기본값은 int 
		// 그래서 타입이 안 맞는다.
		// 그래서 기본 int로 쓰자고..
		// 자바의 정수 연산의 기본은 int(4byte) 공간에 값을 넣게 계산
		int b3 = b + b2;
		// byte b3 = (byte)b + b2; // 손실(권장X)
		// byte + byte > int + int 결과 -> int
		
		/*
		 * Today Point 
		 * 정수 연산은 int타입으로 변환 후 처리
		 * 	예) byte + short는 컴파일러가 내부적으로 어떻게 바꿔서 계산할까?
		 * 		int + int로 계산
		 * 
		 *  예) char + char는 컴파일러가 int + int로 계산
		 *  
		 *  정수 연산에서 int보다 작은 타입들은 내부적으로 int로 바꾸어 처리함
		 *  정수에서 long은 예외(손실나니까)
		 *  나머지 byte, char, short는 int로 변환
		 *  
		 *  예) char + int는 int
		 *     int + int는 int
		 *     int + long은 long
		 *    
		 * 정수 + 실수는 타입 크기에 상관없이 **실수**
		 * */
		
		long lo = 1000000L;
		float fo = 1.2f;
		//long result3 = lo + fo; // float로 줌(결과를)
		// long result3 = (long)lo + fo; //-> 손실 가능성
		float reulst3 = lo + fo; // 권장하는 방법
		
		//변수, 데이터 타입(값타입, 참조타입), 연산자(산술, 논리, 관계), 제어문(if, for)
		//제어문
		// for(초기값;조건;증가감){}
		int sum = 0;
		for(int j = 0; j <= 100 ;j++) { 
			// j가 0부터 1씩 증가하며 100까지 반복 101되면 종료
			//sum += j; // sum = sum + j;
			if(j % 2 == 0) { //짝수의 합
				sum += j;
			}
		}
		System.out.println(sum); // 5050
		
		//if문
		if(10 == 10.0f) { // == 타입 비교 아님 값비교, 결과 : true
			// == 연산자(값을 비교하는 연산자)
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}
	


}
