package JianZhiOffer;

public class Eg42_1ReverseWordsInSentence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ReverseSentence("abc"));
	}
	
	public static String ReverseSentence(String str) {
		StringBuffer sb = new StringBuffer(str);
		ReverseSubSentence(sb, 0, sb.length() - 1);
		int lo = 0, hi = 0;
		while (hi < sb.length()) {
			if (hi < sb.length() - 1) {
				if (sb.charAt(hi) == ' ') {
					ReverseSubSentence(sb, lo, hi - 1);
					lo = hi + 1;
				}
				hi++;
			}
			else if(hi == sb.length() - 1) {
				ReverseSubSentence(sb, lo, hi);
				break;
			}
		}
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
