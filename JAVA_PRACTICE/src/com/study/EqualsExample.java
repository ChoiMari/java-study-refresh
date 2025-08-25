package com.study;

public class EqualsExample {

	public static void main(String[] args) {
		
		//User에서 Object클래스의 equals()를 오버라이드 -> 확인
		User user1 = new User("홍길동");
		User user2 = new User("홍길동");
		User user3 = new User("임꺽정");
		
		if(user1.equals(user2)) {
			System.out.println("user1과 user2는 동등합니다."); //실행
		} else {
			System.out.println("user1과 user2는 동등하지 않습니다.");
		}
		
		if(user1.equals(user3)) {
			System.out.println("user1와 user3는 동등합니다.");
		}else {
			System.out.println("user1와 user3는 동등하지 않습니다."); //실행
		}

	}

}
