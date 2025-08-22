package ko.or.kosa;

// 마우스는 x,y 한 점을 표현
// x,y 캡슐화
// write 구현(setter)
// 메서드로 x,y출력
public class Mouse {
	private int x;
	private int y;
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void printXY() {
		System.out.println("x : " + x + ", y : " + y);
	}
}
