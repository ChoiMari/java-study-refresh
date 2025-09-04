import java.io.File;

public class Ex08_File_Dir {

	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("사용법 : java  파일명 [디렉토리명]");
			//return;
			System.exit(0);//강제종료 
		}
		
		//java Ex08_Fiel_Dir C:\\Temp 엔터
		File f = new File(args[0]);  //C:\\Temp
		if(!f.exists() || !f.isDirectory()) {
			//존재하지 않거나 또는 디렉토리가 아니라면
			System.out.println("유효하지 않은 경로입니다");
			System.exit(0); //강제종료
		}
		
		//실제 존재하고 존재하는 것이 폴더(directory) 라면
		//POINT
		File[] files =  f.listFiles(); //폴더 안에 모든 자원 가지고 오기(자원하나를 File 객체)
		//[1.txt][11.jpg][new.txt][기러기][참새]

		for(int i = 0 ; i < files.length ;i++) {
			String name = files[i].getName(); //파일명 또는 폴더명
			System.out.println(files[i].isDirectory() ? "[DIR]"+ name : name);
		}
		
		
	}

}
