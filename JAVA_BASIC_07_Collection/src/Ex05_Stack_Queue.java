

import java.util.Stack;

import kr.or.kosa.MyStack;

public class Ex05_Stack_Queue {
	public static void main(String[] args) {
		//자바 API가 제공해주는 클래스
		
		//Stack -> LIFO : 후입선출
		Stack stack = new Stack();
		stack.push("A");
		stack.push("B");
		stack.push("C");
		
		System.out.println(stack.pop()); 
		System.out.println(stack.pop()); 
		System.out.println(stack.pop()); 
		//마지막에 넣은것 부터 나옴(후입선출)
		// C, B, A
		
		System.out.println(stack.empty()); // 비어있는지 확인
		// true
		//System.out.println(stack.pop()); // EmptyStackException
		//예외 발생
		
		//자바스트립트 array 자료구조 : stack
		//데이터 push로 넣고, pop으로 뽑음
		
		//일상생활의 예) 동전 케이스, 연탄, 핸드폰 화면(맨위에 전화화면이 올라옴, 끊기면 원래보던화면)
		// 늦게 넣은걸 먼저 뺌
		
		MyStack my = new MyStack(5);
		my.push(10);
		my.push(20);
		my.push(30);
		my.push(40);
		my.push(50);
		System.out.println(my.pop());
		System.out.println(my.pop());
		System.out.println(my.pop());
		System.out.println(my.pop());
		System.out.println(my.pop());
		System.out.println(my.pop());
		// 후입 선출 : 먼저 넣은게 먼저 나감 LIFO
		
	}
}
