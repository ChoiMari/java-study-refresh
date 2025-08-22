package ko.or.kosa.common;

// DTO : 사원 1명의 데이터를 담을 수 있는 클래스
// Emp클래스는 사원 1명의 데이터를 담을 수 있음
// 다른말로 =VO라고도 부름(벨류 오브젝트) - 값만 담는 객체를 의미
// 주로 DB테이블의 한 행 데이터를 자바객체로 매핑할 때 사용함
// =domain
// Emp e1 = new Emp();
// e1.setEmpno(11111111);
public class Emp {
	private int empno;
	private String ename;
	private String job;
	private int sal;
	
	// 간접 할당
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
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	
	
	
}
