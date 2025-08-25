
public class Ex09_Static_Method {
	void method() {
		System.out.println("일반 메서드");
	}
	static void smethod() {
		System.out.println("static 메서드");
	}
	public static void main(String[] args) {
		//일반 메서드 호출
		Ex09_Static_Method sm = new Ex09_Static_Method();
		sm.method();
		
		// static메서드 호출
		Ex09_Static_Method.smethod();
		
		sm.smethod(); // 이렇게도 가능 // 같은 메소드 영역에 있는 static메서드 호출
		// 같은 곳을 바라보고 있음
	}
}
