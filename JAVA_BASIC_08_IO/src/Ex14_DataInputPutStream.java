import java.io.DataInputStream;
import java.io.FileInputStream;

public class Ex14_DataInputPutStream {
	public static void main(String[] args) {
		// 파일 score.txt 학생 점수 기록
		// read해서 학생 점수 합계 / 평균
		int sum = 0;
		int score = 0;
		
		FileInputStream fis = null;
		DataInputStream dis = null;
		
		try {
			fis = new FileInputStream("score.txt");
			dis = new DataInputStream(fis);
			
			while(true) {
				score = dis.readInt();
				System.out.println("score int data : " + score);
				sum += score;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("sum 결과 : " + sum);
		}finally {
			try {
				dis.close();
				fis.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
