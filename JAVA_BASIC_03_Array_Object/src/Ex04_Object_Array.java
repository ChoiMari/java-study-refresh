class Person{
	String name;
	int age;
	
//	Person(String name, int age){ //객체 생성 시 :  이름, 나이 입력하도록 강제
//		this.name = name;
//		this.age = age;
//	}
	void print() {
		System.out.println(this.name + " : " + this.age);
	}
}
public class Ex04_Object_Array {
	public static void main(String[] args) {
		int[] intarr = new int[10];
		//[0][0][0]..[0] 기본값 0으로 채워짐
		boolean[] boolarr = new boolean[5];
		//[false][false][false][false][false]
		
		Person p = new Person();
		p.name = "홍길동";
		p.age = 100;
		
		//Person타입의 사람 3명을 만드세요.
		// 객체 배열은 선언과 각 방의 할당은 따로 해야한다
		Person[] parr = new Person[3];
		// 방은 만들었는데 방에 아무도 없음
		//[null][null][null]
		parr[0] = new Person(); // 방이 주소값을 갖는다.
		parr[2] = new Person();
		parr[2].name = "김유신";
		parr[2].age = 100;
		
		Person[] parray = new Person[10];
		for(int i = 0 ;i < parray.length;i++) {
			parray[i] = new Person(); // parray.length -1만큼 반복 실행
			System.out.println("주소값: " + parray[i]); // 다 다르게 나옴
		}
		
		// 2. int[] arr = new int[]{10,20,30}
		Person[] parray2 = new Person[] {new Person(), new Person()};
		
		//3. int[] arr = {10, 20}
		Person[] parr2 = {new Person(), new Person()};
	}
}
