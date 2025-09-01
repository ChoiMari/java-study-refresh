/*
 	제너릭(Today Point)
 		타입을 처음부터 강제함
 		타입 안정성 확보(타입 강제)
 		강제 형변환 필요 없음
 			ex) (Car)Object 다운캐스팅 필요없다
 			
 */

import java.util.ArrayList;
import java.util.List;

class MyGneric<T>{ // T : Type 파라미터
	private T obj;
	
	void add(T obj) {
		this.obj = obj;
	}
	
	T get() {
		return this.obj;
	}
	
}

class Person {
	int age = 10;

}

public class Ex04_Generic {
	public static void main(String[] args) {
		MyGneric<String> mygen = new MyGneric<>();
		/*
		 
		  class MyGneric<String>{ // T : Type 파라미터
			private String obj;
			
			void add(String obj) {
				this.obj = obj;
			}
			
			String get() {
				return this.obj;
			}
			
		}
		 */
		mygen.add("문자열");
		List list = new ArrayList(); // <T> 제네릭을 사용하지 않으면
		// 기본 Object
		
		list.add(10);
		list.add("홍길동");
		list.add(new Person());
		// 향상된 for문을 사용해서 Person 객체는 age값을 출력
		// 나머지는 값을 출력하기
//		for(Object obj : list) {
//			if(obj instanceof Integer) {
//				int age = (int) obj;
//			} else if(obj instanceof String) {
//				String name = (String)obj;
//			} else if(obj instanceof Person) {
//				Person p = (Person)obj;
//				System.out.println(p.age);
//			}
//		}
		
		for(Object obj : list) {
			if(obj instanceof Person) {
				Person p = (Person)obj;
				System.out.println(p.age);
			}else {
				System.out.println(obj);
			}
		}
		
		List<Person> plist = new ArrayList<>();
		plist.add(new Person());
		plist.add(new Person());
		
		for(Person p : plist) {
			System.out.println(p.age);
		}
		
	}
}
