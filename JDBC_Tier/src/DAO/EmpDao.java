package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DTO.Dept;
import DTO.Emp;
import Utils.ConnectionHelper;
import Utils.DBType;
/*
 날짜 변환 : LocalDate 또는 LocalDateTime을 이용 
 LocalDate : 날짜만 표현(년, 월, 일), 시간 정보 없음
 LocalDateTime : 날짜 + 시간을 같이 표현
 
 JDBC에서 LocalDate 저장(java -> DB), insert할 때
 	pstmt.setDate(1, java.sql.Date.valueOf(localDate));
 DB에서 LocalDate로 변환(ResultSet 사용) select
 	rs.getDate("hiredate").toLocalDate();
 
 JDBC에서 LocalDateTime 저장(java -> DB), insert할 때
 	pstmt.setTimestamp(1, java.sql.Timestamp.valueOf(localDateTime));
 DB에서 LocalDateTime로 변환(ResultSet 사용) select
 	rs.getDate("hiredate").toLocalDateTime();
 */
public class EmpDao {
	
	// 전체 조회
	public List<Emp> getEmpAllList(){
		List<Emp> empList = new ArrayList<Emp>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionHelper.getConnection(DBType.ORACLE);
			String sql = "select empno, ename, job, mgr, hiredate, sal, comm, deptno from emp";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					empList.add(Emp.builder()
					.empno(rs.getInt("empno"))
					.ename(rs.getString("ename"))
					.job(rs.getString("job"))
					.mgr(rs.getInt("mgr"))
					.hiredate(rs.getTimestamp("hiredate").toLocalDateTime())
					.sal(rs.getInt("sal"))
					.comm(rs.getInt("comm"))
					.deptno(rs.getInt("deptno")).build());
				}while(rs.next());
			}else {
				System.out.println("조회된 결과가 없습니다.");
			}
		}catch(Exception e) {
			System.out.println("[select DB 예외] " + e.getMessage());
		}finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		return empList;
	}
	
	//조건조회
	public Emp getEmpByEmpno(Integer empno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Emp emp = null;
		try {
			conn = ConnectionHelper.getConnection(DBType.ORACLE);
			String sql = "select empno, ename, job, mgr, hiredate, sal, comm, deptno from emp"
					+ " where empno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				emp = Emp.builder()
						.empno(rs.getInt("empno"))
						.ename(rs.getString("ename"))
						.job(rs.getString("job"))
						.mgr(rs.getInt("mgr"))
						.hiredate(rs.getTimestamp("hiredate").toLocalDateTime())
						.sal(rs.getInt("sal"))
						.comm(rs.getInt("comm"))
						.deptno(rs.getInt("deptno")).build();
			}else {
				System.out.println("조회된 결과가 없습니다.");
			}
			
		}catch(Exception e) {
			System.out.println("[select DB 예외] " + e.getMessage());
		}finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		
		return emp;
	}
	
	public int insertEmp(Emp emp) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int resultRow = 0;
		try {
			conn = ConnectionHelper.getConnection(DBType.ORACLE);
			String sql = "insert into emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, emp.getEmpno());
			pstmt.setString(2, emp.getEname());
			pstmt.setString(3, emp.getJob());
			pstmt.setInt(4, emp.getMgr());
			pstmt.setTimestamp(5, Timestamp.valueOf(emp.getHiredate()));
			pstmt.setInt(6, emp.getSal());
			pstmt.setInt(7, emp.getComm());
			pstmt.setInt(8, emp.getDeptno());
			resultRow = pstmt.executeUpdate();
			
			if(resultRow > 0) {
				System.out.println("정상 수행 건수: " + resultRow);
			} else {
				System.out.println("수행되지 않았습니다.");
			}
		}catch(Exception e) {
			System.out.println("[insert DB 예외] " + e.getMessage());
		}finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		return resultRow;
	}
	
	public int updateEmp(Emp emp) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = ConnectionHelper.getConnection(DBType.ORACLE);
			String sql = "update emp set ename = ?, job = ?, sal = ?, hiredate = ? where empno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getEname());
			pstmt.setString(2, emp.getJob());
			pstmt.setInt(3, emp.getSal());
			pstmt.setTimestamp(4, Timestamp.valueOf(emp.getHiredate()));
			pstmt.setInt(5, emp.getEmpno());
		}catch(Exception e) {
			System.out.println("[update DB 예외] " + e.getMessage());
		}finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		return 0;
	}
	
	public int deleteEmp(int empno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int resultRow = 0;
		String sql = "delete from emp where empno = ?";
		
		try {
			conn = ConnectionHelper.getConnection(DBType.ORACLE);
			pstmt = conn.prepareStatement(sql); // 쿼리 쉐어드 풀에 준비시킴
			pstmt.setInt(1, empno); // 파라미터 보냄
			resultRow = pstmt.executeUpdate(); // 쿼리 실행
			
			if(resultRow > 0) {
				System.out.println("정상 수행 건수 : " + resultRow);
			}else {
				System.out.println("수행되지 않았습니다.");
			}
			
		}catch(Exception e) {
			System.out.println("[delete DB 예외] " + e.getMessage());
		}finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		return resultRow;
	}
	
	/*
	 * 조인 결과를 자바 객체에 어떻게 담을까?
	 * 1. DTO전용 클래스로 매핑 -> 가장 많이 사용함
	 * 	ex) public class EmpDeptDto{
	 * 			private String ename;
	 * 			private Integer deptno;
	 * 			private String dname;
	 * 		} 
	 * 2. Map구조 
	 * 	ex) List<Map<String, Object>>
	 * 		key : 컬럼명
	 * 		value : 값
	 * 		 Map<String, Object> row = new HashMap<>();
	 * 		 row.put("ename", rs.getString("ename"));
	 *		 row.put("deptno", rs.getInt("deptno"));
	 * 		 row.put("dname", rs.getString("dname"));
	 * 		 list.add(row);
	 * 
	 */
	
	// 이 방법은 문제의 소지가 있다
	// 이유 : Emp객체로 key를 쓰면 같은 Emp객체가 중복될 경우
	// value에 들어가는 Dept객체가 덮어써진다.(이전에 저장된 Dept객체는 사라짐)
	// List<조인DTOclass만들어서>로 처리하는게 무난!
	public Map<Emp, Dept> searchEmp(String keyword){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<Emp, Dept> list = new HashMap<>();
		try {
			conn = ConnectionHelper.getConnection(DBType.ORACLE);
			
			//rs.getString("e.ename") 이렇게 쓰면 에러난다..
			// alias를 써야함!!!
			String sql = "select e.ename as ename, e.deptno as deptno, d.dname as dname "
					+ "from emp e join dept d "
					+ "on e.deptno = d.deptno "
					+ "where e.ename like ?"; //-> 분석 순서상 select문에 쓴 alias는 where조건쓸때는 없음
			pstmt = conn.prepareStatement(sql); // DB서버의 쉐어드 풀에 sql 준비시킴
			pstmt.setString(1, "%" + keyword + "%"); // 파라미터 보냄
			rs = pstmt.executeQuery(); // 쿼리 실행
			
			if(rs.next()) {
				do {
					list.put(Emp.builder()
							.ename(rs.getString("ename")) //alias로 가져옴
							.deptno(rs.getInt("deptno"))
							.build(), 
							Dept.builder()
							.dname(rs.getString("dname"))
							.build());
				}while(rs.next());
			}else {
				System.out.println("조회된 결과가 없습니다.");
			}
		}catch(Exception e) {
			System.out.println("[select DB 예외] " + e.getMessage());
		}finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		
		return list;
	}
}
