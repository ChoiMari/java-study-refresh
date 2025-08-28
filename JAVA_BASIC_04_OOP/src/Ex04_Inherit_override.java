/*
 Today Point
 **상속** 관계에서 override(메서드 재정의) 
 * 상속 관계에서 자식이 부모의 메서드를 재정의({}내부 구현을 바꿈)
 * [상속 관계]에서 [자식 클래스]가  [부모 클래스]의 메서드를 재정의
 
 * C#같은 경우는 부모 무시하기(자식이 우선)라고 부름
 
 * 구문
  1. 부모 메서드 이름과 동일해야한다
  2. 파라미터 동일
  3. 리턴타입 동일
  4. {} 내부 구현을 다르게
  
 */

class Point2{ //같은 패키지 안에 동일한 클래스명 못씀
	int x = 4;
	int y = 5;
	
	String getPosition() {
		return this.x + " / " + this.y;
	}
}

class Point3D extends Point2{
	int z = 6;
	
	@Override //-> 어노테이션 : 컴파일러에게 재정의 메서드라고 알려주는것
	//-> 잘 작성했는지 검사해준다(문법에러 체크)
	//-> 상속 관계에서 컴파일러에게 코드 작성 문법에 대한 검사를 시킴(재정의가 맞는지)
	// 실수 방지 목적으로 사용함
	String getPosition() { 
		return this.x + " / " + this.y + " / " + this.z;
	}
	
}

	//Annotation 
	/*
	 어노테이션은 사전적 의미로는 주석이라는 뜻이다. 
	 자바에서 사용될 때의 어노테이션은 코드 사이에 주석처럼 쓰여서 특별한 의미, 
	 >>기능을 수행하도록 하는 기술이다. 
	 >>즉, 프로그램에게 추가적인 정보를 제공해주는 메타데이터(meta data: 데이터를 위한 데이터)라고 볼 수 있다.
	
	 1.컴파일러에게 코드 작성 문법 에러를 체크하도록 정보를 제공
     2.소프트웨어 개발툴이 빌드나 배치시 코드를 자동으로 생성할 수 있도록 정보 제공
     3.실행시(런타임시)특정 기능을 실행하도록 정보를 제공
	*/

public class Ex04_Inherit_override {
	public static void main(String[] args) {
		Point3D p3 = new Point3D();
		System.out.println(p3.getPosition());
		
		// 자식에서 재정의 했으면 자식 메서드가 호출되는데
		// 부모 메서드를 호출하고 싶으면?
		// super() 
	}
}
