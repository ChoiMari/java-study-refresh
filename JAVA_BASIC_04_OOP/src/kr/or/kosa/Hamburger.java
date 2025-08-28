package kr.or.kosa;

public class Hamburger {
	// 공통 - 빵, 재료, 소스, 가격
	private static final String[] BREADS = new String[] {"빵","빵"}; // 빵 2개
	private String[] ingredients; // 식재료 
	private String[] sauces; // 소스
	private int price; // 가격
	
	// 생성자
	public Hamburger() { // 기본값 설정
		this(new String[5], new String[6]); // 최대 재료 5개, 소스 6개
	}
	
	public Hamburger(String[] ingredients, String[] sauces) {	
		this.ingredients = ingredients;
		this.sauces = sauces;
	} //-> 나중에 (재료나 소스가) 늘어날 수도 있으므로 
	
	
	// 햄버거 만들기 - 오버라이드 강제(protected 사용)
	protected String make(String[] ingredients, String[] sauces) {
		String hambuger = "";
		for(int i = 0;i < BREADS.length;i++) {
			hambuger += BREADS[i];
			for(int j = 0;j < ingredients.length;j++) {
				if(ingredients[j] != null) {
					hambuger += ingredients[j];
				}
			}
			for(int k =0;k < sauces.length;k++) {
				if(sauces[k] != null) {
					hambuger += sauces[k];
				}
			}
			
		}
		System.out.println("햄버거가 완성되었습니다.");
		return hambuger;
	}
	
}
