/*
 static member field : 객체 간 공유 자원
 static method : 객체 간 공유 자원
 
  1. 설계도(클래스)를 만듬
  	static 자원(변수 + 메서드)만 다 써서 설계함
  	이유 : 프로젝트 전체에서 많이 사용되는 경우
  	객체 생성없이 편하게 사용이 가능하다.(new가 필요없으니까)
  	- 자원을 많이 사용할 것 같을 때 static 키워드를 붙인다.
  	
  	남용하면 좋지 않다 : 프로그램 종료 시까지 메모리에 할당 되어서
  		계속 자리를 차지 하고 있음.
 */

class StaticClass{
	int iv;
	static int cv;
	
	static void print() { //-> 객체 생성 없이 사용 가능
		System.out.println("static method"); 
		
		// **Point**
		// 여기에서 iv못씀(이 메서드는 static이라서
		// 프로그램 시작전에 이미 메모리에 올라가져 있는데 
		// 그때는 메모리에 안올라가져 있기 때문)
	}
	
	void printIv() {
		//일반 메서드
		// new StaticClass(); 메모리에 올라갔을 때 사용 가능
		cv = 100; // 순서 상 static이 올라가고 따라 올라오니까
	}
	
	// 끼리끼리 노는게 편하지만
	// static 자원과 일반 자원의 공생 관계를 알아야
}

public class Ex08_Static_Method {
	public static void main(String[] args) {
		StaticClass.print();
		StaticClass sc = new StaticClass();
		
		sc.printIv();
		System.out.println(sc.cv); // 100
	}

}
