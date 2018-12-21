
public class testText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String t=",,,,java,,,,kk";
		t=t.replace(",,", ", ,");
		
		while(t.indexOf(",,")>-1) {
			t=t.replace(",,", ", ,");
		}
		System.out.println(t);
	}

}
