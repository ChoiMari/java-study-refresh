package ko.or.kosa;
/*
[Tv 설계도 요구사항정의]

// 필드1
Tv는 채널 정보를 가지고 있다   (예를 들면 1 ~ 200 값을 가질 수 있다)  
	public     정수값을 가질 수 있어요

// 필드2
Tv는 브랜드 이름을 가지고 있다 (예를 들면 엘지  , 삼성 )             
	public     문자열 값을 가질 수 있어요
	
//메서드 1
Tv는 채널 전환 기능을 가지고 있다(채널은 한 채널씩 이동이 가능하다)
	->채널을 증가 시키는 기능을 가지고 있다
//메서드 2
	->채널을 감소 시키는 기능을 가지고 있다

//메서드3
Tv의 채널정보와 브랜드이름을 볼 수(출력) 있는 기능을 가지고 있다
*/
public class Tv {
	public int channelNumber;
	public String brandName;
	
	public void channelUp() {
		channelNumber++;
	}
	
	public void channelDown() {
		if(channelNumber > 0) {
			channelNumber--;
		}
		channelNumber = 1;
		
	}
	
	public void infoPrint() {
		System.out.println("채널 정보 : " + channelNumber + ", 브랜드 이름 : " + brandName);
	}
	

}
