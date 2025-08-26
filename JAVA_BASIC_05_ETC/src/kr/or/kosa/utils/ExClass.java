package kr.or.kosa.utils;

import java.io.IOException;

/*
 설계도
 
 A 팀장
 B 팀원
 
 A팀장이 B팀원에게 클래스를 한 개 만들어 줄테니
 사용 시 예외 처리를 하고 써라.
 
 B 팀원이 그런데, 예외처리를 하지 않아도 코드는 문제없음
 하지 않을까봐, 불신 (강제성 부여 -> throws)
 
 A팀장 예외 강제 함 -> throws
 */
public class ExClass{
	
	public ExClass(String path) throws IOException, NullPointerException {
		// 예외가 우려스러워서 호출부에서 예외처리하라고 강제성을 부여함
		System.out.println("path : " + path);
	}
	
}
