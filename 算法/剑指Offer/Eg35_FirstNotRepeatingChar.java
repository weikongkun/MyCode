package JianZhiOffer;

import java.util.HashMap;

public class Eg35_FirstNotRepeatingChar {
	public int FirstNotRepeatingChar(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) 
        	if (!map.containsKey(str.charAt(i)))
        		map.put(str.charAt(i), 1);
        	else
        		map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
        
        for (int i = 0; i < str.length(); i++)
        	if (map.get(str.charAt(i)) == 1)
        		return i;
        return 0;
    }
}
