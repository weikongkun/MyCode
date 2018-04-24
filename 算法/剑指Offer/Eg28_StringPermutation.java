package JianZhiOffer;
import java.util.ArrayList;

public class Eg28_StringPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abb";
		ArrayList<String> ans = Permutation(str);
		System.out.println(ans);
	}
	
	public static ArrayList<String> Permutation(String str) {
		
	    ArrayList<String> list = new ArrayList<String>();
	    char[] cs = str.toCharArray();
	    char[] ans = new char[cs.length];
	    if (str != null && str.length() > 0) {
	    	Permutation(cs, ans, list, 0);
	    }
	    return list;
    }
	
	public static void Permutation(char[] cs, char[] ans, ArrayList<String> list, int cur) {
		if (cur == cs.length && !list.contains(String.valueOf(ans))) 
			list.add(String.valueOf(ans));
		else for (int i = 0; i < cs.length; i++) {
			boolean ok = true;
			for (int j = 0; j < cur; j++)
				if (cs[i] == ans[j]) ok = false;
			if (ok) {
				ans[cur] = cs[i]; 
				Permutation(cs, ans, list, cur + 1);
			}
				
		}
	}
	
}
