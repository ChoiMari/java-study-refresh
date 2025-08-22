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
	}
}
