/*
  오류
1. 에러(error)    : 네트워크 장애 , 메모리 , 하드웨어 >> 개발적 코드적으로 해결 불가
2. 예외(exception): 개발자가 코드 실수로 발생 >> 문제 발생 코드 찾아서 >> 수정 >> 배포
2.1 컴파일시 ...실행파일 생성 안되요 (무조건 해결)
2.2 런타임 시(실행도중)에 문제(예외)가 발생 >> 프로그램 강제 종료 
	>> 문제가 생긴 시점 >> 이후 나머지 코드 실행 안되요

예외처리 : 프로그램이 안정적으로 종료 >> 나면 원인 분석 >> 코드 수정 ....>> 다시 배포

try{
     >>문제가 의심되는 코드
     >>문제가 발생 되면 >> 어떤 일이 >> 예외가 발생한 정보를 담을 수 있는 객체 자동생성
     ex)
     >>[0][1][2]  >> car[3] = "" >> ArrayIndexOutOfBoundsException (생성) >>  예외담기
     >> new ArrayIndexOutOfBoundsException("정보")
     예외가 발생하면 자동으로 예외 객체를 생성해서 던짐
}catch(Exception e){  Exception 모든 예외에 부모타입 //-> 다형성
// try에서 어떤 예외가 발생할 지 몰라서 가장 큰걸로 잡음(부모 클래스라서)
      >> 문제 파악
      >> 처리 (코드 수정되지 않아요) 보고
      >> 1.관리자 email 온다고
      >> 2.로그기록 (장애 발생 기록) 예)log4j
      >> 3.강제 종료는 막는다 ^^
}finally{ // 항상 실행
      >> 문제가 발생되던 , 발생하지 않던 강제적으로 실행되는 코드
      >> 함수 return 만나요 종료 ... try와 catch문에서 return 을 만나도 finally 강제 실행
      >> DB작업 ...DB자원 종료(해제) 강제....
}
 */
public class Ex01_Exception {
	public static void main(String[] args) {
//		System.out.println("main start");
//		System.out.println(0/0); // 0으로 나눠질 수 없음
//		//-> java.lang.ArithmeticException: / by zero
//		// 연산 예외 : 0으로 나눴다.
//		
//		System.out.println("main end"); // 실행 안됨
		
		//예외 처리
		System.out.println("main start");
		try {
			System.out.println(0/0);
		}catch(Exception e){ 
			// e라고 하는 참조 변수가 예외 객체의 주소값을 받음
			//(다형성, 부모예외타입으로 대신 받을 수 있음)
			//문제 파악만 가능
			System.out.println(e.getMessage());
			
			e.printStackTrace(); // 디테일한 정보를 보고 싶을 때
			/*
			 	java.lang.ArithmeticException: / by zero
				at Ex01_Exception.main(Ex01_Exception.java:43)
			 */
		}
		System.out.println("main end");
		
	}
}
