/*
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
 */

// Solution
// Time complexity: O(num), Space complexity: O(1)
public class Solution {
    public String intToRoman(int num) {
    	String str = new String();
    	String romanSymbols[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};  
    	int values[] = {1000,900,500,400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int len = romanSymbols.length;
        HashMap<Integer, String> map = new HashMap();
        for (int i = 0; i < len; i++) {
        	map.put(values[i], romanSymbols[i]);
        }

        for (int i : values) {
        	while (num >= i) {
        		num -= i;
        		str += map.get(i);
        	}
        }
        return str;
    }
}
