
/*
1차 
memory (Array , Collection) > 휘발성
memo.txt (파일 write) > 규칙 > \n > 데이터 한건 > 불편해요 ...

2차
DB > Table > row,column


Byte 데이터를 read/write 대상이 > file (a.txt, memo.txt)

FileInputStream
FileOutputStream

이미지 , 엑셀 > read ,write

File > 1.txt , 2.txt 

I/O 관리되지 않는 자원 (가비터 컬렉터 대상이 아니다)
직접 자원을 관리 (엑셀 .. 데이터 작업 , 똑같은 파일 ... 편집 .. 읽기 전용)
>> 내가 작업을 완료하면 ... 그 자원에 대해서 해제 (close())
>> 고슬링 ... 예외처리 강제 .... I/O 강제 되는 예외처리 .... try ~ catch...

*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex02_FileStream {
	public static void main(String[] args) {
		FileInputStream fs = null;
		FileOutputStream fos = null;
		
		String path = "D:\\Temp\\a.txt";
		
		try {
				fs = new FileInputStream(path);
				fos = new FileOutputStream("D:\\Temp\\new.txt");
				//현재  Temp 폴더안에 new.txt
				/*
				FileOutputStream 
				1. write 파일이 존재하지 않으면 > 자동 파일 생성 > Create 
				
				2. 	fos = new FileOutputStream("D:\\Temp\\new.txt",false);
				    false => overwrite
				
				2. 	fos = new FileOutputStream("D:\\Temp\\new.txt",true);
				    true > append
				*/
				int data=0;
				while((data = fs.read()) != -1) {
					System.out.println("정수 : " + data + (char)data);
					fos.write(data); // 인코딩 문자 write ..
				}
				
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//정상 종료 , 비정상 종료
			//강제 실행 블럭
			//함수 return 만나도 여기는 강제실행
			 try {
				fs.close(); //자원해제
				fos.close(); // 자원해제
			 } catch (IOException e) {
				e.printStackTrace();
			 }
		}
		
	}
}
