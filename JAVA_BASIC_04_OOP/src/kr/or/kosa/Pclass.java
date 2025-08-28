package kr.or.kosa;

import lombok.Data;

@Data
public class Pclass {
	// 나는 Pclass를 
	public int i; // 같은 프로젝트 내 전체에서 접근 가능
	private int o; 
	
	int p; //default 접근 제한 : 같은 package 내에서만 접근 가능
	// 다른 패키지에서 접근 불가
	
	protected int k; // 상속 관계가 아니면 default와 같음
	
	protected void m() {
		
	}
}
