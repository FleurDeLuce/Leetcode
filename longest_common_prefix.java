/*
Write a function to find the longest common prefix string amongst an array of strings.
*/
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        
        int numStr = strs.length;
        int minLenStr = strs[0].length();
        for (int i = 0; i < numStr; i++) {
            if (strs[i].length() < minLenStr) 
                minLenStr = strs[i].length();
        }
    
        for (int i = 0; i < minLenStr; i++) {
            for (int j = 0; j < numStr; j++) {
                if (strs[0].charAt(i) != strs[j].charAt(i)) minLenStr = i;
            }
        }
        return strs[0].substring(0, minLenStr);
    }
}

// solution two
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        
        int numStr = strs.length;
        int minLenStr = strs[0].length();
        for (int i = 0; i < minLenStr; i++) {
            for (int j = 0; j < numStr; j++) {
                if (strs[0].charAt(i) != strs[j].charAt(i)) return strs[0].substring(0, j);
            }
        }
        return strs[0];
    }
}

