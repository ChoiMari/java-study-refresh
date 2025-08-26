package kr.or.kosa;

public class Emp {
	private int empno;
	private String ename;
	
	public Emp(int empno, String ename) {
		this.empno = empno;
		this.ename = ename;
	}
	
	public void empInfoPrint() {
		System.out.println(this.empno + "/" + this.ename);
	}
}
