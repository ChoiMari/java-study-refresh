import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.or.kosa.utils.ConnectionHelper;
import kr.or.kosa.utils.DBType;

public class Ex06_Oracle_PreparedStatement {
	public static void main(String[] args) {
		/*
		 insert into 테이블명(컬럼리스트)
		 values(?,?,?,...,?);
		 
		 update 테이블명 set 컬럼명 = 변경값
		 where절
		*/
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ConnectionHelper.getConnection(DBType.ORACLE);
			String sql = "update dmlemp set ename = ?, sal = ?, job = ?, deptno = ?"
					+ " where empno = ?";
			pstmt = conn.prepareStatement(sql); //미리 컴파일
			// 쉐어드풀에 미리 준비시킴
			
			pstmt.setString(1, "아무개"); // 1번째 ?
			pstmt.setInt(2, 5555);
			pstmt.setString(3, "IT");
			pstmt.setInt(4, 40);
			pstmt.setInt(5, 9999);//5번째 ?에 들어갈 값 설정
			
			int resultRow = pstmt.executeUpdate(); 
			// 파라미터 보내서 쿼리 실행
			
			if(resultRow > 0) {
				System.out.println("정상 수행하였습니다.");
				System.out.println("수행된 건수 : " + resultRow);
			}else {
				System.out.println("반영된 결과가 없습니다(조회된 데이터 없음)");
			}
			
		}catch(Exception e) {
			//pstmt.executeUpdate(); 문제 생기면 실행됨
			System.out.println(e.getMessage());
			
		}finally { // 자원 해제
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
	}
}
