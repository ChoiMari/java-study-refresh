import java.util.List;

import DAO.EmpDao;
import DTO.Dept;
import DTO.Emp;

public class Program2 {
	
	// 여러건의 데이터 출력
	public static void empPrint(List<Emp> list) {
		for(Emp emp : list) {
			System.out.println(emp.toString()); // toString 재정의 되어있음(@Data)
		}
	}
	
	// 1건의 데이터 출력 - 오버로딩
	public static void empPrint(Emp emp) {
		System.out.println(emp.toString());
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("[전체 조회]");
		EmpDao empDao = new EmpDao();
		List<Emp> empList = empDao.getEmpAllList();
		empPrint(empList);
		System.out.println("===================================");
		System.out.println("[조건 조회]");
		Emp emp =  empDao.getEmpByEmpno(7369);
		empPrint(emp);
		
		System.out.println("===================================");
		System.out.println("[like 검색]");

	}
}
