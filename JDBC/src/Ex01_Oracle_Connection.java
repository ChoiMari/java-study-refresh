/*

JDBC

1. Java 언어(APP)를 통해서 Oracle(소프트웨어) 연결해서 CRUD작업
2. Java App : Oracle , My-sql , MS-sql 등등 연결하고 작업(CRUD)
		2.1 각각의 제품에 맞는 드라이버를 가지고 있어야 합니다
		CASE 1: 삼성 노트북 >> HP 프린터 연결 >> HP프린터 사이트에서 드라이버 다운 >> 삼성 설치 
		CASE 2: HP프린터 제조 회사는 ... 삼성, LG 회사마다 적용할 수 있는 드라이버를 별도 제작

각 언어에 맞는 드라이버를 다운로드 해서 제품에 맞게 설치 .... 접속 ...
Oracle (C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib)
Mysql (https://dev.mysql.com/downloads/connector/j/)

강사PC :C:\MSA_EDU\DataBase\ConnectUtils\ojdbc8.jar

3. 드라이버를 참조 (현재 프로젝트에서 사용) >> Java Project -> 속성 
-> build path -> jar 파일 추가 
	3.1 드라이버 사용 준비 완료 >> 메모리에 load 사용 ....

3.2 Class.forName("oracle.jdbc.OracleDriver")..... new 객체 생성과 같음 ....
-> JDK버전업 되면서 안해도 동작한다고 함

4. JAVA CODE (CRUD) >> JDBC API 제공 받는다
4.1 import java.sql.* >> interface , class 제공
	import java.sql.*밑에 자원을 넣어놓음(인터페이스와 클래스 제공)

4.2 개발자는 interface 를 통해서 표준화된 DB 작업 수행
	POINT) why interface형태로 제공 >> JDBC API >> Oracle, Mysql , ....)

	//OracleConnection >> Connection 구현
	//MysqlConnection >> Connection 구현 
	//다형성 Connection 부모타입 : 유연한 프로그래밍 작성 
	//연동하고 싶다면 JDBC 인터페이스가 제공하는 Connection를 구현해야한다.
	

>>다형성을 구현 (인터페이스 활용)
import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement 등등 

5. 작업순서
	5.1 DB연결 -> 명령생성 -> 명령실행 -> 처리 -> 자원해제
	-> 이것도 가비지 컬렉터가 관리 못함. 네트워크 작업
	-> 명시적으로 자원해제해야한다

5.1 명령 : DDL  (create , alter , drop)
		  CRUD (insert , select , update , delete)

실행 : 쿼리문을 DB서버에게 전달 
처리 : 결과를 받아서 화면 출력 , 또는 다른 프로그램에 전달 등등
자원해제 : 연결해제 
*/


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ex01_Oracle_Connection {

	public static void main(String[] args) throws Exception{ //throws Exception으로 강사님은 던졌지만(별로 안좋은 방법이라고)
		// DB연결 -> 드라이버가 메모리에 올라와있어야함(로딩)
		// 제품에 맞는 드라이버가 로딩되어야함

		//new 객체 생성 코드 없이(메모리 로딩)
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","KOSA","1004");
		// OracleConnection객체가 Connection을 구현
		// MySqlConnection객체가 Connection을 구현
		// 부모타입으로 인터페이스를 통해서 다형성 적용
		System.out.println("DB연결 : " + conn.isClosed()); //확인
		//닫혔니? false가 나오면 연결됨
		
		// 명령객체 얻어오기(CRUD 작업에 필요)
		Statement stmt = conn.createStatement(); // 인터페이스로 import하기
		// 명령 만들기
		String sql = "select empno, ename, sal from emp";
		// 명령 실행
		ResultSet rs = stmt.executeQuery(sql); //DB에 보냄
		//집합의 주소를 ResultSet타입으로 받음
		// 쿼리를 날림 -> 네트워크 -> DB서버 -> 쿼리 실행 -> 결과
		//-> 결과에 접근 사용 할 수 있는 객체를 리턴 받음
		// 결과집합은 DB서버에서 만들어져서 읽어옴 //-> DB연결이 끊어지면 데이터를 가져오지 못함
		//-> 실시간 데이터 반영을 위해서 OLTP환경은(안그러면 동기화가 어렵다) DB에서 만들어지는걸 가져온다
		// 연결이 지속되는 한 데이터를 읽어올 수 있음
		// 연결 기반 작업
		
//		while(rs.next()) { // 데이터 있으면 실행
//			System.out.println(rs.getInt("empno") + " / "
//					+ rs.getString("ename") + " / " 
//					+ rs.getInt("sal"));
//		}
		
		while(rs.next()) { // 데이터 있으면 실행
		System.out.println(rs.getInt(1) + " / " //내부적으로 컬럼에 인덱스를 붙여놨다고(1번부터)
				+ rs.getString(2) + " / " 
				+ rs.getInt(3));
	}
		
		// 자원 해제
		stmt.close();
		rs.close();
		conn.close();
		
		System.out.println("DB연결 : " + conn.isClosed()); 
		//닫혔니? true나와야 함
	}
}
