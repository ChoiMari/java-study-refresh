import ko.or.kosa.Person;


// 연습용 class
class Test{ // 같은 패키지 내에서만 사용 가능
int i;
	int j;
	void print() {
		System.out.println(i);
	}
}

public class Ex01_Ref_Type {
	public static void main(String[] args) {
		Person person = new Person();
		person.name = "홍길동";
		person.age = 100;
		person.power = true;
		person.personPrint();
		
		// 결과
		System.out.println(person); // 여기에 .toString()이 생략되어 있는 거
		// ko.or.kosa.Person@2a18f23c
		//주소값 조합된 주소값
		// 패키지명 + "@" + 16진수 주소값을 조합해서 출력
		
		System.out.println(person.toString());
		// toString()은 오브젝트 클래스에 정의 되어 있는 메서드
		// 모든 클래스는 Object class를 상속하고 있음
		// Object class의 toString()을 ko.or.kosa.Person@2a18f23c 이런 형식으로
		// 리턴하게 구현해놨음
		
		Person person2 = person; //person의 주소값 할당
		// person2와 person은 같은 메모리 주소를 바라보고 있음
		
		// 증명
		System.out.printf("person2와 person은 같은가요? : %b" , person2 == person);
		// true
		
	}
}
