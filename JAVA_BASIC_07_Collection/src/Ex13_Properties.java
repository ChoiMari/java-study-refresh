/*
  Map 인터페이스 구현한 클래스
  특수한 목적 : <String, String> : key, value 타입이 고정(String)
  
  사용목적
  	1. App 전체에 사용되는 자원 관리 목적
  	1.1 관리자 이메일 주소, 파일 업로드 경로 -> 미리 만들어 놓고 사용
  	1.2 web.xml에 properties로 만들어 놓음 -> 여러개의 페이지에서 사용함
  	
  	2. 환경변수(전역) 
  	사례) 프로그램의 버전
  		  공통 변수
  	
 */

import java.util.Properties;

public class Ex13_Properties {

	public static void main(String[] args) {
		Properties prop = new Properties();
		//<String, String>로 이미 세팅되어 있어서 제네릭이 필요없다
		prop.setProperty("admin","kosa@or.kr"); //관리자 이메일 :변경시 값만 바꾸면 됨
		prop.setProperty("version", "1.x.x.x");
		prop.setProperty("downpath", "C:\\Temp\\images");
		System.out.println("여러개의 페이지 사용 : " + prop.getProperty("admin"));
		System.out.println(prop.getProperty("downpath"));
	}
}
