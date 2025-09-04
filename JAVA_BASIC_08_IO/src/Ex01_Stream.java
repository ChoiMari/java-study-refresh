/*
IO (input / output)

Stream(통로 : 중간매개체 : 데이터 흘러가는)

빨대 : 2가지 (Byte(image) , Char(문자열 데이터))

Stream 쓰지지면 [ Byte 통로 ] .... 

통로 : 이미지 , 파일 <>  문자 

JAVA API >>  클래스 제공
1.  I/0 의 기본 단위는 Byte > Byte 배열

추상 클래스 
InputStream .... OutPutStream 

클래스는  추상클래스를 상속 구현 (재정의)  

당신이 Byte 데이터 작업
입력 InputStream 상속 구현하는 클래스를 사용

입력을 할려고 하는 대상
1. Memory : ByteArrayInputStream >> Array , Collection  이미 메모리 사용
2. File   : FileInputStream  ******* ~~~~~

당신이 Byte 데이터 작업
출력 OutputStream 상속 구현하는 클래스를 사용

출력을 할려고 하는 대상
1. Memory : ByteArrayOutputStream >> Array , Collection  이미 메모리 사용
2. File   : FileOutputStream  ******* ~~~~~
*/
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
public class Ex01_Stream {

	public static void main(String[] args) {
		//FileInputStream 
		//FileOutputStream
		
		//byte (-128 ~ 127) 정수 
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null; //현재 outSrc 메모리를 가지고 있지 않아요
		
		//빨대 >> memory >> read , write
		ByteArrayInputStream input = null; //통로 
		ByteArrayOutputStream output = null; //통로
		
		input = new ByteArrayInputStream(inSrc);// input 대상 inSrc >> read
		output = new ByteArrayOutputStream(); //write
		
		System.out.println("outSrc before : " + Arrays.toString(outSrc));
		
		//공식같은 로직(암기)
		int data=0;
		while((data = input.read()) != -1) {
			//System.out.println(data);
			//read 데이터를 다른 stream 을 출력(담을)
			output.write(data); //출력통로 안에(빨대) 데이터를 담는 것
			//write 대상이 data 가 아니고 ByteArrayOutputStream 자신의 통로에 가지고 ...
			 
		}
		
		
		/*
		int data=0;
		while(input.read() != -1) {
			
			System.out.println(input.read());
			//read() 함수는 내부적으로 next()
			//1  3  5  7 9
		}
		*/
		outSrc = output.toByteArray(); //자신이 가지고 있는 데이터를  Byte[] 바꾸어서 
		System.out.println("outSrc after : " + Arrays.toString(outSrc));
		
	}

}
