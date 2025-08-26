
public class Ex02_Exception {
	public static void main(String[] args) {
		System.out.println("main start");
		
		int num = 100;
		int result = 0;
		
		// 코드가 의심되면... 예외 처리(프로그램 강제 종료 막음)
		try {
			for(int i = 0;i < 10;i++) {
				result = num / (int)(Math.random() * 10); // 0 ~ 9
				// 0이 나오면 예외 발생
				System.out.println("result : " + result + " , i : " + i);
			}
		}catch(ArithmeticException e) { 
			//ArithmeticException 실제 발생하는 예외로 잡는게 좋다
			
			//문제의 원인을 파악하겠다
			System.out.println("[예외] 0으로는 나눌 수 없습니다. 관리자에게 알려주세요");
			System.out.println("원인 : " + e.getMessage());
		}
		System.out.println("main end");
	}
}
