package ko.or.kosa.common;

class Car { //default : 같은 패키지 내에서만 접근 가능
	public int data; // 의미 없음 
	int door;
	private int data2;
	// 의미? yes, 다른 클래스에서는 접근 불가
	//getter & setter로만 간접 할당(정보 은닉, 캡슐화)
}
