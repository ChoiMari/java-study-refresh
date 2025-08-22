import ko.or.kosa.Fclass;

public class Ex02_Method_Call {
	public static void main(String[] args) {
		Fclass fc = new Fclass();
		fc.m();
		
		fc.m2(1234);
		
		int result = fc.m3();
		System.out.println("result value : " + result);
		
		result = fc.m4(10);
		System.out.println("result value : " + result);

	}

}
