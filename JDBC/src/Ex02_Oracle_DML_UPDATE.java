/*
 JDBC 
 1. select
 	-> 결과 집합을 만듬(ResultSet) -> 이걸 읽어야(read)
 2. insert, update, delete
 	-> 결과 집합 안 만듬(ResultSet 필요 X)
 	-> 반영된 결과 리턴받음 -> 반영된 행의 수
 	-> 반영되지 않았으면 0리턴
 	-> 리턴값이 0보다 큰지 확인 필요(반영되면 0이상)
 	
 자바코드(CRUD) 
 Today Point
 1. Oracle DML(sqlplus 또는 Sqldeveloper) 작업을 하면 반드시 Commit, rollback 강제
 2. JDBC API를 통해서 작업하면 insert, update, delete 수행하면 
 	무조건 auto commit; -> 실 반영됨
 3. JDBC API 옵션이 있음, auto commit 안하겠다는 옵션
 	-> 개발자가 명시적으로 코드에 commit과 rollback을 명시
 	-> 트랜젝션 동반 업무에 사용
 begin
 	A계좌 인출(update작업)
 	B계좌 이체(update작업)
 end
 하나의 논리적인 작업 단위로 묶음(트랜잭션) : 둘 다 성공해야 commit, 하나라도 실패하면 rollback
 
 주의)
 commit과 rollback을 명시하지 않으면 DB서버 rock걸림(커밋 또는 롤백 할때까지 멈춤)
 
 */


/*
 실습 데이터 만듬(DB에서) 
 create table dmlemp
as
    select * from emp;
    
	--단점 : 제약조건은 복제가 안되서.. 따로 적용필요
	alter table dmlemp
	add constraint pk_dmlemp_empno primary key(empno);
	
	select * from dmlemp;
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex02_Oracle_DML_UPDATE {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// 드라이버 로딩 하는 코드는 생략함
			
			// 연결 객체 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","KOSA","1004");
			
			// 명령 객체 생성
			stmt = conn.createStatement();
			
			//parameter 받기
			int deptno = 0;
			
			Scanner sc = new Scanner(System.in);
			System.out.print("부서번호 입력 : ");
			deptno = Integer.parseInt(sc.nextLine());
			
			//update 테이블명 set 컬럼명 = 변경값 where 조건
			//String sql = "update dmleml set sal = 0 where deptno = ?";
			
			String sql = "update dmlemp set sal = 0 where deptno =" + deptno;
			//-> 무식한 코드
			// 미리 컴파일 시켜서 파라미터로 보낼 수 있는 성능상 좋은 preparedStatement로 바꿔야함
			
			int resultRow = stmt.executeUpdate(sql); 
			// 실반영 auto commit;
			// 문제가 생긴다면 여기서 예외 처리해야함
			
			
			if(resultRow > 0) {
				System.out.println("반영된 행의 수 : " + resultRow);
			}else {
				System.out.println("반영된 행이 없음");
			}
			
		}catch(Exception e) {
			// stmt.executeUpdate(sql); 여기서 발생
			System.out.println("[DB서버 오류] SQL예외 발생" + e.getMessage());
		}finally { // 자원 해제
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
}
