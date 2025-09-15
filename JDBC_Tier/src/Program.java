/*

  Model(DTO(VO), DAO, SERVICE) 
  	DTO : 데이터 1건을 담을 수 있는 객체
  	DAO : DB연결하고 메서드를 가질 수 있음
  	service : 요청을 처리
  View : 콘솔로 처리
  Controller : main 메서드에서 처리
 
 목적 : 
 	1. DB 연결
 	2. CRUD 메서드(DAO 만들 수 있다)
 	3. 기본 메서드 + 알파(조건 검색, 문자열 검색)
 	4. 전체 조회, 조건 조회, 데이터 삽입, 삭제, 수정 쿼리문을 작성할 수 있다.
 	
 	기본 중의 기본(초급)
 	
 	1. 드라이버 로딩(.jar파일 프로젝트 빌드패스에 추가)
 	2. 롬복 라이브러리 추가..
 	
 	-> 오라클 드라이버 .jar & 롬복 .jar 추가함
*/

import java.util.List;

import DAO.DeptDao;
import DTO.Dept;

public class Program {
	public static void main(String[] args) {
		DeptDao deptDao = new DeptDao();
		System.out.println("[전체 조회]");
		// 여러 건 조회
		List<Dept> deptList = deptDao.getDeptAllList();
		if(deptList != null) {
			deptPrint(deptList);
		}
		System.out.println("=============================");
		// 한건 조회
		System.out.println("[조건 조회]");
		Dept dept = deptDao.getDeptListByDeptno(10);
		if(dept != null) {
			deptPrint(dept);
		} else {
			System.out.println("부서가 없습니다.");
		}
		
		System.out.println("============================");
		System.out.println("[데이터 삽입]");
		int insertRow = deptDao.insertDept(new Dept(100,"IT","SEOUL"));
		if(insertRow > 0 ) {
			System.out.println("INSERT ROW : " + insertRow);
		}else {
			System.out.println("INSERT FAIL");
		}
		
		System.out.println("[방금전 INSERT 한 데이터 조회]");
		deptList = deptDao.getDeptAllList();
		
		if(deptList != null) {
			deptPrint(deptList);
		}
		
		
		
		System.out.println("[방금전 INSERT 데이터 수정]");
		int updateRow = deptDao.updateDept(new Dept(100,"IT_UP","SEOUL_UP"));
		if(updateRow > 0 ) {
			System.out.println("update ROW : " + updateRow);
		}else {
			System.out.println("update FAIL");
		}
		
		System.out.println("[방금전 update 한 데이터 조회]");
		deptList = deptDao.getDeptAllList();
		if(deptList != null) {
			deptPrint(deptList);
		}
		
		
		System.out.println("[방금전 Update한 데이터 삭제]");
		int deleteRow = deptDao.deleteDept(100);
		if(deleteRow > 0 ) {
			System.out.println("deleteRow ROW : " + deleteRow);
		}else {
			System.out.println("deleteRow FAIL");
		}
		
		System.out.println("[방금전 delete 한 데이터 조회]");
		deptList = deptDao.getDeptAllList();
		if(deptList != null) {
			deptPrint(deptList);
		}
	}
	
	// 여러건의 데이터 출력
	public static void deptPrint(List<Dept> list) {
		for(Dept dept : list) {
			System.out.println(dept.toString()); // toString 재정의 되어있음(@Data)
		}
	}
	
	// 1건의 데이터 출력 - 오버로딩
	public static void deptPrint(Dept dept) {
		System.out.println(dept.toString());
	}
	
}
