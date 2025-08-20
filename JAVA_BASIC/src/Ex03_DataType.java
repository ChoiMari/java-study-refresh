/*
 데이터 타입
 1. 자바가 제공하는 기본 타입(원시 타입) 8가지
 2. 이 8가지의 기본 타입은 값을 저장함
 
 숫자(정수, 실수)
 	정수(음수, 0, 양수) 
 	byte(8bit=1byte) : -128 ~ +127(0포함, 1byte는 8bit), 이 단위는 통신할 때 사용한다고 함
 	char(2byte) : 한 문자(내부적으로 정수값 : 아스키 코드표 10진수와 문자)가 
 				  들어갈 수 있는 공간(* 내부적으로는 정수값을 갖는다)
 				  영문자, 특수문자, 공백(1byte)
 	
 	DB에서는..
 	Tip) create table emp(empno number, ename char(20), hobby varchar2(20),
 						addr nvarchar2(20)) //nvarchar2 : 유니코드베리어블캐릭터
 				한글 UTF-8기준 3바이트 표현,캐릭터 셋(인코딩 문자표)에 따라 다름
 	문제 ) char, varchar2, nvarchar2 차이점을 설명하시오.
 	
 	자바에서는..
 		char c = 'A' 
 	자바스크립트에서는..
 		let c = 'AAAA'; let c2 = "AAAA" 문자열로 다 받는다고 함
 		
 	short 호환성이 때문에 만들어서 현재는 잘 안쓴다고(C언어와 호환위해)
 	
 	int(4byte) : -21억 ~ +21억까지의 정수 저장 가능, 정수 리터럴의 기본 타입
 	long(8byte) : 
 	
 	실수
 	자바는 고정소수점안쓰고 부동소수점을 사용한다
 	float(4byte) : 소수점 이하, 약 7자리 표현 가능
 	double(8byte) : 소수점 이하, 약 15자리 표현 가능
 	
 	두 실수 타입 중 정밀도(-> 좀 더 많이 표현 가능한 정도, 표현의 범위)는 double이 높다.
 	실수 리터럴의 기본 타입은 double
 	
 	논리
 	boolean
 	참, 거짓(true, false)
 	boolean 1비트만 있으면 충분하지만, 실제 JVM에서는 1바이트로 관리
 	
 	그냥
 	정수는 int, 실수는 double 타입 쓰면 편하다
 */

/*
 * 가장 많이 사용하는 타입 : String(문자열 타입)
 * String은 클래스
 * String은 값타입처럼 써도 문제 없다고 함
 * String str = "홍길동";
 * new로 객체생성 안해도 됨
 * 약속) 강사님이 별도의 이야기 전까지 8개 기본타입 + 1(String)
 * int, double처럼 쓰라.
 * 
 * 자바 타입은 기본타입(값타입 8개) + 참조 타입
 * 참조 타입은 변수에 메모리 주소값을 저장하는 타입
 * 	 |__ 클래스 타입, 인터페이스 타입, Array 등등...
 
 class Car{} 
 main(){
 	Car car = new Car(); // car변수에는 메모리 주소값이 들어있음
 	int num = 100; //num변수에는 100(값)이 들어있음
 }
 
 [정수값을 표기하는 방법]
 십진수(예 - 100),
 16진수(예 - 0x2a),
 8진수(예 - 0123)
 2진수(0b1100100) b는 바이너리라는 뜻
 
 123L or 123l(소문자 ㅣ) : 리터럴 long타입 10진수라고 부름
 자바에서는 리터럴을 기본 int타입에 담음
 근데 long타입에 담고 싶다... 그럴 때 리터럴에 L을 붙임
 0x2aL 이것도 뒤에 L이 붙음 이것도 long타입. 리터럴 long타입 16진수
 
 [실수값을 표기하는 방법]
 3.14
 123.4 : 기본 double에 담음
 123.4f(123.4F) : float 타입 변수에 담고 싶을 때 이렇게 사용. 
 리터럴 끝에 f를 붙여서 컴파일러에게 알려줌
 안붙이면 컴파일 에러남
 
 1.234e2승(지수표현) > 123.4
 소수점이 왔다갔다 표기
 
 [문자값을 표기하는 방법]
 'A' 또는 '가' 
 '\u0065' -> 유니코드 이스케이프 표기법
    뒤에 16진수 4자리 코드 포인트 입력
 
 [논리값 표기하는 방법]
 ture, false
 
 [문자열을 표기하는 방법]
  ""
  
 */
