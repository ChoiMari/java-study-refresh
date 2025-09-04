import java.io.BufferedReader;
import java.io.FileReader;

public class Ex06_Reader_Writer_Buffer {

	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			  fr = new FileReader("Ex01_Stream.java");
			  br = new BufferedReader(fr);
			  
			  //line 단위 처리
			  String line=""; //한줄 ...
			  for(int i = 0 ; (line = br.readLine()) != null ; i++) {
				  //System.out.println(line);
				  if(line.indexOf(";") != -1 ) {
					  System.out.println(line);
				  }
			  }
					  
		} catch (Exception e) {
			try {
				 br.close();
				 fr.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

}
/*
 FileWriter fw = new FileWriter("lotto.txt,true);
 BufferedWriter bw = new BufferedWriter(fw);
 bw.write("로또")
 bw.newLine(); //엔터처리
 bw.write("1회차" + "1,3,5,7,8)
 bw.newLIne();
 bw.flush();
*/