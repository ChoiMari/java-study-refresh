package DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 DTO(VO) : 오라클 DB에 있는 Detp 테이블과 1:1 매핑됨
 
 new Dept();
 -> select deptno, dname, loc from dept where deptno = 10; -> 1건의 데이터
 
 List<Dept> list = new ArrayList<>();
 	-> 한 건 이상의 데이터
 -> select deptno, dname, loc from dept;
 */
@Data @AllArgsConstructor @NoArgsConstructor 
public class Dept {
	private int deptno;
	private String dname;
	private String loc;
}
