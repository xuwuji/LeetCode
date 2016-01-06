package string.easy;

import java.util.HashMap;

/**
 * Given a roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * 【罗马数字】
 * 
 * 1~9: {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
 * 
 * 10~90: {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
 * 
 * 100~900: {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
 * 
 * 1000~3000: {"M", "MM", "MMM"}.
 * 
 * @author wuxu
 * @time 2016年1月6日
 */
public class RomantoInteger13 {
	public int romanToInt(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		int count = 0;
		int i = 0;
		for (; i < s.length() - 1;) {
			if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
				count += map.get(s.charAt(i));
				i++;
			} else {
				count += map.get(s.charAt(i + 1)) - map.get(s.charAt(i));
				i = i + 2;
			}
		}
		if (i == s.length() - 1) {
			count += map.get(s.charAt(i));
		}
		return count;
	}

}
