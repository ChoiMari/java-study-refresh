package kr.or.kosa;

public class Emp {
// 메인 함수 없어요 : 독자적으로 실행할 수 없음 
	
// 사원은 사원번호와 이름을 가지고 있다
	public int empno;		// 멤버 필드, 속성 
	public String ename;		// 인스턴스 : 앞으로 생성될 객체가 가지는 변수, 초기화가 강제가 아님 : default 값을 정하기 위해	
								// 생성되는 사원마다 다른 사번을 주고 싶어
	private int data;
	
	public void Info() {
		System.out.println(this.empno + "/" + this.data);
	}
	
	public void InfoData() {
		int number=0; // local variable: 함수 안에 있 : infoData가 사라질 때 소멸 
}
}
