/*
문자 기반의 데이터 다루기 (char > char[])
String 클래스 > 내부적으로 char[] 관리

문자 추상 클래스
Reader , writer 추상클래스 >> Stream 붙어 (Byte)  >> Stream (x) 문자다루기

파일
FileReader , FileWriter


*/

import java.io.FileReader;
import java.io.FileWriter;

public class Ex05_Reader_Writer {
	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		
		try {
			
			fr = new FileReader("Ex01_Stream.java"); //read
			fw = new FileWriter("copy_Ex01.txt"); //경로에 파일이 없으면 create 한다
			
			int data=0;
			while((data =fr.read()) != -1) {
				System.out.println(data);
				
				//엔터 , 탭 , 빈문자는 파일에 쓰지 않겠다
				if(data != '\n' && data != '\r' && data != '\t' && data != ' ')
				{
					fw.write(data);
				}	
				
				//압축버전
				//https://jquery.com/download/ 배포버전(압축버전) 개발버전
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				 fw.close();
				 fr.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

}
