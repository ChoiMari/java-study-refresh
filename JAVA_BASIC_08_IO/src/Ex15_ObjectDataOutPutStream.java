/*
 직렬화
  파일 기반으로
  파일에 데이터를 직렬화해서 write 할 수 있다.
  파일에 데이터를 읽을 때도(read) 역직렬화를 통해서 read 할 수 있다.
  
 객체 통신
 	객체(Tv, Tank 등) -> 프로세스, 네트워크, 파일 간 통신을 위해서
 	직렬화하고 역직렬화의 과정이 필요하다.
 	
 	직렬화가 무얼까? 객체를 분해해서 줄을 세워 보내는 과정
 	역직렬화 ? 객체를 다시 조립하는 과정
 	
 	동기화는 공유자원에 대한 접근
 	
 	모든 자원은 직렬화가 가능한지? NO
 		직렬화가 가능한 제품을 설계하려면 
 		클래스에 implements Serializable를 해야한다
 */

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import kr.or.kosa.UserInfo;


public class Ex15_ObjectDataOutPutStream {
	public static void main(String[] args) {
		String fileName = "UserData.txt";
		//파일에 쓴다(write) 객체를 직렬화해서
		
		FileOutputStream fos = null; // 주 스트림
		BufferedOutputStream bos = null; // 보조 스트림
		ObjectOutputStream out = null; // 직렬화
		
		try {
			fos = new FileOutputStream(fileName); // 없으면 생성함
			bos = new BufferedOutputStream(fos);
			//직렬화
			out = new ObjectOutputStream(bos);
			
			// 객체 생성
			UserInfo u1 = new UserInfo("홍길동", "super", 100);
			UserInfo u2 = new UserInfo("scott", "tiger", 50);
			
			//직렬화
			out.writeObject(u1); // UserInfo를 줄을 세워서 UserData.txt쓰기
			out.writeObject(u2);
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			
		}finally {
			try {
				// 역순으로 닫기
				out.close();
				bos.close();
				fos.close();
				System.out.println("파일 생성 -> buffer -> 직렬화 -> write");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
