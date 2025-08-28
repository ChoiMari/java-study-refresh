/*
  객체 1개만 가지고 쓰면 문제가 없음
  this : 객체 자신을 가리키는(this.empno, this...)
  this : 생성자 호출에도 사용 가능 this();
  		값 할당을 모든 필드를 초기화하는 생성자 1개만 주고
  		나머지 생성자는 this()로 할 수 있다.
  상속
  부모, 자식 관계
  자식입장에서 부모에 접근하는 키워드 
  	super() : 부모 객체의 주소
    [상속 관계]에서 자식이 부모 자원에 접근하는 주소
    
    1. super : 상속 관계에서 부모 자원에 접근 허용
    2. super() : 상속 관계에서 부모의 생성자 호출 가능
    
    Tip)
    C#에서는 base라고 부름
    JAVA : super
 */

class Base{
	String basename;
	Base(){
		System.out.println("부모의 기본 생성자");
	}
	Base(String basename){
		this.basename = basename;
		System.out.println("basename : " + this.basename);
	}
	
	void method() {
		System.out.println("부모 method");
	}
}

class Derived extends Base{
	String dname;
	Derived(){
		System.out.println("자식 클래스 기본 생성자");
	}
	Derived(String dname){
		super(dname); // 기본으로는 부모의 기본생성자인 super()가 호출되기 때문에
		// 부모의 오버로딩 생성자를 호출하고 싶다면 명시적으로 작성.
		
		this.dname = dname;
		System.out.println("dname : " + this.dname);
	}
	
	@Override
	void method() {
		System.out.println("부모의 method 재정의");
	}
	// 부모 클래스걸 쓰고 싶음...
	// -> super사용
	void parentMethod() {
		super.method(); //-> 부모 주소의 method()호출
		// super키워드로 부모 자원에 접근함
		// 이 객체의 부모는 super로 밖에 접근 못함
		
		// 주의 - 부모 객체 새로 생성해서 쓰는건 자식이 상속 받은 부모객체가 아니다...
		// 그건 다른 부모..
	}
}

public class Ex06_inherit_super {
	public static void main(String[] args) {
		//Derived d = new Derived();
		Derived d = new Derived("홍길동");
		// 오버로딩한 생성자 호출 했다고 해도
		// 부모는 super() 부모의 기본 생성자 호출됨
		// 그래서 원하면 명시적으로 작성하는 수밖엔 없다. super(dname); 
		d.method(); // 부모의 method 재정의
		d.parentMethod(); //부모 method
	}
}
