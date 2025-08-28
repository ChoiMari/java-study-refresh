package kr.or.kosa;

public class HamburgerStore { // 햄버거 가게
	
	private Hamburger[] refrigerator; //냉장고
	private int refIndex; // 냉장고 index
	private int money; // 매출
	
	public HamburgerStore() {
		refrigerator = new Hamburger[] {new Hamburger(),new Hamburger(),new Hamburger(), new Hamburger(), new Hamburger()};
		// 기본값 - 최대 5개까지 저장가능
	}
	
	// 햄버거 만들기
	public void makeHambugerAndStorage(Hamburger burger) { 
		burger.make();
		
		// 햄버거 냉장고에 보관
		if(refIndex >= refrigerator.length) { // 인덱스가 냉장고 배열 길이를 초과하면
			 System.out.println("냉장고가 가득차서 더이상 보관할 수 없습니다.\n만든 햄버거는 폐기 처리됩니다.\n");
			 return; 
		}
		refrigerator[refIndex++] = burger; 
		System.out.println("냉장보관 : " + burger.getName() + "\n");
	}
	
	// 햄버거 팔기
	public void sell(String hambugerName) {
		if(refIndex < 0) {
			System.out.println("[매진] 저장된 햄버거가 없습니다. 새로 만들어야 합니다.");
			return;
		}
		
		for(int i = 0 ;i < refrigerator.length; i++) { // 배열 전체 다 돌아야함
			if(refrigerator[i] != null) { // 냉장고 칸에 햄버거가 있으면 실행(배열이라서, null이 앞에 있어도 검사해야함)
				if(refrigerator[i].getName().equals(hambugerName)) {
					System.out.println(refrigerator[i].getName() + "가 판매되었습니다.\n" + "가격 : " + refrigerator[i].getPrice());
					money += refrigerator[i].getPrice(); //매출에 반영
					refrigerator[i] = null;
					refIndex--; 
					return;
				} 
			} 
			if(i == refrigerator.length -1 && refrigerator[i] == null) { //마지막까지 돌았는데 없는경우 실행
				System.out.println("주문하신 햄버거 없습니다. 다음에 다시 이용해주세요\n");
			}
		}//for문 끝
	}
	
	// 매출 확인
	public void printMoney() {
		System.out.println("현재 총 매출은 " + money + "원 입니다.");
	}

}
