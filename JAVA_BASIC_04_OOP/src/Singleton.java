
public class Singleton {
	private static Singleton p; // null
	
	private Singleton() {} // new 못하게 막음
	
	public static Singleton getInstance() {
		if(p == null) {
			p = new Singleton();
		}
		return p;
	}
}
