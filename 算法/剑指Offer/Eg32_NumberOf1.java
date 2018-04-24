package JianZhiOffer;

public class Eg32_NumberOf1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(NumberOf1Between1AndN_Solution(99));

	}
	
	public static int NumberOf1Between1AndN_Solution(int n) {
		if (n <= 0) return 0;
		String str = String.valueOf(n);
		
		int res = 0;
		//区间的最大数和最小数
		int max = n, min = 0;
		//最大数的字符串表示
		String s = str;
		while (true) {
			max = Integer.valueOf(s);
			min = Integer.valueOf(s.substring(1)) + 1;
			
			if (Integer.valueOf(s.charAt(0) + "") > 1) res += (int)Math.pow(10, s.length() - 1);
			else res += min;
			System.out.println(res);
			int j = ((int)Math.pow(10, s.length() - 2)) * (Integer.valueOf(s.charAt(0) + "")) * (s.length() - 1);
			res = res + j;
			System.out.println(max + " " + min + " " + res);
			if (min <= 10) break;
			s = s.substring(1);
		}
		if(str.charAt(str.length() - 1) != '0') res++;
		return res;
	}

}
