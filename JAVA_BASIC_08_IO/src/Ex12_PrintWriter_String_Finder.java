import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ex12_PrintWriter_String_Finder {
	
	String baseDir = "D:\\Temp"; //검색한 디렉토리
	String word="HELLO"; //검색할 단어
	String savetxt = "result.txt"; //HELLO 단어가 들어있는 파일 정보 저장
	
	void Find() throws IOException{ // 예외처리 강제
		File dir = new File(baseDir);
		if(!dir.isDirectory()) {
			System.out.println("유효한 폴더가 아니예요");
			System.exit(0); //kill 강제 종료
		}
		
		PrintWriter writer = new PrintWriter(new FileWriter(savetxt));
		BufferedReader br = null;
		
		File[] files = dir.listFiles();
		for(int i = 0 ; i < files.length ;i++) {
			//검사
			if(!files[i].isFile()) {
				continue; //skip 아래 코드 무시
			}
			//파일이면 
			br = new BufferedReader(new FileReader(files[i]));
			
			//a.txt 또는 b.txt
			//한문장 (엔터) 한줄 Read
			String line="";
			while((line = br.readLine()) != null) {
				//한줄안에 내가 찿고자 단어가 있는지   a.txt >> 한줄에 >> HELLO
				if(line.indexOf(word) != -1) {
					writer.write("word=" + files[i].getAbsolutePath() + "\n");
				}
				
			}
			writer.flush();
		}
		br.close();
		writer.close();
	}
	
	public static void main(String[] args) {
		
		Ex12_PrintWriter_String_Finder wordFinder = new Ex12_PrintWriter_String_Finder();
		
		try {
			   wordFinder.Find();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
