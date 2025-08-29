
public class Ex06_String_Method {
	
	public static void main(String[] args) {
		String str = "hello";
		String concarstr = str.concat(" world"); 
	    //기존의 문자열에 연결해서 새로운 문자열로 만들어서 리턴
		System.out.println(concarstr);
		
		
		//str.contains("eloo");//false
		//문자순서(시퀀스) - 순차적으로 연결된 순서로 판단
		
		String str2 = "a b c d";
		//String은 char[]
		
		String filename = "hello java world";
		System.out.println(filename.indexOf("e")); // 1
		// 캐릭터의 인덱스값 1
		// e가 인덱스 1번 위치에 있음
		
		System.out.println(filename.indexOf("java")); // 6
		// 시작 위치를 묻는것
		// 인덱스 6번 부터 시작한다
		
		System.out.println(filename.indexOf("안녕")); //-1
		// 없으면 -1리턴
		
		if(filename.indexOf("wo") != -1) {
			System.out.println("wo 하나라도 있다"); // 출력됨
		}
		
		//indexOf() 활용 : 
		//특정 문장에서 내가 원하는 단어의 포함여부를 확인할 때 많이 사용함
		
		//String filename = "hello java world";
		System.out.println(filename.lastIndexOf("a")); //9
		// 끝에서 만난 처음 만난 a의 인덱스
		
		// 그 외 자주 만나는 함수(외우기)
		// length(), indexOf(), substring(), replace(), split()
		
		String result = "superman";
		System.out.println(result.substring(0)); //superman 
		//인덱스 0부터 끝까지 다나옴
		
		System.out.println(result.substring(1)); //uperman 
		//인덱스 1부터 끝까지
		
		System.out.println(result.substring(1,2)); // u
		
		/*
		  beginIndex the beginning index, inclusive.
		  endIndex the ending index, exclusive. (index -1)
		 */
		
		System.out.println(result.substring(0,1)); //s
		// 0,0과 같음
		System.out.println(result.substring(0,0));
		// 0, -1 -> 아무것도 안나옴. 빈 문자열
		
		//Quiz
		String filename2 = "home.jpg"; //또는 h.jpeg 또는 aaaaa.hwp
		//파일명과 확장자 분리해서 출력하기
		// 단, 위에서 배운 함수만 사용하기
		
		//String[] sstr = filename2.split(".");
		
		int index = filename2.lastIndexOf(".");
		
		//파일명
		System.out.println(filename2.substring(0,index)); // home
		// 확장자
		System.out.println(filename2.substring(++index)); // jpg
		//System.out.println(filename2.substring(index)); // .jpg
		
		System.out.println(filename2.substring(index, filename2.length()));
		//jpg
		
		
	}
}
