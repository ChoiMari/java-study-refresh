/*
 Today Point
  향상된 for문
  JAVA : for(타입 변수명 : 배열 또는 Collection){}
  C# : for(타입 변수명 in 배열 또는 Collection){}
  javascript : for(타입 변수명 in 배열 또는 Collection){}
  							   of
 */
public class Ex03_Array_For {
	public static void main(String[] args) {
		int[] arr = {5,6,7,8,9};
		for(int i = 0;i < arr.length;i++) {
			System.out.println(arr[i]);
		}
		//개선된 for문
		for(int value : arr) { // 배열의 값을 뽑아줌
			System.out.println(value);
		}
		
		String[] strarr = {"A", "B", "C", "D", "E"};
		for(String str : strarr) {
			System.out.print(str + "\t");
		}
		System.out.println();
	}
}
