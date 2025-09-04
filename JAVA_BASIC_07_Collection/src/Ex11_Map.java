import java.util.HashMap;
import java.util.Scanner;

public class Ex11_Map {
	public static void main(String[] args) {
		/*
		 Map 사용하는 데이터 집합
		 	활용 : 지역변호 , 우편번호 , 회원가입(id,pwd)
		 	  		카카오톡 대화방 key가 방번호, value(사용자는 List -> ArrayList)
		 */
		HashMap loginmap = new HashMap(); //메모리에는 회원id,pwd저장
		loginmap.put("kim", "kim1004");
		loginmap.put("scott", "tiger");
		loginmap.put("lee", "kim1004");
		/*
		 우리 시스템은 회원가입한 회원의  id , pwd 를 
		 (휘발성(프로그램 종료 시 사라짐) 메모리에)관리하고 있다
		 로그인시 아이디와 비번을 확인해서 회원이라면 사이트 접속 가능
		 
		  id(0) , pwd(0) >> 회원님 방가           1
		  id(0) , pwd(x) >> 비밀번호 입력 추가    2 
		  
		  id(x) , pwd(0) >> 회원가입 유도         3 
		  id(x) , pwd(x) >> 회원가입 유도         3 
		  
		  
		  사용자로 부터 id , pwd 입력 받으세요
		  id는 공백제거, 소문자 변환 String 변수에 담아서 사용
		  pwd 공백제거
		  id(0) , pwd(0) >> 회원님 방가 방가 출력하고 while 탈출     
		  id(0) , pwd(x) >> 비밀번호확인 출력만
		  
		  id(x) , pwd(0) >> id 맞지 않습니다 ,재입력하세요
		  id(x) , pwd(x) >> id 맞지 않습니다 ,재입력하세요
		 */
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("id ,pwd 입력해 주세요");
			
			System.out.println("ID");
			String id = sc.nextLine().trim().toLowerCase();
			
			System.out.println("PWD");
			String pwd = sc.nextLine().trim();
			
			if(!loginmap.containsKey(id)) {
				//id(x)
				System.out.println("id 맞지 않아요 ...재입력하세요");
			}else {
				//id(0)
				if(loginmap.get(id).equals(pwd)) {
					System.out.println("회원님 방가방가");
					break;
				}else {
					System.out.println("비밀번호 확인하세요");
				}
				
			}
			
		}
	}
}
