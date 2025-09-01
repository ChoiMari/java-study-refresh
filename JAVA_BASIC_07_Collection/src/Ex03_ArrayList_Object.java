import java.util.ArrayList;
import java.util.List;

import kr.or.kosa.Emp;

public class Ex03_ArrayList_Object {
	public static void main(String[] args) {
		// 1. 사원 1명을 만드세요
		Emp emp = new Emp(1000, "김유신", "장군");
		System.out.println(emp.toString());
		
		// 2. 사원 2명 만드세요
		Emp[] empArr = {new Emp(100, "김씨", "영업"), new Emp(200, "박씨", "IT")};
		for(Emp e : empArr) {
			System.out.println(e.toString());
		}
		
		// 위 작업은 불편..
		// 편하게 사용하자
		List elist = new ArrayList();
		elist.add(new Emp(100,"김씨","영업"));
		elist.add(new Emp(200,"박씨","IT"));
		
		//추가 입사
		elist.add(new Emp(300,"이씨","IT"));
		for(int i = 0;i < elist.size();i++) {
			System.out.println(elist.get(i).toString());
		}
		
		//toString 사용하지 말고 3명의 사원 정보를 출력하세요
		// 힌트 ) getter사용해서 조합하시오
		for(int i = 0;i < elist.size();i++) {
			Object obj = elist.get(i);
			// 자식타입으로 (다운)캐스팅
			Emp e = (Emp)obj;
			System.out.println(e.getEmpno() + ", " + e.getName() + ", " + e.getJob());
		}
		
		// Object 사용하면 다운캐스팅 필요
		// 실무에서는 하나의 타입으로 통일
		// 타입을 정의할 수 있는 클래스를 만듬
		// -> 제너릭(Generic)
		List<Emp> list2 = new ArrayList<Emp>();
		list2.add(new Emp(1, "A", "IT"));
		list2.add(new Emp(2, "B", "IT"));
		list2.add(new Emp(3, "C", "IT"));
		for(Emp e : list2) {
			System.out.println(e.getEmpno());
		}
	}
}
