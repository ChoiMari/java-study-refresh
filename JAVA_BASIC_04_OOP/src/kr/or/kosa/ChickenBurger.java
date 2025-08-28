package kr.or.kosa;

public class ChickenBurger extends Hamburger {
	// 특성 - 치킨, 파인애플
	public ChickenBurger() {
		super(new String[] {"치킨", "파인애플"}, new String[] {}, 5000, "치킨버거");
	}
	
//	public ChickenBurger(String[] ingredients, String[] sauces, int price, String name) {
//		super(ingredients, sauces, price, name);
//	}
	
	@Override
	public String make() {
		System.out.println("만드는 중...");
		String chickenBurger = "";
		String[] ingredients = getIngredients();
		String[] sauces = getSauces();
		chickenBurger += Hamburger.BREADS[0] + " + ";
		for(int j = 0;j < ingredients.length;j++) { // 재료 넣기
			if(ingredients[j] == null) break;
			
			chickenBurger += (ingredients[j].equals("치킨")) ? 
					ingredients[j] + "(구움) + " :  ingredients[j] + " + ";
			
		}
		for(int k =0;k < sauces.length;k++) { //소스 넣기
			if(sauces[k] == null) break;
			chickenBurger += sauces[k] + " + ";
	
		}
		chickenBurger += Hamburger.BREADS[1];
		System.out.println(chickenBurger);
		System.out.println("치킨 버거가 완성되었습니다.\n----------------");
		return chickenBurger;
	}
}
