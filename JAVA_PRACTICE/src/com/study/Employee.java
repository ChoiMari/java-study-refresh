package com.study;

public class Employee {
	private int no;
	private String name;
	
	public Employee(int no, String name) {
		this.no = no;
		this.name = name;
	}
	
	public int getNo() {
		return no;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public int hashCode() {
		return no + name.hashCode();
		// String에서 오버라이드한 hashCode()호출 - 문자열 내용을 기준으로 재정의 되어있음
		// 내용이 같으면 hashCode()로 반환된 정수값도 같음
		// 사번과 이름의 데이터가 같으면 동일한 해시코드가 생성됨
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Employee target) { 
			// 아규먼트로 들어온 객체가 타입이 같으면 변수 target에 저장 
			if(no == target.no && name.equals(target.name)) {
				return true;
			}
		}
		return false;
	}
	
}
