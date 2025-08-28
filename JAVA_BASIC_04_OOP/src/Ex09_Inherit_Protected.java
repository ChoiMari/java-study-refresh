import kr.or.kosa.Bird;

class Bi extends Bird{
	
	@Override
	public void moveFast() {
		super.moveFast(); // 부모의 moveFast() 메서드 호출
	}
}

class Ostrich extends Bird{
	// 타조의 특징(구체화, 특수화)
	void run() {
		System.out.println("run ....");
	}
	
	@Override
	public void moveFast() {
		run();
	}
}

public class Ex09_Inherit_Protected {

	public static void main(String[] args) {
		Bi bi = new Bi();
		bi.fly(); //protected로 선언한 건 안보임
		//-> 다른 패키지에 있기 때문에..
		// 사용하려면 오버라이드 해야 보인다(public으로 열어주어야)
		
		Ostrich os = new Ostrich();
		os.moveFast();
		
	}
}
