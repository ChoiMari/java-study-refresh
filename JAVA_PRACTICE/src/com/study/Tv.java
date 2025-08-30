package com.study;

//조별과제 - 간단한 설계도(시나리오)
public class Tv { // 싱글톤으로 관리 
	
	private static Tv instance; 
	
	public static Tv getInstance() {
		if(instance == null) {
			instance = new Tv();
		}
		return instance;
	}
	
	// 고유데이터
	private int no;
	private String brandName; 
	private String company;
	private int inch;
	
	// 상태 데이터
	private boolean power;
	private int channel;
	private int volume;
	private int brightness;
	private String[] inputSource;
	private int index; //외부 입력 인덱스
	
	// 부품데이터
	private Remote remote;
	
	// 생성자
	private Tv() { //기본값
		no = 0;
		brandName = "삼성";
		company = "삼성공장";
		inch = 18;
		power = false;
		channel = 0;
		volume = 0;
		brightness = 0;
		inputSource = new String[] {"HDMI", "DVI", "DP"};
		index = 0;
		remote = new Remote(this); 
		// 통합 상품 : 반드시 주소를 넘겨야 동일 주소값으로 연동이됨
	}
	

	// 기능(메서드)
	// 채널 변경 : 민석
	// 999에서 올리면 0으로 가기
	public void channelUp(){
		if(channel < 999){
			channel++;
	        System.out.println("channel : " + channel);
	        } else {
	        	channel = 0;
	            System.out.println("channel : " + channel);
	        }
	    }
	    
	 //0에서 내리면 999로 가기
	 public void channelDown(){
		 if(channel > 0){
			 channel--;
	         System.out.println("channel : " + channel);
	         } else {
	        	 channel = 999;
	        	 System.out.println("channel : " + channel);
	        }
	    }
	
	// 전원 : 마리
	public void isON() {
		power = !power;
		System.out.printf("티비 전원 여부 : %b\n", power);
	}
	
	// 볼륨 조절 : 가연
	// 볼륨 범위: -5 <= volume <= 5
	public void volumeUp() {
		if (volume == 5) {
			System.out.println("이미 최대 볼륨입니다. (최대 볼륨: 5)");
			} else {
				volume++;
				System.out.printf(">> 볼륨이 +1 되었습니다. 현재 볼륨 : %d", volume);
				System.out.println();
			}
		}
		
	public void volumeDown() {
		if (volume == -5) {
			System.out.println("이미 최소 볼륨입니다. (최대 볼륨: -5)");
			} else {
				volume--;
				System.out.printf(">> 볼륨이 -1 되었습니다. 현재 볼륨 : %d", volume);
				System.out.println();
			}
		}
		
	//화면밝기 조절 : 성일
	public void brightUp() {
		if (brightness < 100) {
			brightness++;
			System.out.println("화면 밝기 Up: " + brightness);
			}else {
				System.out.println("최대 밝기입니다(현재 밝기: " + brightness + ")");
			}
		}
	public void brightDown() {
		if (brightness > 0) {
			brightness--;
			System.out.println("화면 밝기 Down : " + brightness);
		}else {
			System.out.println("최소 밝기입니다(현재 밝기 : " + brightness + ")");
		}
	}

	//외부입력 변경 : 지수
	public void Source(){
		if(index >= inputSource.length){
			index = 0;
		}
		System.out.println("status : " + inputSource[index++]);
	}


	public Remote getRemote() {
		return remote;
	}

	
	
}
