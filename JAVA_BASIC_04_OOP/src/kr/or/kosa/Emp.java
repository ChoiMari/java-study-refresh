package kr.or.kosa;

public class Emp {
	private int empno;
	private String ename;
	
	public Emp(int empno, String ename) {
		super();
		this.empno = empno;
		this.ename = ename;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}

	
	// 다음 코드는 1일차 개발자나, 10년차 개발자나 같은 코드이기 때문에
	// 눈에서 사라질 것이다(-> 자동화 하기 때문에)
	
	// 실제 Object클래스의 toString()메서드
	// 패키지+@+해시코드 주소값
	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + "]";
	} 
	//-> 오브젝트 클래스의 toString()메서드를 재정의해서 
	// 멤버필드 값을 확인하는 용도로 많이 사용함
	// 재정의 하기 전에는 패키지+@+해시코드 주소값이 출력됨
	//-> 필요하면 재정의 해서 사용함
}
