/*
PreparedStatement란?

PreparedStatement는 미리 SQL 구문을 컴파일해두고, 실행 시 값만 바인딩해서 사용하는 방식의 Statement입니다.

일반 Statement는 실행할 때마다 SQL을 파싱(Parsing)하고 컴파일해야 하지만, PreparedStatement는 
처음에 한 번만 컴파일한 뒤 재사용할 수 있습니다.
SQL 사전 컴파일
미리 컴파일해두기 때문에 여러 번 실행할 때 성능이 더 좋습니다.
특히 반복적으로 같은 SQL을 다른 값과 함께 실행해야 할 때 효율적입니다.


SQL Injection 방지
? (placeholder)에 값을 바인딩하면 JDBC가 내부적으로 escape 처리를 해주기 때문에 
SQL Injection 공격을 예방할 수 있습니다.
예: "SELECT * FROM users WHERE id = ?" → ? 자리에 값만 안전하게 치환.

가독성 & 유지보수성
SQL과 파라미터를 분리해 작성하므로 코드가 깔끔해지고, 유지보수하기가 쉽습니다. 
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.or.kosa.utils.ConnectionHelper;
import kr.or.kosa.utils.DBType;

public class Ex05_Oracle_PreparedStatement {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionHelper.getConnection(DBType.ORACLE);
			// 실행할 sql문
			String sql = "select empno, ename from emp where deptno = ?";
			
			//DB서버에 쿼리 준비
			pstmt = conn.prepareStatement(sql); 
			// 문장으로 보내서 DB서버의 쉐어드 풀에 가져다 놓고 준비시킴
			
			pstmt.setInt(1, 10); // 1번째 ?에 들어갈 값 10으로 설정
			//?에 들어갈 타입 int(number)
			
			rs = pstmt.executeQuery(); // 미리 보내놓은 sql 실행
			//파라미터만 가지고 DB로 감
			
			//공식같은 로직
			/*	select 조회 시 나오는 경우?
			 	1. 없는 경우
			 	2. 1건인 경우
			 	3. 여러건인 경우
			 */
			if(rs.next()) { // 실행되면 1건 또는 여러건
				do {
					System.out.println(rs.getInt(1) + " / " + rs.getString(2));
				}while(rs.next()); // 데이터 없을 때까지 돌음 : 최소 1번 실행
			}else { // 조회된 데이터가 아예 없는 경우
				
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally { // 리소스 정리
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
	}
}
