package com.study;

public class User {
	public String id;
	
	public User(String id) {
		this.id = id;
	}
	
	@Override // Object클래스의 equals() 오버라이드
	public boolean equals(Object obj) { // 아규먼트로 객체를 받음
		if(obj instanceof User target) { // 받은 객체의 타입이 같은지 비교
			// 같으면 타입 변환 후 target 변수에 저장
			if(id.equals(target.id)) { // String의 equals()로 동등비교(내부 데이터 동등비교)
				return true;  
			}
		}
		
		return false;
	}
}
