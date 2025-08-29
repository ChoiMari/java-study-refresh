/*
//주민번호 : 뒷번호 첫자리 : 1,3 남자 , 2,4 여자 라고 출력 ... 하는 문제
//main 함수 Scanner  사용 주민번호 입력받고
//앞:6자리     뒷:7자리

//입력값(예시) : 123456-1234567 

//static 3개 메서드 만들기 
//1. 자리수 체크 (기능)함수 (14자리면 ok)  return true , false 
//2. 뒷번호 첫번째 자리값 1~4까지의 값만 허용 기능함수  return true, false
//3. 뒷번호 첫번째 자리값을 가지고 1,3 남자 , 2,4 여자 출력 기능함수  void  출력

최대한 간략하게 짜기
*/
import java.util.Scanner;
public class Ex07_String_Total_Quize {
	//1. 자리수 체크 (기능)함수 (14자리면 ok)  return true , false 
	static boolean check(String jumin) {
		return (jumin.length() == 14) ? true : false;
	}
	
	//2. 뒷번호 첫번째 자리값 1~4까지의 값만 허용 기능함수  return true, false
	static boolean lastCheck(String jumin) {
		if(jumin.contains("-")) { // -이 포함하는지 확인
			int genderNum = Integer.parseInt(jumin.substring(jumin.indexOf("-") + 1, jumin.indexOf("-") + 2));
			
			if(genderNum == 1 || genderNum == 2 || genderNum == 3 || genderNum == 4) {
				return true;
			}
		}
		return false;
	}
	
	//3. 뒷번호 첫번째 자리값을 가지고 1,3 남자 , 2,4 여자 출력 기능함수  void  출력
	static void lastCheckGender(String jumin) {
		int genderNum = Integer.parseInt(jumin.substring(jumin.indexOf("-") + 1, jumin.indexOf("-") + 2));
		if(genderNum == 1 || genderNum == 3) {
			System.out.println("남성입니다.");
			return;
		}
		System.out.println("여성입니다.");
	}
	
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) { //자동으로 닫아줌
			String strInput = "";
			do {
				System.out.print("주민번호 입력 : ");			
				strInput = sc.nextLine();
			}while(!check(strInput) || !lastCheck(strInput)); //2가지 조건을 만족 하지 않으면 계속 입력 받기			
			lastCheckGender(strInput);
		}catch(Exception ex) {
			System.out.println("[입력 오류] 14자리(- 포함)의 정수로 이루어진 주민번호를 입력해주세요.");
		}

	}
}
