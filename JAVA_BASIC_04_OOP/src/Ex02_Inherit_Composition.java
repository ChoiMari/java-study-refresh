/*
 현업에서 개발 - 1개의 클래스만 가지고 계발 하는 경우 XXXXX 말도 안된다.
 
  설계도(클래스) 1장에 모든 업무를 구현... 현실적으로 불가능..
  설계도를 여러장으로 나눈다... 고민..
  어떤 기준과 논리로 나눌 것인가?
  
  예)
  <도서관리프로그램>
 	- 회원가입 업무, 도서관리, 배송, 등
     	쪼개면 관계가 성립이 되어야 함.
   <쇼핑몰>
    - 결제관리, 배송관리, 재고관리, 회원관리, 상품관리, 판매처 관리, 카드 관리
    	-> 업무별 설계도
    
    DB 관계는 3개 (1:1, 1:N, M:N) 
    책 : 저자(M:N) -> 1 : N으로 해소함
     
    객체지향 관계는 많다..(연관 관계만 DB로 갈 수 있음)
    
    ********기준********
    	여러개의 설계도가 있을 때 관계에 대한 기준이 필요함
    	1. 상속 관계 -> is ~ a 문장 : 무엇은 무엇이다.
    		상속 관계로 들어감
    		ex) 원은 도형이다 -> 도형이 부모클래스(추상화, 일반화), 원이 자식클래스(구체화)
    	2. 포함 관계 ->  has ~ a : 무엇은 무엇을 가지고 있다.
    		클래스 안에 부품으로 들어감
    		ex) 자동차는 엔진을 가지고 있다 -> 자동차 클래스 안에 엔진(부품) 클래스가 들어감
    		
    		경찰은 권총이다(X)
    		경찰은 권총을 가지고 있다(O) -> 포함관계 -> 권총이 부품으로 들어감
    		
    		삼각형은 도형이다(O) -> 상속 관계
    		삼각형 extends 도형
    		
    		원과 점과의 관계 
    		원은 점이다.(X)
    		원은 점을 가지고 있다.(O) -> has ~ a(부품)
    		
    		class 원 { 점이라고 하는 부품이 member field 구현 점타입으로 }
    		class 점 {x,y}
    		
    		원은 도형이다
    		삼각형은 도형이다
    		사각형은 도형이다
    		
    		도형(분모- 공통적 자원) : 추상화 되고, 일반화된 자원
    			기능 : 그리다, 색상을 가지고 있음
    			-> 원, 삼각형, 사각형에 적용
    		원 : 구체화, 특수화
    			(원의 특징) - 반지름, 한 원을 가지고 있음
    			점(좌표값)(x,y)
    			원은 점을 가지고 있다
    			삼각형은 점을 가지고 있다.
    			사각형은 점을 가지고 있다.
    			
  class Shape{그리다, 색상} //-> 부모 클래스(상속)
  class Point {좌표값} //-> 부품(멤버필드)
 */
class Shape{
	String color = "gold";
	void draw() {
		System.out.println("도형을 그리다.");
	}
}

class Point{
	int x;
	int y;
	
	Point(){
//		this.x = 1;
//		this.y = 2;
		this(1, 2);
	}
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

/*
원을 만드세요 (원의 정의 : 원은 한점과 반지름을 가지고 있다)
1. 원은 도형이다 (is ~ a) : Shape
2. 원은 점을 가지고 있다 (has ~ a) : Point
3. 원은 특수화되고 구체화된 내용은 : 반지름

원의 반지름은 초기값 10을 가진다
점의 좌표는 초기값 (10,15) 가진다
초기값을 설정하지 않으면 반지름과 점을 값을 입력받을 수 있다 

*/
class Circle extends Shape{ // 상속
	private Point point; // 포함(부품)
	private int radius; // 구체화, 특수화(자식만 가지고 있는 특성)
	
	public Circle() {
		this(new Point(10, 15),10);
	}
	public Circle(Point point, int radius) {
		this.point = point;
		this.radius = radius;
	}
	
	public Point getPoint() {
		return point;
	}
	
	public void setPoint(Point point) {
		this.point = point;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
}

/*
삼각형 클래스를 만드세요
삼각형은 3개의 점과 색상과 그리고 그리다 기능을 가지고 있다
hint) Shape , Point 제공 받아서 설계도 작성 하세요
hint) (x,y) , (x,y) , (x,y)
default 삼각형을 만들 수 있고  3개의 좌표값을 받아서 그릴 수 있다 

개인별로 풀어 보시고 제가 한 바퀴 돌면서 채점을 해 드릴게요 ^^
50 , 70 , 100점 으로 나누어 드릴게요 ^^
*/
class Triangle extends Shape{ // 상속(삼각형은 그리다 기능을 가지고 있다)
	
	// 멤버 필드
	// 삼각형은 점 3개를 가지고 있다 - 구체화 특징
	private Point[] pointArr;
	
	// 생성자
	public Triangle() {
		// default값 존재
		this(new Point[] {new Point(10,20), new Point(30,40), new Point(40, 50)});
	}
	
	// 생성자 오버로딩 - 모든 필드를 초기화 하는 생성자
	public Triangle(Point[] pointArr) {
		this.pointArr = pointArr;
	}
	
	@Override
	public void draw() {
		System.out.println("삼각형을 그리다.");
	} 
}

public class Ex02_Inherit_Composition {

	public static void main(String[] args) {
		Circle circle = new Circle();
		System.out.println(circle.getRadius());
		System.out.println(circle.getPoint().x); 
		// Point객체의 주소로 Point객체가 가지고 있는 x에 접근
		System.out.println(circle.color); //-> 부모거 사용
		circle.draw();
		
		//반지름, 점의 값을 내가 원하는대로 
		Circle circle2 = new Circle(new Point(10,20), 100);
		// 아큐먼트로 Point타입의 주소를 넣어서 호출
		
		// 삼각형
		


	}

}
