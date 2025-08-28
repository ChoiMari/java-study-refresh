package kr.or.kosa;

public class BulgogiBurger extends Hamburger {
	//특성 : 패티, 불고기 소스
	public BulgogiBurger() { // 기본값
		super(new String[] {"패티"}, new String[] {"불고기 소스"}, 4500, "불고기버거"); // 부모 생성자 호출
	}
	
//	public BulgogiBurger(String[] ingredients, String[] sauces, int price, String name) {
//		super(ingredients, sauces, price, name); // 부모 생성자 호출
//	} 
	
	@Override
	public String make() {
		System.out.println("만드는 중...");
		String bulgogiBurger = "";
		String[] ingredients = getIngredients();
		String[] sauces = getSauces();
		
		bulgogiBurger += Hamburger.BREADS[0] + " + ";
		for(int j = 0;j < ingredients.length;j++) { // 재료 넣기
			if(ingredients[j] == null) break;
			
			bulgogiBurger += (ingredients[j].equals("패티")) ? 
					ingredients[j] + "(구움) + " :  ingredients[j] + " + ";
			
		}
		for(int k =0;k < sauces.length;k++) { //소스 넣기
			if(sauces[k] == null) break;
			bulgogiBurger += sauces[k] + " + ";
	
		}
		bulgogiBurger += Hamburger.BREADS[1];
		System.out.println(bulgogiBurger);
		System.out.println("불고기 버거가 완성되었습니다.\n----------------");
		return bulgogiBurger;
	}
}
