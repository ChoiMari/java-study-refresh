package com.study;

public class AExample {
	public static void main(String[] args) {
		A a = new A();
		A.B b = a.new B(); // 인스턴스 멤버 클래스는 바깥 클래스 객체
		a.useB();
	}
}
