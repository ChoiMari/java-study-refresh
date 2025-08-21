package com.study;

public class GenericExample {

	public static void main(String[] args) {
		Box<String> box1 = new Box<>(); 
		// new Box<String>(); 변수선언과 동일한 타입 호출 시 생성자에 타입 명시 생략 가능
		box1.content = "안녕하세요";
		String str = box1.content;
		System.out.println("str");
		
		Box<Integer> box2 = new Box<>();
		box2.content = 100;
		int value = box2.content;
		System.out.println(value);
	}

}
