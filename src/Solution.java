import java.util.HashMap;

public class Solution {
	public String fractionToDecimal(int numerator, int denominator) {
        HashMap<Long, Integer> m = new HashMap<Long, Integer>();
        int s1 = numerator < 0 ? -1 : 1;
        int s2 = denominator < 0 ? -1 : 1;
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        long rem = num % den;
        long out = num / den;
        String res = "";
        res += Long.toString(out);
        if(s1 * s2 == -1 && (rem > 0 || out > 0))
        	res = "-" + res;
        if(rem == 0)
        	return res;
        res += ".";
        String s = "";
        int pos = 0;
        while(rem != 0){
        	if(m.containsKey(rem)){
        		StringBuilder str = new StringBuilder(s);
        		str.insert(m.get(rem), "(");
        		s = str.toString();
        		s += ")";
        		return res + s;
        	}
        	
        	m.put(rem, pos);
        	s += Long.toString((rem * 10) / den);
        	rem = (rem * 10) % den;
        	pos ++;
        }
        
        return res + s;
	}
}
