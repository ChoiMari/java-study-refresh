
/*
 파일 , 폴더(directory) 를 클래스 학습
 
 Tip) C# 파일 (File)  , 폴더(Directory)
 
  
 JAVA : File 클래스 ( 파일 작업(생성,수정,삭제) 또는 폴더 생성 수정 삭제) 하나의 클래스
 >> a.txt 생성 ,수정 , 삭제 , 정보 read  (File)
 >> Temp 폴더 생성, 수정 ,삭제 , 정보 read (File)
 
 경로
 절대경로 : C:\ , D:\  > D:\\Temp\\a.txt
 상대경로 : 현재 파일 중심으로 >  ../ >> /  ..

*/

import java.io.File;

public class Ex07_File {
	public static void main(String[] args) {
		String path = "D:\\Temp\\file.txt";
		
		File f = new File(path);
		
		//File 클래스는 다양한 정보 취득
		System.out.println("파일 존재 여부 확인 : " + f.exists());
		System.out.println("너 폴더니 : " + f.isDirectory());
		System.out.println("너 폴더니 : " + f.isFile());
		System.out.println("파일명 : " + f.getName()); //file.txt
		
		System.out.println("절대경로 : " + f.getAbsolutePath());
		//D.... file.txt
		System.out.println("파일 크기 : " + f.length() + "byte");
		System.out.println("부모경로 : "+ f.getParent());
	}
}
