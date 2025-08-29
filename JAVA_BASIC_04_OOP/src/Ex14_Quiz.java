//println와 똑같은 역할을 하는 메서드를 만들어 보세요

class Ssystem{
	public static final Print out; //Out out 으로 해도 됨
	
	static {
		out = new Print();
	}

}

class Print { //Class Out으로 해도 무관
    void println(String s) {
        System.out.println(s);
    }
    void println(int i) {
        System.out.println(i);
    }
}

//println 기능 : 문자열, 정수 출력 기능(오버로딩 하기)
public class Ex14_Quiz {
	public static void main(String[] args) {
		System.out.println("어떤 메서드야");
		System.out.println(100);
		Ssystem.out.println("후후");		
	}
}
