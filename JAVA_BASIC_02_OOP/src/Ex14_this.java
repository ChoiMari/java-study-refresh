/*
 this 이것
 1. 객체 자신을 가리키는 this (앞으로 생성될 객체의 주소를 담을 곳이라고 가정)
  -> 인스턴스 자신을 가리키는 참조 변수, 인스턴스의 주소가 저장될 곳. 
 2. 객체 자신(주소)를 가리킴 : 생성자 호출이 가능(원칙적으로는 생성자는
 객체 생성 시 한 개 호출이 원칙. 단, this는 예외)
 this를 활용하면 여러개의 생성자를 호출할 수 있다. 
 */

class Test5 {// extends object가 숨겨져 있음
	int i;
	int j;
	
	Test5(){
		
	}
	
	Test5(int i, int j){
		this.i = i; //여기서 this는 Test5의 메모리 주소
		this.j = j;
	}
}

class Book2{
	String bookName;
	
	Book2(String bookName){
		this.bookName = bookName;
	}
}

// Today Point
// 생성자를 호출하는 this( *** 중복 코드 감소 *** )
class Socar{
	String color;
	String gearType;
	int door;
	
	Socar(){ // 기본값
		this.color = "red";
		this.gearType = "auto";
		this.door = 2;
	}
	
	Socar(String color, String gearType, int door){
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
	
	void soCarPrint() {
		System.out.println(this.color+ " , " + this.gearType + " , " + this.door);
	}
}


public class Ex14_this {
	
	public static void main(String[] args) {
		Socar socar = new Socar(); // 기본차량
		socar.soCarPrint();
		Socar socar2 = new Socar("gold","auto",6);
		socar2.soCarPrint();
		
	}
}
