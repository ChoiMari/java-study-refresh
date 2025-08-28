class Pbase{
	int p = 100;
}

class Cbase extends Pbase{
	int c = 200;
}

class Dbase extends Pbase{
	
}

public class Ex11_Inherit_Poly {
	public static void main(String[] args) {
		Cbase cbase = new Cbase();
		System.out.println(cbase.toString());
		
		// 다형성
		Pbase pbase = new Cbase();
		Pbase pbase2 = new Dbase();
		// 단, 부모는 자신의 자원만 볼 수 있다
		// 단, 재정의 자원은 자식것을 본다
		
		//Dbase dbase = new Pbase();
		// 부모 주소를 자식에게 전달
		Cbase ccc = (Cbase)pbase; 
		//-> 부모가 더 크기때문에 문법적으로 캐스팅(강제 형변환)해야 함 
	}
}
