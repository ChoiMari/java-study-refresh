import java.util.ArrayList;
import java.util.List;

import kr.or.kosa.Emp;

class Product{  //extends Object
	int price;
	int bonuspoint;
	//Product() {	}
	Product(int price) {
		this.price = price;
		this.bonuspoint = (int)(this.price/10.0);
	}
	
}

class KtTv extends Product{
	KtTv(){
		super(500);
	}
	
	//Object 재정의 
	@Override
	public String toString() {
		return "KtTv";
	}
}

class Audio extends Product{
	Audio(){
		super(100);
	}
	
	@Override
	public String toString() {
		return "Audio";
	}
}

class NoteBook extends Product{
	NoteBook(){
		super(150);
	}
	
	@Override
	public String toString() {
		return "NoteBook";
	}
}

public class Ex06_Generic_Product {
	public static void main(String[] args) {
		//1. Array(정적 배열) 사용해서 객체 생성
		// KtTv , Audio , NoteBook 을 담을수 있는 Cart 만드세요
//		List<KtTv> kCart = new ArrayList<>();
//		List<Audio> aCart = new ArrayList<>();
//		List<NoteBook> nCart = new ArrayList<>();
		Product[] cart = new Product[10];
		cart[0] = new KtTv();
		cart[1] = new Audio();
		cart[2] = new NoteBook();
		//2. ArrayList 를 사용해서 Cart 를 만드세요
		List<Product> pCart = new ArrayList<>();
		pCart.add(new KtTv());
		pCart.add(new NoteBook());
		pCart.add(new Audio());
		//Emp
		//3. ArrayList 를 사용해서 사원 3명 만드세요
		List<Emp> empList = new ArrayList<>();
		empList.add(new Emp(10,"홍길동","IT"));
		empList.add(new Emp(20,"임꺽정","영업"));
		empList.add(new Emp(30,"이몽룡","IT"));
				
		//3.1 사원의 정보를 toString() 사용하지 말고 사번 , 이름 , 직종을 출력하세요
		//개선된 for문
		for(Emp e:empList) {
			System.out.println("사번 : " + e.getEmpno() + ", 이름 : " + e.getName() + ", 직종 : " + e.getJob());
		}	
				
				
		//3.2 3.1과 동일한데  일반 for문을 사용해서 사번 , 이름 , 직종을 출력하세요
		for(int i = 0;i < empList.size();i++) {
			System.out.println("사번 : " + empList.get(i).getEmpno() + ", 이름 : " + empList.get(i).getName() + ", 직종 : " + empList.get(i).getJob());
			
		}
	}
}
