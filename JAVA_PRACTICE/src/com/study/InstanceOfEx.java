package com.study;
// 객체 타입 확인 -> instanceof 연산자 이용

class Parent{
	
}

class Child extends Parent{
	
}

public class InstanceOfEx {
	public void method(Parent parent) { 
		//Parent타입의 객체 주소 또는 Parent타입을 상속하고 있는 자식 객체의 주소가 올 수 있음(자동변환)
//		if(parent instanceof Child) {//타입확인 : parent가 Child를 참조하고 있으면 true반환
//			Child child = (Child)parent;
//		} //-> java 12 버전부터는 true일 경우, 우측 타입 변수를 사용할 수 있음
		if(parent instanceof Child child) {
			// parent가 Child타입이면 true이고 타입을 변환해서 child변수에 참조 주소를 저장함
		}
	}
	
	public static void main(String[] args) {
		

	}

}
