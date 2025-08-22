import ko.or.kosa.Tv;

public class Ex03_Ref_Method_Call {

	public static void main(String[] args) {
		//TV 한 대 만들어라
		// -> 메모리에 올려라(heap메모리에)
		
		Tv lgTv = new Tv();
		lgTv.brandName = "LG";
		lgTv.infoPrint();
		
		lgTv.channelUp();
		lgTv.channelUp();
		lgTv.channelUp();
		lgTv.channelDown();
		
		lgTv.infoPrint();
		
		Tv ssTv = new Tv();
		ssTv.brandName = "SS";
		ssTv.channelUp();
		ssTv.channelUp();
		ssTv.channelUp();
		ssTv.channelDown();
		ssTv.channelDown();
		
		ssTv.infoPrint();

	}

}
