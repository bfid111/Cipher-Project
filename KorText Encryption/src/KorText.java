
public class KorText {
	
	public static void main(String[] args){
		KorTextConverter sample = new KorTextConverter("hello123");
		sample.convert();
		System.out.println(sample.returnConverted());
	}
}