import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

//HashMap<K, V>
//HashMap<String, String>
//HashMap<String, Integer>
//HashMap<String, Student> ex)class Student{}
//-> value로 객체, 배열, List 사용 가능 

//put("kglim", new Student(9000,"홍길동","1학년"));

class ArrayTest{
	List<String[]> al = new ArrayList<>(); 
}

class Student{
	int kor;
	int math;
	int eng;
	String name;
	
	public Student(int kor, int math, int eng, String name) {
		super();
		this.kor = kor;
		this.math = math;
		this.eng = eng;
		this.name = name;
	}
	
}

public class Ex12_Map_Generic {
	public static void main(String[] args) {
		HashMap<String, String> sts = new HashMap<>();
		sts.put("A", "AAA");
		System.out.println(sts.get("A")); // AAA
		
		// 실무 활용
		// 학생 성적 데이터 관리
		// key가 학번, value가 여러건의 데이터(Array, Collection)
		HashMap<String, Student> smap = new HashMap<>();
		smap.put("hong", new Student(100,90,50,"홍길동"));
		smap.put("kim", new Student(50, 90, 50, "김유신"));
		Student sd = smap.get("kim"); // 값 반환(Student객체의 주소)
		
		System.out.println(sd.kor + "/" + sd.eng + "/" + sd.math + "/" + sd.name);
		// 50/50/90/김유신
		
		/*
		  class ArrayTest{
			List<String[]> al = new ArrayList<>(); 
		  }
		 */
		String[] strarr = {"A","B","C"};
		ArrayTest at = new ArrayTest();
		at.al.add(strarr); //String[]의 주소값이 들어가야함
		
		//Tip
		Set set= smap.entrySet(); // 가공된 데이터의 집합
		//key+"="+value
		//key는 중복X라서 같은 데이터가 나올리가 없음(+순서가 없음)
		// 그래서 Set타입으로 반환함
		Iterator it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		/*
		 	hong=Student@44e81672
			kim=Student@60215eee 
		 */
		
		//Tip**
		//key - value를 분리해서 한 번에 받고 싶을 때 사용
		//class Entry{Object key; Object value;}
		// Map{Entry[] elements;} 
		// Map.Entry
		for(Map.Entry m : smap.entrySet()) {
			//Map.Entry 인터페이스로 받으면 분리시킨다고 함
			System.out.println(m.getKey() +  " / " + ((Student)m.getValue()).name);
			//getValue() Student객체의 주소
			//(Student)다운캐스팅해서 원하는 값을 뽑아냄
		}
		/*
		 	hong / 홍길동
ki			m / 김유신
		 */
	}
}
