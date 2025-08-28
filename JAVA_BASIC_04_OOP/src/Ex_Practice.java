import kr.or.kosa.BulgogiBurger;
import kr.or.kosa.ChickenBurger;
import kr.or.kosa.Hamburger;
import kr.or.kosa.HamburgerStore;
import kr.or.kosa.MintChocolateBananaBurger;

public class Ex_Practice {

	public static void main(String[] args) {
		HamburgerStore hamburgerStore = new HamburgerStore(); // 햄버거 가게 만듬
		
		Hamburger hamburger = new Hamburger(); // 기본햄버거
		Hamburger chickenBurger = new ChickenBurger(); // 다형성
		Hamburger bulgogiBurger = new BulgogiBurger();
		Hamburger mintChocolateBananaBurger = new MintChocolateBananaBurger();
		Hamburger mintChocolateBananaBurger2 = new MintChocolateBananaBurger();
		Hamburger mintChocolateBananaBurger3 = new MintChocolateBananaBurger();
		
		// 만들기 + 저장
		hamburgerStore.makeHambugerAndStorage(hamburger);
		hamburgerStore.makeHambugerAndStorage(chickenBurger);
		hamburgerStore.makeHambugerAndStorage(bulgogiBurger);
		hamburgerStore.makeHambugerAndStorage(mintChocolateBananaBurger);
		hamburgerStore.makeHambugerAndStorage(mintChocolateBananaBurger2);
		hamburgerStore.makeHambugerAndStorage(mintChocolateBananaBurger3);
		
		// 판매
		hamburgerStore.sell("치킨버거"); //TODO : enum
		hamburgerStore.sell("불고기버거");
		hamburgerStore.sell("햄버거");
		hamburgerStore.sell("민트초코바나나버거");
		hamburgerStore.sell("민트초코바나나버거");
		hamburgerStore.sell("민트초코바나나버거");
		
		// 매출확인
		hamburgerStore.printMoney();
		
	}

}
