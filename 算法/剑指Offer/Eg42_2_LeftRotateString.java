package JianZhiOffer;

public class Eg42_2_LeftRotateString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = null;
		System.out.println(LeftRotateString("abc", 1));
	}
	
//	public static String LeftRotateString(String str,int n) {
//		if (str == null || str == "")return "";
//        int num = n % str.length();
//        StringBuffer sb = new StringBuffer(str);
//        String firstNOfStr = sb.substring(0, num);
//        for (int i = num; i < sb.length(); i++)
//            sb.setCharAt(i - num, sb.charAt(i));
//        System.out.println(sb);
//        sb.delete(sb.length() - num, sb.length());
//        System.out.println(sb);
//        sb.append(firstNOfStr);
//        System.out.println(sb);
//        return sb.toString();
//    }
	 public static String LeftRotateString(String str,int n) {
	        if (str == null || str.length() == 0) return "";
	        int num = n % str.length();
	        StringBuffer sb = new StringBuffer(str);
	        ReverseSubSentence(sb, 0, num - 1);
	       	ReverseSubSentence(sb, num, sb.length() - 1);
	        ReverseSubSentence(sb, 0, str.length() - 1);
	        return sb.toString();
	    }
	    public static void  ReverseSubSentence(StringBuffer sb, int lo, int hi) {
			while (lo < hi) {
				char ch = sb.charAt(lo);
				sb.setCharAt(lo, sb.charAt(hi));
				sb.setCharAt(hi, ch);
				lo++;
				hi--;
			}
		}

}