public class Ex03_DataType {
	public static void main(String[] args) {
		// int(-21 ~ 21)
		int num = 100000000;
		System.out.println("num : " + num);
		int num2 = 100000;
		long num3 = 100; 
		// 내부적으로 컴파일러가 자동 변환함(암시적 형변환)
		// long num3 = (long)100; 
		// 기본 int타입을 long타입으로 컴파일러가 자동으로 형변환해서 저장
		// 작은 타입을 큰타입에 넣는 것은 당연
		
		// 초보 개발자 주의 사항
		//int num4 = 10000000000; // The literal 10000000000 of type int is out of range 
		//int num4 = 10000000000L; // Type mismatch: cannot convert from long to int
		
		//해결 방법 1
		//long num4 = 10000000000L;
		
		//해결 방법 2
		int num4 = (int)10000000000L; // 명시적 형변환(casting)
		System.out.println("num4 : " + num4); //num4 : 1410065408
		// 알 수 없는 쓰레기 값이 나온다(손실 감수)
		// NO!!!!!!!!!!!!!!!!!
		// 적절하지 않음
		
		int num5 = (int)100000L; // 타입 불일치
		//-> 이건 손실이 없다.. (int범위에 안 넘치니까..)
		System.out.println("num5 : " + num5);
		
		// 결론 -> 데이터에 맞게 타입 설정을 잘하자.
		
		//char(2byte) 한문자 표현, 정수값(0 ~ 약 6만)
		//아스키 코드 문자표 (a는 65)
		
		char ch = '가'; 
		System.out.println(ch);
		
		ch = 'a';
		ch = 'A'; //-> 아스키 코드표에서 65
		
		// char 타입은 정수 타입
		// 문자를 저장하지만 내부적으로는 정수값을 가진다
		// 확인 
		int chInt = ch; // 자동 형변환
		// 작은 데이터 타입이 큰 데이터 타입으로 자동 형변환
		System.out.println("ch 문자를 정수 값으로 확인해 보면 : " + chInt); // 65
		
		// 컴파일러가 내부적으로 int chInt = (int)ch;
		
		char chInt2 = 'a';
		System.out.println(chInt2); // a
		// 오버로딩 
		// 파라미터가 char로 읽힘
		
		// int intCh2 = chInt2; 자동형변환 되지만.. 
		// 컴파일러처럼 동작하자면,
		//int intCh2 = (int)chInt2; 이렇게(명시적 형변환)
		
		int intCh3 = 65;
		
		// 해결 방안 1 - 데이터 손실 없음. 0~약 6만 범위에 들어감
		// 단점 : 값이 범위에 벗어날 경우 데이터 손실 발생 가능.
		// 명시적 형변환의 단점.
		//char ch3 = (char)intCh3; 
		//System.out.println("ch3: " + ch3); // A
		
		// 해결 방안 2 - 받는 타입을 크게 함
		int ch3 = intCh3;
		
		/*
		 * 1. 할당에 있어서 값을 보지 말고 값의 타입을 보자
		 * 1-1 리터럴 값에 대해서 알자.(리터럴? 개발자가 직접 입력하는 값)
		 * 1-2 정수 리터럴의 기본 타입은 int
		 * 1-3 실수 리터럴의 기본 타입은 double
		 * 
		 * 2. 암시적 형변환, 명시적 형번환
		 * 2-1. 큰 타입에 작은 타입 값을 넣는 것은 암시적 형변환을 통해서
		 * 2-2. 작은 타입에 큰 값을 넣고자한다면(넘침), 데이터 손실 
		 * 		-> 컴파일러가 자동 형변환을 지원하지 않는다. 
		 * 		-> 개발자가 강제적 명시적 형변환을 해야함
		 * 		-> 접미사(L,l) 또는 (int)정수 사용
		 * 		-> 데이터 손실 감수, 개발자 책임
		 * ex) char c = (char)int 손실발생 데이터가 타입의 범위에 넘어서면..(작은경우에는 괜찮음, 넘치는게 문제)
		 * 
		 *String 8 + 1(String)
		 *값타입처럼 써도 문제가 없다
		 * 문자열 "가나다"를 ['가']['나']['다'] 
		 * 내부적으로 char배열의 집합이 String
		 * 그래서 따로 기본타입으로 만들지 않았다 문자열을..
		 * 그냥 기본타입처럼 String을 사용하면 된다.
		 * */
		String name = "홍길동";
		name = "홍길동 바보"; //-> 내부적으로 덮어쓰는것은 아니고 메모리 주소를 바꿈
		// 메모리 하나를 더 할당함. 전의 주소는 끊어버리고 새로 할당한거와 연결
		
		String color = "red";
		color = color + " 방가방가";
		System.out.println(color); //red 방가방가
		
		// TIP
		// 연산자는 언어마다 다르다.
		/*
		 java에서는 +가 산술연산, 연결 연산(문자열 연결)
		 Oracle에서는 + 는 산술만, 연결은 || 이게 결합 연산자
		 	ex) '안녕' || '하세요' -> '안녕하세요'
		 	
		 자바는 타입에 엄격하다
		 
		 자바스크립트는
		 let i; //-> i 출력 시 정의되지 않았다(undefined)
		 i = 100; //-> 이때 타입이 숫자타입으로 결정됨, 동적 타이핑
		 선언 시 타입 없음, 값 넣을 때 타입이 따라감
		 
		 * */
		
		// java에서 특수 문자 처리하기
		// char안에 '를 찍고 싶을 때
		//char sing = '''; // Invalid character constant
		// -> 이스케이프 문자 사용
		// 어떤 특정한 문자값을 그 앞에 붙이면 다른 형태로 바뀌는 것
		// \를 붙이면 다음 값은 데이터로 인정함
		char sing = '\''; 
		System.out.println(sing); // '나옴
		
		// Quiz) 홍"길"동 이라는 문자열을 출력
		String userName = "홍\"길\"동";
		System.out.println(userName); // 홍"길"동
		
		String str1 = "10000"; // 문자열 
		String str2 = "10";
		String result = str1 + str2; // 오라클은 암시적 형변환으로 연산되지만
		// 자바는 결합(문자열 연결)
		System.out.println("result : " + result); //1000010
		
		System.out.println("100" + 100);
		System.out.println(100 + "100");
		System.out.println(100 + 100 + "100");
		System.out.println(100 + ("100" + 100));
		System.out.println(100 + "100" + 100);
		// -> 자동 형변환(int -> String) +가 연결 연산자로 사용됨
		
		//Quiz) 경로 C:\Temp 문자열로 String 변수에 담아서 출력
		String path = "C:\\temp"; // \를 2개 써야
		System.out.println("path : " + path); // path : C:\temp
		
		// 이스케이프 시퀀스 문자 사용 방법
		// \t : tab
		// \n : 줄내림(new line)
		path = "C:\\T\te\tm\np";
		System.out.println("path : " + path);
		
		//byte 타입은 네트워크 데이터 교환, 파일처리(파일 업로드 다운로드)에 사용됨
		// 주로 배열로 쓰인다.
		// 나중에 네트워크 갈 떄 
		// byte[] ..배열로 활용
		
		//long 타입은 금융 데이터 쪽에 사용함
		// 그래서 자바는 화폐 단위를 따로 만들었다고 함(클래스 타입 데이멀?)
		
		// 실수형(부동소수점)
		// float 4byte
		// double 8byte(실수 리터럴의 기본 타입)
		// float f = 3.14; //-> 타입이 맞지 않다 .. 3.14가 기본 double타입이라서
		// 해결
		// float f = 3.14f;
		// float f = (float)3.14f; -> 둘 다 데이터 손실 발생할 수 있음
		
		// 현명한 개발자는
		double f = 3.14;  // 타입을 더 크게 바꾼다.
		
		float data = 1.123456789f;
		System.out.println("float data : " + data);
		// float data : 1.1234568
		// 반올림
		
		double data2 = 1.23456789123456789;
		System.out.println("double data2 : " + data2);
		// double data2 : 1.234567891234568 // 반올림
		
		// 자바는 BigDecimal 클래스를 만듬
		// 정밀한 수 표현할 수 있게 만듬
		// 화폐 단위로 사용 목적
		
		//Quiz 1) 
		double data3 = 100;
		// 결과값 100.0
		System.out.println("data3 : " + data3);
		
		//Quiz 2)
		double data4 = 100;
		int number = 100;
		// 연산 되게 고치시오
		//int result2 = data4 + number; //-> 해결하기
		
		// 방법 1
		// int result2 = (int)data4 + number;
		// int result2 = int(data4 + number); //-> 데이터 손실 발생 우려(권장하지 않는 방법)
		// 원래는 큰 그릇에 담김
		//double  + int는 큰타입을 쫓아가서 double타입이 나옴
		
		// 방법 2(권장하는 방법) - 담는 그릇을 크게.
		double result2 = data4 + number;
		
		//Quiz 3)
		int number2 = 100;
		//byte b2 = (byte)number2; // 방법 1(데이터 손실, 명시적 형변환 - 권장 X)
		int b2 = number2; // 방법 2(담는 타입 그릇을 크게)
		
		// Today Point
		// 1. 큰타입 + 작은 타입 연산 결과는 큰 타입을 따라간다
		// 2. 타입 간의 변환은 
		// 		 변수가 가지는 값을 보지말고 변수의 타입을 보자
		// 3. 명시적(강제적) 형변환은 데이터 손실을 가져올 수 있다(권장 X)
		
		int data5 = 100;
		byte b3 = (byte)data5; // 명시적(강제적) 형변환
		
		byte b4 = 20;
		//int data6 = b4;
		int data6 = (int)b4; // 컴파일러가 자동으로 하는 것
		// 암시적으로 변환되게 두어라.
		// 작은 타입에 큰 타입을 담는 경우는... 신경 안써도 된다..
		// 큰 타입에 작은 타입을 넣을 땐 자동으로 안해주니까 명시적 형변환 할 수 있지만,
		// 데이터 손실 감수해야 함
	}

}
