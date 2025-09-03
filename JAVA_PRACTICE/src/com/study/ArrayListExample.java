package com.study;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Emp{
	private String name;
	private int sal;
	
	public Emp(String name, int sal) {
		this.name = name;
		this.sal = sal;	
	}
	
	public String getName() {
		return name;
	}
	
	public int getSal() {
		return sal;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", sal=" + sal + "]";
	}
	
}
public class ArrayListExample {
	/*
	 ArrayList<Integer>를 생성하고 정수 10, 20, 30을 차례대로 추가한 뒤,
		첫 번째 값과 마지막 값을 출력하세요. 
	 */
	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<>();
		nums.add(10);
		nums.add(20);
		nums.add(30);
		System.out.println(nums.getFirst());
		System.out.println(nums.getLast());
		// 구버전
		System.out.println(nums.get(0));
		System.out.println(nums.get(nums.size() -1));
		
		/*
		 문자열을 저장하는 ArrayList<String>를 만들고 "Java", "Python", "C++"을 추가한 후,
			"Python"을 삭제하고 나머지 요소들을 출력하세요. 
		 */
		List<String> strList = new ArrayList<>();
		strList.add("Java");
		strList.add("Python");
		strList.add("C++");
		strList.remove("Python"); //중복값이 있다면? 첫번째로 만나는 값을 삭제한다!
		// 대소문자를 구분한다!!
		/*
		 ArrayList.remove(Object o) 동작 원리
			리스트 안에 있는 객체 중 equals()가 true를 반환하는 첫 번째 요소를 삭제합니다.
			주소값(참조) 비교가 아니라, equals() 비교,  equals를 오버라이드하지 않으면 주소 비교
			(중요!!)
			String, Integer 등은 이미 equals()가 재정의되어 있어서 값 비교 가능
			**사용자 정의 객체는 equals()를 오버라이드해야 데이터 값으로 삭제 가능**
		 */
		// 방법 1
		System.out.println(strList);
		
		// 방법 2
		for(String s:strList) {
			System.out.println(s);
		}
		
		// 방법 3
		for(int i = 0;i < strList.size();i++) {
			System.out.println(strList.get(i));
		}
		
		// 방법 4
		Iterator<String> it = strList.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		// 방법 5
		strList.stream().forEach(System.out::println);
		
		/*
		 ArrayList<Double>에 5개의 실수를 입력받아 저장한 뒤,
			전체 합계와 평균을 구하는 프로그램을 작성하세요. 
		 */
//		double sum = 0;
//		double avg = 0;
//		List<Double> dList = new ArrayList<>();
//	
//		try(Scanner sc = new Scanner(System.in)){ // 자동으로 닫아줌
//			int count = 0;
//			while(count < 5) { // 5번 입력받으면 멈춤
//				System.out.print("실수 입력 : ");
//				try { // 예외가 나도 반복되도록 try로 더 감쌈
//					double input = Double.parseDouble(sc.nextLine());
//					dList.add(input);
//					count++;
//				}catch(NumberFormatException ex) { //NumberFormatException 변환이 불가능한 경우 발생하는 예외
//					System.out.println("[입력 오류] : 실수값으로 다시 입력해주세요");
//				}
//			}
//		}catch(Exception e) {
//			System.out.println("입력오류 : 실수값으로 입력해주세요");
//			e.printStackTrace();
//		}
////		for(int i = 0;i < dList.size();i++) {
////			sum += dList.get(i);
////			if(i == dList.size() - 1) {
////				avg = sum / dList.size();
////			}
////		}
////		System.out.println("합계 : " + sum + ", 평균 : " + avg);
//		
//		for(double d : dList) {
//			sum += d;
//		}
//		
//		System.out.printf("합계  : %.2f , 평균 : %.2f\n", sum, (sum / dList.size()));
		
		/*
		 학생 이름을 저장하는 ArrayList<String>를 만들고,
			"철수", "영희", "민수"를 추가한 후,
			"민수"가 있는지 검색해서 있으면 "찾았다!"를 출력하세요.
			정수형 ArrayList<Integer>에 1부터 20까지 값을 넣고, 짝수만 출력하세요.
				
		 */
		List<String> students = new ArrayList<String>();
		students.add("철수");
		students.add("영희");
		students.add("민수");
		if(students.contains("민수")) {
			System.out.println("찾았다!");
		}
		
		List<Integer> numbers = new ArrayList<>();
		for(int i = 1;i <= 20;i++) {
			numbers.add(i);
		}
		
		for(int num :numbers) {
			if(num % 2 == 0) {
				System.out.print(num + " ");
			}
		}
		System.out.println();
		/*
		 문자열 ArrayList<String>에 과일 이름 "apple", "banana", "cherry"를 넣고,
				모든 문자열을 대문자로 변환해서 출력하세요. (힌트: set() 활용)  
		 */
		
		List<String> fruits = new ArrayList<String>();
		fruits.add("apple");
		fruits.add("banana");
		fruits.add("cherry");
		for(String s : fruits) {
			System.out.println(s.toUpperCase()); // 리스트 원본은 그대로, 출력 형태만 대문자로 변경
		}
		
		for(int i = 0;i < fruits.size();i++) {
			fruits.set(i, fruits.get(i).toUpperCase()); // 원본값을 대문자로 바꿈
			// 인덱스 i번째를 다음 값으로 바꿈
			System.out.println(fruits.get(i));
		}
		System.out.println(fruits);
		
		/*
		 ArrayList<Integer>에 랜덤한 로또 번호 6개(1~45)를 중복 없이 저장한 뒤 출력하세요.
			사용자로부터 입력받은 단어들을 ArrayList<String>에 저장하다가 "exit"을 입력하면 종료하고,
			지금까지 저장된 단어들을 출력하세요.
		직원(Employee) 객체를 담는 ArrayList<Employee>를 만들고,
			직원 이름과 급여를 저장한 뒤,
			급여가 3000 이상인 직원만 출력하세요. 
		 */
		List<Integer> lotto = new ArrayList<Integer>();
		while(lotto.size() < 6) { // 6개 되면 멈춤
			int num = (int)(Math.random() * 45) + 1;
			if(!lotto.contains(num)) { //중복없으면
				lotto.add(num); //저장
			}
		}
		System.out.println(lotto);
		
		List<Emp> emps = new ArrayList<>();
		emps.add(new Emp("홍길동", 1000));
		emps.add(new Emp("임꺽정", 3000));
		emps.add(new Emp("이몽룡", 5000));
		for(Emp e : emps) {
			if(e.getSal() >= 3000) {
				System.out.printf("이름 : %s , 급여 : %d \n",e.getName(),e.getSal());
				System.out.println(e.toString());
			}
			
		}
	
	

	}
}
