/*
File 처리 대상 >> DISK >> 입출력 단위가 한 byte 씩

여러명 학생을 한명씩 목적에 보내는 것이 아니고
여러명이 탈 수 이쓴ㄴ 버스를 대여해서 한번 타 태워서 목적지 가서 ...

버퍼 : buffer
1. I/0 성능 개선(접근 횟수)
2. Line 단위 (엔터 기준) 한줄 

웹 서버가 페이지 클라이언트 전달 (Buffer 8kbyte ..반복적으로 ....)

buffer 보조
Buffered...input or output Stream

보조 > 주연 (Fileinput , Fileoutput)
Buffered 독자적인 생성 불가 ....

*/

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class Ex04_Stream_Buffer {

	public static void main(String[] args) {
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			 fos = new FileOutputStream("data.txt"); //data.txt 없으면 자동 파일 생성
			 bos = new BufferedOutputStream(fos); //내가 너를 도와서 ..
			 
			 for(int i = 0 ; i < 10 ; i++) {
				 bos.write('A');
			 }
			 //bos.flush(); //강제 출발
			 /*
			  JAVA  Buffer (8k , 8192byte)
			  1. Buffer 안에 내용이 채워지면 스스로 출발(버퍼을 비우는 작업)
			  2. 강제로 출발: flush()  ... close()해제 >>안에 flush()
			  3. 개발 close() 자원해제 >> 내부적으로  flush() 
			  */
			
		} catch (Exception e) {
			  System.out.println(e.getMessage());
		}finally {
			try {
				  bos.close();
				  fos.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

}
//참고 자료 : https://cafe.naver.com/msa2025/165 예외닫기 ..
