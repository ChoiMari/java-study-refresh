/*
  private 
  default (같은 폴더 package 내에서 접근 가능)
  public 
  상속 관계에서 접근 가능(+같은 패키지 내에서도 접근 가능) protected
  
  protected 접근자의 양면성
  	상속이 없는 클래스 멤버 필드에 protected를 쓰면
  	 ->같은 패키지 내에서 사용 가능함
  	 상속 관계에서는 protected를 쓰면 public 처럼 사용 가능
  	 
  protected를 사용하는 이유 : 주로 메서드에 사용됨 
  -> 오버라이드(재정의)를 했으면 좋겠다는 의미
  -> 그래야 너가 사용이 가능하다(강제성, 오버라이드 강제성 부여함)
  (멤버 필드로는 거의 안쓴다) 
  -> 자식 클래스 안에서는 호출 가능하지만 외부에서 자식객체로 접근을 못함
  -> 그래서 자식 메서드에서 public 더 넓은 범위로 오버라이드 해야 사용 가능
  -> 사용하려면 자식 클래스에서 오버라이드 강제성 부여.
 */
import kr.or.kosa.Pclass;

class Dclass{
	public int i;
	private int p;
	int s; // default : 같은 패키지에서만 접근 가능
	protected int k; //-> 상속 관계가 아니면 default 접근제한자와 와 같음

}

class Child2 extends Pclass{
	void method() {
		this.k = 100; //상속 관계에서는 protected가 public처럼 접근 가능함
		// 다른 패키지여도 상속관계에 protected접근제한 붙이면
		// 접근 가능.
		System.out.println(this.k);
	}
	
	@Override //재정의를 해주어야(객체로 사용했을 때 외부로 호출해서) 볼 수 있음
	public void m() {
		System.out.println("재정의");
		//super.m(); : 부모 메서드 호출하고 싶을 때 사용
	}
	
}

public class Ex08_Inherit_Protected {

	public static void main(String[] args) {
		Pclass p = new Pclass();
		p.setI(100);
		Child2 c2 = new Child2();
		c2.method();
		c2.m();
		
	}

}
