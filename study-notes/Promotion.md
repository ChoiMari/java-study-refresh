## 자동 타입 변환
부모타입 변수 = 자식타입객체;
 -> 자동 타입 변환됨
부모타입 변수는 자식타입객체의 주소값을 저장할 수 있다(자동변환)
```java
class Parent{
	public void hello(){
		System.out.println("나는 부모 클래스");
	}
}	
class Child extends Parent{
	@Override
	public void hello(){
		System.out.println("나는 자식 클래스");
	}
}

public class Main{
	public static void main(String[] args){
		Child child = new Child();
		Parent parent = child; // new Child();도 가능
		// 부모타입 변수는 자식객체의 주소값을 저장할 수 있다(자동변환, 업캐스팅)
		parent.hello(); //-> 자식객체에서 오버라이드(재정의)한 메서드가 호출됨 -> 다형성
		// 컴파일 시점 : Parent클래스에 hello()메서드가 선언되어있는지 확인함
		// 있으면 컴파일 통과(없으면 컴파일 에러)
		// 실행시점(JVM)
		// Child에 오버라이딩이 있으면 Child의 메서드 실행
		// 없으면 부모클래스의 메서드 실행함
	}
}
```

부모타입으로 자동 타입변환된 이후에는 **부모 클래스에 선언된**
필드와 메소드만 접근이 가능하다.