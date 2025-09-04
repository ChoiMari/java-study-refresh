/*
  출력 형식을 정의하는 보조 스트림
  1.  printf
  2.  String.format()
  3.  I/O PrintWriter (파일에 출력 이쁘게 )
  
  현업 : 세금계산서 , 지출결의서 , 품의서(휴가원,결제 서류) 
      : 돈 (제품 : 오즈 , 크리스탈 레포트)
      : 프로젝트 직접 그린다 ( 친구에게 (LLM))
*/
/*
			PrintWriter pw = new PrintWriter("D:\\Temp\\homework.txt");
			pw.println("********************************************");
			pw.println("**                HOMEWORK                **");
			pw.printf("%3s : %5d %5d %5d %5.1f","아무개",100,88,90,(float)((100+88+90)/3));
			pw.println();
			pw.close();
*/

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Ex11_PrintWriter {
	public static void main(String[] args) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("D:\\Temp\\homework.txt");
			pw.println("********************************************");
			pw.println("**                HOMEWORK                **");
			pw.printf("%3s : %5d %5d %5d %5.1f","아무개",100,88,90,(float)((100+88+90)/3));
			pw.println();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pw.close();
		}
		
		pw.close();
	}
}


/*
  String fileName = "휴가원.txt";

        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
            // 휴가원 내용 작성
            pw.println("============== 휴 가 원 ==============");
            pw.println("부서: 개발팀");
            pw.println("직위: 주임");
            pw.println("성명: 홍길동");
            pw.println("------------------------------------");
            pw.println("휴가 구분: 연차");
            pw.println("휴가 기간: 2025-09-10 ~ 2025-09-12 (3일)");
            pw.println("휴가 사유: 개인적인 사유로 인한 휴가 신청");
            pw.println("------------------------------------");
            pw.println("신청일: 2025-09-03");
            pw.println();
            pw.println("신청자 서명: 홍길동");
            pw.println("====================================");

            System.out.println("휴가원 파일이 생성되었습니다: " + fileName);
        } catch (IOException e) {
            System.out.println("파일 생성 중 오류 발생: " + e.getMessage());
        } 
        
        
============== 휴 가 원 ==============
부서: 개발팀
직위: 주임
성명: 홍길동
------------------------------------
휴가 구분: 연차
휴가 기간: 2025-09-10 ~ 2025-09-12 (3일)
휴가 사유: 개인적인 사유로 인한 휴가 신청
------------------------------------
신청일: 2025-09-03

신청자 서명: 홍길동
====================================
  
*/ 
