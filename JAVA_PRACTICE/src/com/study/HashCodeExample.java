package com.study;

public class HashCodeExample {
	public static void main(String[] args) {
		Employee emp1 = new Employee(100, "김철수");
		Employee emp2 = new Employee(100, "김철수");
		
		if(emp1.hashCode() == emp2.hashCode()) { 
			if(emp1.equals(emp2)) { 
				System.out.println("동등 객체 입니다.(내부데이터가 같음)");
			} else {
				System.out.println("동등 하지 않습니다.(내부데이터가 다름)");
			}
			
		} else {
			System.out.println("해시코드가 다르므로, 동등 객체가 아닙니다.");
		}
	}
}
