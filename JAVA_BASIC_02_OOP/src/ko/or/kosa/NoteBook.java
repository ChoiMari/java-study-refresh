package ko.or.kosa;
/*
 * 노트북은 색상을 가지고 있다
 * 노트북은 생산년도를 가지고 있다
 * 노트북은 마우스를 가지고 있다(마우스는 2개의 좌표값을 가지고 있다)
 * */
public class NoteBook {
	private String color;
	private int yearProduction;
	private Mouse mouse = new Mouse();
	
	//getter & setter
	public String getColor() {
		return "[색상] " + color;	
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public int getYearProduction() {
		return yearProduction;
	}
	
	public void setYearProduction(int yearProduction) {
		if(yearProduction < 0) {
			this.yearProduction = 1999;
		} else {
			this.yearProduction = yearProduction;
		}
		
	}
	
	
}// 클래스 끝
