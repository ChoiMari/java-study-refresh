package kr.or.kosa;
//요구사항: 클래스 설계 만족 : 최소한의 조건
//상태정보 + 행위  
//정보(고유정보+상태정보) + 행위 > 설계도 : 데이터 타입 : 작은 타입이 모여있는) 


//자동차는 문의 개수를 가지고 있다 
//자동차는 색상을 가지고 있다 


// 캡술화
public class Car {
	private int door;    	// 속성 또는 정보 
private String carColor;  // member field (instance variable)
	public int getDoor() {
		return door;
	}
	public void setDoor(int door) {
		this.door = door;
	}
	public String getCarColor() {
		return carColor;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	

	//캡슐화 자원을 읽을 수 있고, 쓸 수 있는 특수한 목적의 method가 필요
	//setter, getter 

	public void carInfoPrint() {
		System.out.println(this.door + " / " + this.carColor);
		 
	}
	
	
}
