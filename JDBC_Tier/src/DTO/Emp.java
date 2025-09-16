package DTO;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter @EqualsAndHashCode @AllArgsConstructor @NoArgsConstructor @Builder
@ToString
public class Emp {
	private Integer empno;
	private String ename;
	private String job;
	private Integer mgr;
	private LocalDateTime hiredate;
	private Integer sal;
	private Integer comm;
	private Integer deptno;
}
