package ko.or.kosa;
/*
 우리 회사는 비행기를 주문 제작 판매하는 회사입니다.
 우리 회사는 비행기를 생산하는 설계도를 만드려고 합니다.
 
 요구 사항
 1. 비행기를 생산하고, 비행기의 이름과 번호가 부여되어야 한다.
 2. 비행기가 생산되면 비행기의 이름과 번호가 맞게 부여되었는지 
 확인 하는 작업(기능) 출력 기능
 3. 공장장은 현재까지 만들어진 비행기의 총 누적 대수를 확인할 수 있다. - 출력 기능
 
 제약 :  생성자 사용 금지, this 금지(앞으로 배워서 바꾸겠다)
 
 ex) AirPlane air101 = new AirPlane();
 air101.자원 = "대한항공"
 air101.자원 = 707
 
 비행기이름, 출력
 
 총 비행기 누적대수 : 5대 생산
 비행기 대수 -> new 하면 비행기 1대씩 추가 생산
 
 * */
public class AirPlane {
	
	private int airNum; // 비행기 번호
	private String airName; // 비행기 이름
	private static int airCount; // 누적 대수
	
	public AirPlane(int airNum, String airName) {
		this.airNum = airNum;
		this.airName = airName;
		airCount++;
	}
	
	public void print() {
		System.out.printf("[비행기 이름] : %s, [비행기 번호] : %d\n", airName, airNum);
	}
	
	public void airCount() {
		System.out.println("총 비행기 누적대수 : " + airCount);
	}
	
	//getter & setter
	public int getAirNum() {
		return airNum;
	}
	
	public void setAirNum(int airNum) {
		this.airNum= airNum;
	}
	
	public String getAirName() {
		return airName;
	}
	
	public void setAirName(String airName) {
		this.airName = airName;
	}
	
	public int getAirCount() {
		return airCount;
	}
	
}
