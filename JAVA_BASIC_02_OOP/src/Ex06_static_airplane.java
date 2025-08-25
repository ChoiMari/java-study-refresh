import ko.or.kosa.AirPlane;

public class Ex06_static_airplane {

	public static void main(String[] args) {
		// 비행기 3대 만들고, 확인, 총대수 확인
		AirPlane air1 = new AirPlane();
		AirPlane air2 = new AirPlane();
		AirPlane air3 = new AirPlane();
		air1.makeAirPlane(1,"대한항공");
		air2.makeAirPlane(2,"제주항공");
		air3.makeAirPlane(3,"아시아나항공");
		
		air3.airCount(); // 3
	}

}
