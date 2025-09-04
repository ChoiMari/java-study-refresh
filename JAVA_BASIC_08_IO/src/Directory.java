import java.io.File;


public class Directory {
	
	public static void dir(String path) {
		// String path = "C:\\";
		File folder = new File(path);
		File[] files = folder.listFiles();

		try {
			System.out.println("\n   디렉터리 : " + path + "\n\n");
			System.out.println("Name" + "\t\t\t\t" + "Length");
			System.out.println("----"+ "\t\t\t\t" +"----");
			//String[] fileNames = folder.list();
			
			if(files != null) {
				for(int i = 0;i < files.length;i++) {

					System.out.printf("%-31s %d\n",files[i].getName(),files[i].length());
				}
			}else {
				System.out.println("파일을 찾을 수 없습니다.");
			}
			
		}catch(Exception e) {
			e.getStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String path = "C:\\";
		dir(path);
	}
}
