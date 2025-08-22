package ko.or.kosa;


// 클래스의 구성요소 : 필드(멤버 변수), 생성자, 메서드
// 필드(상태) : 고유 정보; 상태 정보; 부품 정보;
// 생성자(Constructor) : 객체 생성 시 필드 초기화 목적의 메서드
// 메서드( 기능, 행위)

public class Person {

	public String name; // 기본값 null
	// instance variable(객체 변수) - 객체마다 부여되는 변수
	// 생성되는 객체마다 다른 값을 가질 수 있음
	public int age; // 기본값 0
	public boolean power; // 기본값 false
	
	// default value(기본값)
	// 각 타입의 기본값으로 초기화됨(객체 생성 시(기본생성자 호출시에))
	// 그래서 사용 시 문제 없다
	// 지역변수는 초기화해야 사용 가능
	
	public void personPrint() {
		System.out.printf("이름은 %s, 나이는 %d, 파워는 %s 입니다.\n", name, age, power);
	}
}
