/*
 두 개의 설계도
 class Tv{}
 class Vcr{} 
 */

class Tv{
	boolean power;
	int ch;
	
	void power() {
		this.power = !this.power; 
		// 기능 2개 - 토글링(스위치처럼)
	}
	void chUp() {
		this.ch++;
	}
	void chDown() {
		this.ch--;
	}
}

class Vcr{ // 비디오 플레이어
	boolean power;
	void power() {
		this.power = !this.power; 
		// 기능 2개 - 토글링(스위치처럼)
	}
	
	void play() {
		System.out.println("재생하기");
	}
	void stop() {
		System.out.println("정지하기");
	}
	void rew() {}
	void ff() {}
	
}

/*
  Tv, Vcr이 합쳐진 전자제품을 만들고 싶음
 class TvVcr extends Tv, Vcr -> 다중 상속은 안됨
 
  1.계층적으로 내리려고 봤더니 뭘 자식으로 두고, 뭘 부모로 둘지 헷갈림..(고민)
  또 다른 방법? 둘 다 포함
  2.class TvVcr{Tv tv; Vcr vcr;} 
  
  3.한개는 상속하고 한개는 포함하길 원함
  그럼 어떻게 할까? 
  
  
 */

class TvVcr extends Tv{
	Vcr vcr;
	
	public TvVcr() {
		this.vcr = new Vcr(); // 통합제품
	}
	
	
	
}

public class Ex03_Inherit {
	public static void main(String[] args) {
		TvVcr tvvcr = new TvVcr();
		tvvcr.power(); // 티비 전원 킴
		System.out.println(tvvcr.power);
		
		//비디오 전원 킴
		tvvcr.vcr.power();
		System.out.println(tvvcr.vcr.power);
		
	}
}
