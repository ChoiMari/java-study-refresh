package com.study;

public class A { 
		
		class B { // 인스턴스 멤버 클래스
			
			//인스턴스 필드값으로 B객체 대입
			int field1 = 1;
			
			static int field2 = 2; // 정적 필드
			B(){
				System.out.println("B 생성자 실행");
			}
			
			//인스턴스 메소드
			void method1() {
				System.out.println("B 메서드1 실행");
			}
			
			static void method2() {
				System.out.println("B 메서드2 실행");
			}
		}
		
		B field = new B();
		
		// 생성자
		A(){
			B b = new B();
		}
		
		// 인스턴스 메소드
		void useB() {
			B b = new B(); 
			System.out.println(b.field1);
			b.method1();
			
			//B 클래스의 정적 필드 및 메소드 사용
			System.out.println(b.field2);
			B.method2(); 
		}
	
}
