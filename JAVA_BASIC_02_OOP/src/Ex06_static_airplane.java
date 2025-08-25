import ko.or.kosa.AirPlane;

public class Ex06_static_airplane {

	public static void main(String[] args) {
		// 비행기 3대 만들고, 확인, 총대수 확인
		AirPlane air1 = new AirPlane(101, "대한항공");
		AirPlane air2 = new AirPlane(102, "대한항공");
		AirPlane air3 = new AirPlane(103, "대한항공");
		
		air1.print();
		air1.airCount();
	}

}
