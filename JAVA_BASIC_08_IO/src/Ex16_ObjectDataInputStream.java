import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import kr.or.kosa.UserInfo;

public class Ex16_ObjectDataInputStream {

	public static void main(String[] args) {
		
		String fileName = "UserData.txt";
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream in = null;
		
		try {
			fis = new FileInputStream(fileName);
			bis = new BufferedInputStream(fis);
			in = new ObjectInputStream(bis); // 역직렬화
			
			
			// 복원 - 객체가 파일에 몇 개 쓰여있는지 아니까 읽었는데...
//			UserInfo r1 = (UserInfo)in.readObject(); 
//			// 읽으려는 게 무슨 객체인지 몰라서 Object로 리턴함
//			// 그래서 캐스팅 필요
//			UserInfo r2 = (UserInfo)in.readObject(); 
//			
//			// 파일에 썼던거 읽음(자바 객체로 역직렬화)
//			System.out.println(r1.toString()); //복원 확인
//			System.out.println(r2.toString());
			
			Object users = null;
			while((users = in.readObject()) != null) {
				System.out.println(((UserInfo)users).toString());
			}
			
		}catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않아요");
		}catch (EOFException e) {
			System.out.println("끝 " + e.getMessage()); //-> 실행됨
		}catch (IOException e) {
			System.out.println("파일을 읽을 수 없어요");
		}catch (ClassNotFoundException e) {
			System.out.println("해당 객체가 존재하지 않아요");
		}catch(Exception e) {
			System.out.println("[예외] " + e.toString());
		} finally {
			try {
				//역순으로 닫음
				in.close();
				bis.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 이 방법 보다는
		//-> ArrayList<객체>를 써서 담고담고담아서 한 번에 쓰는게 좋다

	}

}
