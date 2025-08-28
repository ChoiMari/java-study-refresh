/*
 변수는 값을 바꿀 수 있음
 상수는 값이 한 번 초기화 되면 그 이후에는 변경 불가
 
  상수 : 고유값. 한 번 정해지면 변경되지 않는 값
   ex) 주민번호, 수학 공식 : 원주율 3.141592...
   		소프트웨어 출시(버전 번호 v1.0.0.1)
  상수는 관습적으로 대문자와 _로 사용하기로 약속함
  JAVA : final int NUM = 0;
  C# : const integer NUM = 0;
  
  final 키워드
  1. final class Car{} -> 상속 금지
  	ex) public final class Math extends Object
  2. public final void print(){} 상속관계에서 재정의 금지
 
 */

import kr.or.kosa.Apt;

class Vard{
	final String KIND = "heart";
	final int NUM = 10;
	
	void method() {
		//JAVA API
		System.out.println(Math.PI); 
	}
}

//설계자 입장에서 
// 카드를 만드는 설계도를 만들고 싶을 때
// 요구 사항 - 카드마다 모양, 번호는 한 번 정해지면 변경이 불가
class Card{
	final String KIND;
	final int NUM;
	
	// Card(){} : 컴파일 에러
	// final은 값을 받을 확신이 없으면 컴파일 에러가 남
	// 그래서 final사용 시 초기화 보장 코드가 필요
	
	Card(String kind, int num){ // final 상수 초기화 보장



this.KIND = kind;
		this.NUM = num;
	}
	
	@Override
	public String toString() {
		return "KIND : " + this.KIND + " / " + "NUM : " + this.NUM;
	}
}
public class Ex07_final {
	public static void main(String[] args) {
		Card card1 = new Card("spade", 1);
		System.out.println(card1.toString());
		
		Card card2 = new Card("spade", 2);
		System.out.println(card2.toString());
		
		Card card3 = new Card("spade", 3);
		System.out.println(card3.toString());
		// 객체 1개가 카드 1장
		
		// card3.KIND = "aaa"; 값 바꾸지 못함
		//Math.PI -> 상수는 모든 객체에서 전부 동일하게 사용되는 값이니까 
		//-> final static으로 선언하는 경우가 많다.
		// 자바 API가 제공하는 상수들은 다 static final
		Apt apt = new Apt();
		apt.setDoor(1000);
		System.out.println(apt.getDoor());
	}
}
