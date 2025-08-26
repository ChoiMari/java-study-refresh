import java.io.IOException;

import kr.or.kosa.utils.ExClass;

public class Ex04_throws {

	public static void main(String[] args) {
		// 예외 처리 시 가장 하위 클래스부터 잡음
		//(상위 클래스부터 쓰면 거기서 다 잡기 때문에 밑에 작성하는게 의미가 없다)
		// 상속관계에서는 멀티 예외처리 못함
		try {
			ExClass ex = new ExClass("C:\\Temp");
		} catch (NullPointerException | IOException e) {
			e.printStackTrace();
		}

	}

}
