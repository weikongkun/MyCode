package JianZhiOffer;

public class Eg4_RaplaceSpace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer str = new StringBuffer("hello world");
		System.out.println(replaceSpace(str));

	}
	
	public static String replaceSpace(StringBuffer str) {
		int len = str.length();
		int numOfSpace = 0;
		for (int i = 0; i < len; i++)
			if (str.charAt(i) == ' ')
				numOfSpace++;
//		System.out.println("numOfSpace: " + numOfSpace);
		
		String strapend = "";
		for (int i = 0; i < numOfSpace; i++)
			strapend += "  ";
		str.append(strapend);
//		System.out.println("len: " + len + "\n" + str.length());
		
		int k = numOfSpace * 2 + len - 1;
		int t = len - 1;
//		System.out.println("k: " + k + "\n" + "t: " + t);
		while (k >= 0) {
			if (str.charAt(t) != ' ') {
				str.setCharAt(k--, str.charAt(t--));
			}
			else {
				str.setCharAt(k--, '0');
				str.setCharAt(k--, '2');
				str.setCharAt(k--, '%');
				t--;
			}
				
		}
		return str.toString();
		
	}

}
