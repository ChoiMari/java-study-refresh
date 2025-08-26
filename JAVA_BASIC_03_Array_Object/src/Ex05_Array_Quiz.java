import kr.or.kosa.Emp;

public class Ex05_Array_Quiz {
	public static void main(String[] args) {
		/*
		  사원 3명을 만드세요.
		  1000, 홍길동
		  2000, 김유신
		  3000, 유관순
		 */
		// 방법3
		Emp[] emps
		= {new Emp(1000,"홍길동"),new Emp(2000, "김유신"),new Emp(3000,"유관순")};
		
		//향상된 for문으로 출력
		for(Emp emp: emps) {
			emp.empInfoPrint(); // 객체의 주소 1개씩 꺼내서 그 주소로 메서드호출
		}
		
		// 방법1
		Emp[] emplist = new Emp[3];
		emplist[0] = new Emp(1000,"홍길동");
		emplist[0] = new Emp(2000, "김유신");
		emplist[0] = new Emp(3000,"유관순");
		
		//방법2
		Emp[] emplist2 = new Emp[] {
				new Emp(1000,"홍길동"),
				new Emp(2000, "김유신"),
				new Emp(3000,"유관순")
		};
	}
}
