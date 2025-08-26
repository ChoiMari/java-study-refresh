/*
 원칙 : 객체 생성 할 때 생성자는 1개만 호출이 가능하다.
 new Car(), new Car(10)
 그런데 this를 사용하면 생성자를 호출 가능
 생성자가 가지고 있는 파라미터 개수와 타입을 맞추면 호출된다
 */
/*
class Zocar{
	String color;
	String gearType;
	int door;
	
	Zocar(){ // 기본값
		this.color = "red";
		this.gearType = "auto";
		this.door = 2;
	}
	
	Zocar(String color, String gearType, int door){
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
	
	void soCarPrint() {
		System.out.println(this.color+ " , " + this.gearType + " , " + this.door);
	}
}
*/

class Zcar{
	String color;
	String gearType;
	int door;
	
	Zcar(){ // 기본값
		this("red", "auto", 2); // 파라미터가 있는 생성자 호출
		// 자신을 다시 부름
		// 생성자도 메서드(필드 초기화 메서드)
		System.out.println("default");
	}
	
	Zcar(String color, String gearType, int door){
		this.color = color;
		this.gearType = gearType;
		this.door = door;
		System.out.println("overloading"); 
	}
	
	void soCarPrint() {
		System.out.println(this.color+ " , " + this.gearType + " , " + this.door);
	}
	
	class Zcar2{
		String color;
		String gearType;
		int door;
		
		Zcar2(){ // 기본값
			this("red", 2); // 파라미터가 있는 생성자 호출
			// 자신을 다시 부름
			// 생성자도 메서드(필드 초기화 메서드)
			System.out.println("default");
		}
		
		Zcar2(String color, int door){
			this(color, "auto", door);
			System.out.println("overloading1"); 
		}
		
		Zcar2(String color, String gearType, int door){
			this.color = color;
			this.gearType = gearType;
			this.door = door;
			System.out.println("overloading2"); 
		}
		
		void soCarPrint() {
			System.out.println(this.color+ " , " + this.gearType + " , " + this.door);
		}
	}
}

public class Ex15_this {

	public static void main(String[] args) {
		Zcar car = new Zcar();
		car.soCarPrint();
		Zcar car2 = new Zcar("pink", "auto", 4);
		car2.soCarPrint();
	}

}
