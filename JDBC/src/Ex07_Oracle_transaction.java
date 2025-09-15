/*
 트랜젝션
		create table trans_A(
    		num number,
    		name varchar2(20)
		);

		create table trans_B(
    		num number constraint pk_trans_B_num primary key,
    		name varchar2(20)
		);
	
	기본값 : JDBC >> DML >> **auto commit** >> 실반영
	
	옵션 : JDBC >> autocommit >> 변경(false) 
	>> 개발자 직접 (commit , rollback) 
	>> 주의 (반드시... commit , rollback 강제) -> 안하면 락걸려서 서버가 죽는다고
	
	은행업무 :   A계좌 B계좌 이체 
	쇼핑몰 포인트 : 게시글을 쓰면 회원에게 포인트 부여 (insert , update) 
	쇼핑몰 결제 처리 : 카드 ... 벤더 승인 ... 되면 카트 구매 ... (update , .....)
	
	OLTP 환경 (실시간 데이터 처리) > Back End (트랜잭션 구현 필수.....)
	
	2차 프로젝트에서 트랜젝션 필수 구현하기
	*/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.or.kosa.utils.ConnectionHelper;
import kr.or.kosa.utils.DBType;

public class Ex07_Oracle_transaction {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null; // 1개로 재활용도 되는데 헷갈린다고 2개 사용하심
		
		conn = ConnectionHelper.getConnection(DBType.ORACLE);
		String sql = "insert into trans_A(num, name) values(100,'A')";
		String sql2 = "insert into trans_B(num, name) values(100,'B')";
			
		// 두 개의 작업을 하나의 논리적인 단위로 묶어서 처리
		// 둘 다 성공 해야 commit;
		// 하나라도 실패하면 rollback;
		try {
			conn.setAutoCommit(false); //-> 하는 순간 rock걸림
			//-> commit; rollback;해야 락이 풀림
			// 오토커밋 false
			
			//begin
			pstmt = conn.prepareStatement(sql);
			pstmt2 = conn.prepareStatement(sql2);
			
			int resultRow = pstmt.executeUpdate();
			int resultRow2 = pstmt2.executeUpdate();
			
			//여기가 실행되었다는 것은 쿼리날림이 수행되었다는뜻(catch로 빠지지 않았으니까)
			conn.commit();
		//end
		}catch(Exception e) {
			// 둘 중에 하나라도 실패하면 (롤백처리해야함)
			// 예외가 발생했다는 것은 하나라도 실패했다는 뜻
			System.out.println("[DB예외] : 모두 롤백 강제하는 코드 필요" + e.getMessage());
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(pstmt2);
			ConnectionHelper.close(conn);
		}	
	}
}