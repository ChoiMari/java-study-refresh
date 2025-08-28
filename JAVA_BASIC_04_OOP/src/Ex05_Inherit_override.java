import kr.or.kosa.Emp;

class Test2{
	int x = 100;
	
	void print() {
		System.out.println("부모 메서드 Test2");
	}
}

class Test3 extends Test2{
	int x = 300; //-> C#에서는 부모 무시하기(쓰지 마세요)
}

public class Ex05_Inherit_override {
	public static void main(String[] args) {
		
		Emp emp = new Emp(7788, "smith");
		System.out.println(emp); //-> 주소값(toString()이 생략)
		
		System.out.println(emp.toString()); 
		
	}
}
