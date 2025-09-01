package kr.or.kosa;

public class MyStack {
	// 저장하는 데이터를 배열 만들기
	// 정적배열로 만듬 - 크기 정하기
	private Object[] stackArr; // 데이터 저장소
	private int top; // 배열의 인덱스 값 저장
	private int maxSize; // 최대 크기
	
	public MyStack(int maxSize) { // 배열 크기는 외부에서 받음
		stackArr = new Object[maxSize];
		this.top = -1;
		this.maxSize = maxSize;
	}
	
	// 배열의 push()
	public void push(Object obj) {
		if(isFull()) {
			throw new IndexOutOfBoundsException("[예외 발생]저장 가능한 인덱스 범위를 초과하였습니다.");
		}
		stackArr[++top] = obj;//index를 -1로 잡아서 전치로
		
	}
	
	// pop()
	public Object pop() {
		Object value = null;
		if(isEmpty()) {
			System.out.println("mystack empty");
		}else {
			value = this.stackArr[top];
			top--;
		}
		return value;
	}
	
	// isEmpty 
	public boolean isEmpty() {
		return (top == -1);
	}
	
	// full 
	public boolean isFull() {
		return (top == this.maxSize -1); // [0][1][2][3][4] 5개
		// 4가 되면 full이다
	}
	

}
