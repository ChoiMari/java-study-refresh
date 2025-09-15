/*
 1. MariaDB 사용
1.1 다운 설치

2. SampleDB 생성
2.1 Emp 만들고
2.2 데이터 넣고

3. JDBC 사용해서
3.2 select 해서 조회  
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import kr.or.kosa.utils.ConnectionHelper;
import kr.or.kosa.utils.DBType;

public class Ex08_MariaDB_Practice {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		conn = ConnectionHelper.getConnection(DBType.MARIADB);
		try {
			String sql = "select emp_id, first_name, salary from emp";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while(rs.next()) { // 데이터 있으면 실행
				System.out.println(rs.getInt(1) + " / " //내부적으로 컬럼에 인덱스를 붙여놨다고(1번부터)
						+ rs.getString(2) + " / " 
						+ rs.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
