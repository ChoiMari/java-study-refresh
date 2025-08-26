/*
 배열은 객체다(Array)
 1. new를 통해서 생성함(주소값)
 2. heap 메모리에 생성됨(관리 - 가비지컬렉터의 관리 대상) 
 3. 정적(고정)배열 : 배열은 한 번 정해지면 그 크기를 변경할 수 없다.
 4. 동적 배열(Collection : API클래스) : ArrayList, HashSet, HashMap
 5. 자료구조(알고리즘) : 제어문 + 결합(기초적인 자료구조) 
 */
import java.util.Arrays;
public class Ex01_Array {
	public static void main(String[] args) {
//		int s, s2, s3, s4;
//		int s5;
//		int s6;
		// 같은 타입의 변수 여러개를 선언해서 사용할 땐,
		// 별로 좋지 않은 방법
		
		// 배열
		int[] score = new int[5]; // int타입 5칸을 저장할 수 있는 1차원 배열
		// score(101동) -> 101호, 102호, 103호
		// int타입 방 5개 만듬 (heap의 연속된 공간에 할당)
		// 방이름은 index(첨자)로 정함
		// [0][1][2][3][4] 
		System.out.println(score[0]);
		score[0] = 100;
		score[1] = 200;
		score[2] = 300;
		score[3] = 400;
		score[4] = 500;
		
		//score[5] = 600;//IndexOutOfBoundsException
		
		//출력 - Array 방에 있는 모든 값을 한 번에 출력
		for(int i = 0;i < score.length;i++) { // score.length 배열의 개수를 리턴
			System.out.printf("[%d]=%d\t",i, score[i]);
		}
		System.out.println();
		// 배열은 객체
		// 사용자가 만드는 모든 배열은 Object를 상속

		// java.util.Arrays
		String resultArray = Arrays.toString(score);
		//for문을 몰라도 Arrays helper 클래스 - 초급자 접근 금지
		System.out.println(resultArray);//[100, 200, 300, 400, 500]
		//java가 toString()을 재정의해서 배열을 출력해줌
		
		// 주말(버블정렬, 퀵정렬)
		
		// Today Point 
		// 배열 만드는 방법 3가지
		int[] arr1 = new int[5]; //기본
		int[] arr2 = new int[] {10,20,30,40,50}; 
		//초기값을 통해 배열값을 정의하고 값을 할당
		int[] arr3 = {11,22,33}; // 컴파일러가 알아서 new 처리해준다
		
		// 자바스크립트에서는..
		//const arr = [1,2,3,4,5]; let arr = [] 
		// arr.push(1), arr.pop() 자료구조 stack이라고
		// 자바스크립트 배열은 default가 컬렉션
		// stack자체가 컬렉션
		// 자바스크립트의 배열은 전부 동적 배열
		
		for(int i = 0;i < arr2.length;i++) {
			System.out.print(arr2[i]+ "\t");
		}
		
		System.out.println();
		
		int[] arr4; //arr4는 null저장됨(주소값이 없으니까), 배열도 객체
		// null의 의미 : (참조하고 있는 메모리의)주소값을 가지고 있지 않다
		arr4 = new int[] {1,2,3,4,5};
		System.out.println(arr4);
		int[] arr5 = arr4; // arr4의 주소값저장 -> 같은 주소를 바라봄
		System.out.printf("arr4 == arr5 : %b\n", arr4 == arr5);
		
		String[] strarr = new String[] {"가","나","다","라"};
		for(String s : strarr) {
			System.out.println(s);
		}
		
		char[] carr = {'a','b'};
		float[] farr = {3.14f, 0.12f};
		
		// Today Point 객체 배열
		// Car[] cars = new Car[3];
		/*
		  cars[0] = new Car();
		  cars[1] = new Car();
		  cars[2] = new Car();
		  그림 그려서 확인하기
		 */
	}
}

class Car{
	int door;
}