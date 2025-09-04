import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Ex03_Stream_ImageCopy {

	public static void main(String[] args) {
		
		String oriFile = "D:\\Temp\\1.jpg";
		String targetFile = "copy.jpg";
		//이클립스 경로를 설정하지 않으면 : 
		//D:\MSA_EDU\JAVA\Labs\JAVA_BASIC_08_IO\copy.jpg

		FileInputStream fs = null;
		FileOutputStream fos = null;
		
		try {
			   fs = new FileInputStream(oriFile);
			   fos = new FileOutputStream(targetFile);
			   //파일 없으면 생성 .. 빈파일 > copy.jpg
			   
			   int data=0;
			   while((data = fs.read()) != -1) {
				   fos.write(data); //copy.jpg write 하는 것....
			   }
		} catch (Exception e) {
			  System.out.println(e.getMessage());
		}finally {
			try {
				  fs.close();
				  fos.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	}

}
