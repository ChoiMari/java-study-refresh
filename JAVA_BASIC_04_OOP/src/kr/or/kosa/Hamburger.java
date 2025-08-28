package kr.or.kosa;

public class Hamburger {
	// 공통 - 빵, 재료, 소스, 가격
	public static final String[] BREADS; //= new String[] {"빵","빵"}; // 빵 2개
	// static이라서 생성자 호출 이전에 초기화 되어야함
	// static{} 안에 작성하거나 기본 초기화 시켜놓아야한다.
	static {
		BREADS = new String[] {"빵","빵"};
	}
	
	private String[] ingredients; // 식재료 
	private String[] sauces; // 소스
	private int price; // 가격
	private String name; // 햄버거 명
	
	// 생성자
	public Hamburger() { // 기본값 설정
		this(new String[] {"패티"}, new String[] {"마요네즈"}, 2000, "햄버거"); // 최대 재료 5개, 소스 6개
	}
	
	public Hamburger(String[] ingredients, String[] sauces, int price, String name) {	
		this.ingredients = ingredients;
		this.sauces = sauces;
		this.price = price;
		this.name = name;
	} 
	
	
	// 햄버거 만들기 - 오버라이드 강제(protected 사용) - 외부에서 객체에서 접근 시 자식클래스에서 오버라이드 해야만 쓸 수 있음
	protected String make() {
		System.out.println("만드는 중...");
		String hambuger = "";
		hambuger += BREADS[0] + " + ";
		for(int j = 0;j < ingredients.length;j++) { // 재료 넣기
			if(ingredients[j] == null) break;
			
			hambuger += (ingredients[j].equals("패티")) ? 
					ingredients[j] + "(구움) + " :  ingredients[j] + " + ";
		}
		for(int k =0;k < sauces.length;k++) { //소스 넣기
			if(sauces[k] == null) break;
			hambuger += sauces[k] + " + ";
	
		}
		hambuger += BREADS[1];
		System.out.println(hambuger);
		System.out.println("햄버거가 완성되었습니다.\n----------------");
		return hambuger;
	}

	public String[] getIngredients() {
		return ingredients;
	}

	public String[] getSauces() {
		return sauces;
	}

	public int getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}
	
	
	
}
