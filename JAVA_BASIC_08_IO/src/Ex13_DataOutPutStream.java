import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 보조 스트림
 DataOutPutStream
 DataInputStream
 
  장점 :
  	JAVA가 지원하는 8가지 타입 지원(타입 별로 write, read)가능
  	단, 조건은 DataOutPutStream 쓰면 반드시 DataInputStream
  	
  	성적.txt 파일(
  	100,99,60,50
  	50,55,30,100
  	
  	Line 단위로 read -> split -> 타입 변환 -> 정수형 배열에서 값 연산
  	
  	그래서 나온게 DataOutPutStream, DataInputStream
 */
public class Ex13_DataOutPutStream {
	public static void main(String[] args) {
		int[] score = {100, 60, 55, 95, 50};
		
		FileOutputStream fos = null; // 대상 파일 주스트림
		DataOutputStream dos = null;
		
		
		try {
			fos = new FileOutputStream("score.txt"); // 파일 생성
			dos = new DataOutputStream(fos); // 생성된 파일에 쓰기
			
			for(int i = 0;i < score.length;i++) {
				dos.writeInt(score[i]); // 파일에 정수 그대로 쓰겠다
				// 반드시 DataInputStream 통해서 읽어야 한다.
				
				// 채팅 프로그램 만들때
				//dos.writeUTF(null); -> 이거 많이 사용한다고 함
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dos.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}
