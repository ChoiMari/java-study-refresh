import ko.or.kosa.Mouse;
import ko.or.kosa.NoteBook;

public class Ex04_Method {
	public static void main(String[] args) {
		NoteBook noteBook = new NoteBook();
		noteBook.setColor("red");
		noteBook.setYearProduction(2025);
		String color = noteBook.getColor();
		int year = noteBook.getYearProduction();
		System.out.println("color: " + color + ", year : " + year);
		
		//---------------------------------------
		// 노트북 마우스 사용 불편
		Mouse mouse = new Mouse();
		
		// 노트북 마우스 연결
		noteBook.handleMouse(mouse);
		
		// 통합제품을 가질건지
		// 다른 제품을 연결해서 사용할건지
	}
}
