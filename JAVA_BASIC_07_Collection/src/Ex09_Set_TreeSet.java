import java.util.Set;
import java.util.TreeSet;

public class Ex09_Set_TreeSet {
	public static void main(String[] args) {
		//Set : 순서를 보장 X, 중복 X
		
		/*
		  TreeSet : 순서X(인덱스X), 중복 X, 정렬 O (정렬에 트리구조가 필요함)
			-> 로또에 사용
			순서가 없는데 중복허용 안하는데 정렬되길 원하는 데이터에 TreeSet 사용
			데이터 저장 시 정렬 기능 제공(정렬해서 값을 저장함)
		 */
		
		Set<Integer> lotto = new TreeSet<>();
		for(int i = 0;lotto.size() < 6;i++) {
			lotto.add((int)(Math.random()*45 + 1));
		}
		System.out.println(lotto); // [5, 6, 7, 19, 20, 42]
	}
}
