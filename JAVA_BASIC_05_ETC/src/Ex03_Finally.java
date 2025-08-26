/*
 try{
 
 }catch(예외타입 e){
 
 }finally{
 	// 항상 실행됨(return문을 만나도, 반드시 실행)
 	// 문제가 있든 없든, 강제적 실행 블록
 	// 무조건 실행되야 하는 코드를 여기에 작성함
 } 
 
 게임 CD를 사서
 1. 설치파일이 복사가 됨. C드라이브의 \Temp폴더에 복사됨
 2. 복사한 파일로 프로그램이 설치됨
 3. 정상 설치가 되는 경우가 있고(-> 그럼 c:\Temp 폴더 내용 삭제하고 싶음)
 	비 정상 설치된 경우에도 c:\Temp 폴더 내용 삭제하고 싶다
 	
 	-> 예외 발생 여부와 상관없이 강제로 실행되는 블록이 필요하다
 	그럴 때, finally블록을 사용
 */

import java.io.IOException;

public class Ex03_Finally {
	static void copyFiles() {
		System.out.println("copy files");
	}
	static void startInstall() {
		System.out.println("install...");
	}
	static void fileDelete() {
		System.out.println("file delete...");
	}
	
	/*
	  	예외가 발생하려면(0/0, 인덱스 범위 초과 등..)
	  	예외 상황이 필요한데, 
	  	개발자가 예외를 강제로 던질 수 있다
	  	개발자가 필요에 의해서 예외 상황을 만들 수 있음
	  	
	  	사용자 정의 예외 처리 : throw 사용
	  	throw new IOException
	 */
	public static void main(String[] args) {
//		copyFiles();
//		startInstall();
//		fileDelete();
		
		try {
			copyFiles();
			startInstall();
			
			throw new IOException("[예외] Install 도중 문제 발생");
			// 호출부로 예외 던짐
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			// 강제 실행 블록
			// 정상이든 비정상이든 무조건 실행할 코드 작성
			// 메서드의 return과 상관없이 무조건 실행됨
			// (try,catch문에서) return을 만나도 무조건 실행
			fileDelete();
		}
	}
}
