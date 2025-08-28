package kr.or.kosa;

public class MintChocolateBananaBurger extends Hamburger {
	//특성 : 바나나, 민트초코시럽
	public MintChocolateBananaBurger() {
		super(new String[] {"바나나"}, new String[] {"민트초코시럽"}, 5500, "민트초코바나나버거");
	}
	
//	public MintChocolateBananaBurger(String[] ingredients, String[] sauces, int price, String name) {
//		super(ingredients, sauces, price, name);
//	}
	
	@Override
	public String make() {
		System.out.println("만드는 중...");
		String mintChocoBananaBurger = "";
		String[] ingredients = getIngredients();
		String[] sauces = getSauces();
		mintChocoBananaBurger += Hamburger.BREADS[0];
		for(int j = 0;j < ingredients.length;j++) { // 재료 넣기
			if(ingredients[j] == null) break;
			
			mintChocoBananaBurger += ingredients[j] + " + "; 
			
		}
		for(int k =0;k < sauces.length;k++) { //소스 넣기
			if(sauces[k] == null) break;
			mintChocoBananaBurger += sauces[k] + " + ";
	
		}
		mintChocoBananaBurger += Hamburger.BREADS[1];
		System.out.println(mintChocoBananaBurger);
		System.out.println("민트초코바나나 버거가 완성되었습니다.\n----------------");
		return mintChocoBananaBurger;
	}
}
