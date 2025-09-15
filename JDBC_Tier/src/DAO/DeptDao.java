package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DTO.Dept;
import Utils.ConnectionHelper;
import Utils.DBType;

// 목표 : 메서드 5개 생성 할 수 있다.
// CRUD
public class DeptDao {
	/* 이거 못하면 망신이라고 함
	  	1. select deptno, dname, loc from dept
	  	2. select deptno, dname, loc from dept where deptno = ?
	  	3. insert into dept(deptno, dname, loc) values(?, ?, ?)
	  	4. update dept set dname = ? , loc = ? where deptno = ?
	  	5. delete from dept where deptno = ? 
	 */
	
	//전체 조회(여러건 결과 행 나옴) -> List<Dept> 담아서 처리(generic)
	public List<Dept> getDeptAllList(){
		List<Dept> deptList = new ArrayList<Dept>();
		//deptList.add(new Dept());
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionHelper.getConnection(DBType.ORACLE);
			String sql = "select deptno, dname, loc from dept";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			// 버퍼캐시 메모리 접근 할 수 있는 주소 리턴?
			if(rs.next()) {
				do {
					Dept dept = new Dept(); // -> 기본값으로 초기화됨
					//-> 빌더 쓰는게 효율적(오버로딩 생성자나)
					dept.setDeptno(rs.getInt("deptno")); //setter로 데이터 주입
					dept.setDname(rs.getString("dname"));
					dept.setLoc(rs.getString("loc"));
					deptList.add(dept); //리스트에 추가함
					
					
				}while(rs.next());
			}else {
				System.out.println("조회된 결과가 없습니다.");
			}
		}catch(Exception e) {
			e.getMessage();
		}finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		
		return deptList;
	}
	
	// 1건 조회
	public Dept getDeptListByDeptno(int deptno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Dept dept = null;
		
		try {
			conn = ConnectionHelper.getConnection(DBType.ORACLE);
			String sql = "select deptno, dname, loc from dept where deptno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno); // ?에 들어갈 값(호출 시 아규먼트로 받음)
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // 있으면 실행됨
				dept = new Dept();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
			}else {
				System.out.println("조회된 결과가 없습니다.");
			}
			
		} catch(Exception e) {
			e.getMessage();
		}finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		
		return dept;
	}
	
	//update
	public int updateDept(Dept dept) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int resultRow = 0;
		try {
			conn = ConnectionHelper.getConnection(DBType.ORACLE);
			String sql = "update dept set dname = ? , loc = ? where deptno = ?";			
			pstmt = conn.prepareStatement(sql); // 준비
			//파라미터 설정 ?에 들어갈 값 설정
			pstmt.setString(1, dept.getDname());
			pstmt.setString(2, dept.getLoc());
			pstmt.setInt(3, dept.getDeptno());
			resultRow = pstmt.executeUpdate(); //-> 파라미터 보내서 쿼리 실행
			if(resultRow > 0) {
				System.out.println("정상 수행 건수: " + resultRow);
			}else {
				System.out.println("수행된 행이 없습니다.");
			}
			
		}catch(Exception e) {
			System.out.println("[DB예외] " + e.getMessage());
		}finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		
		return resultRow;
	}
	
	//insert
	public int insertDept(Dept dept) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int resultRow = 0;
		try {
			conn = ConnectionHelper.getConnection(DBType.ORACLE);
			String sql = "insert into dept(deptno, dname, loc) values(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dept.getDeptno());
			pstmt.setString(2, dept.getDname());
			pstmt.setString(3, dept.getLoc());
			resultRow = pstmt.executeUpdate();
			if(resultRow > 0) {
				System.out.println("[insert] 정상 수행 건수 : " + resultRow);
			}else {
				System.out.println("[insert] 수행되지 않았습니다.");
			}
		}catch(Exception e) {
			System.out.println("[DB예외] : " + e.getMessage());
		}
		
		return resultRow;
	}
	
	//delete
	public int deleteDept(int deptno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int resultRow = 0;
		
		try {
			conn = ConnectionHelper.getConnection(DBType.ORACLE);
			String sql = "delete from dept where deptno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			resultRow = pstmt.executeUpdate();
			
			if(resultRow > 0) {
				System.out.println("정상 수행 건수 : " + resultRow);
			}else {
				System.out.println("[delete] 수행되지 않았습니다.");
			}
		}catch(Exception e) {
			System.out.println("[DB예외] : " + e.getMessage());
		}finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		
		return resultRow;
	}
	
	
}
