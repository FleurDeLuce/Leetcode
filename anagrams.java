/*
Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.
*/
// Time Complexity: O(n)*O(mlogm), where m is the max word length, or a constant, which turns time complexity to O(n),
// Space Complexity: O(n)
public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> res = new ArrayList<String>();
        if (strs == null || strs.length <= 1) return res;
        
        HashMap<String, ArrayList<String>> hash = new HashMap<String, ArrayList<String>>();
        for (String str : strs) {
            // find alphagram for each word
            String alphagram = alphagram(str);
            if (hash.containsKey(alphagram)) {
                hash.get(alphagram).add(str);
            }
            else {
                ArrayList<String> list = new ArrayList<String>();
                list.add(str);
                hash.put(alphagram, list);
            }
        }
        
        Set<String> keys = hash.keySet();
        for (String key : keys) {
            ArrayList<String> list = hash.get(key);
            if (list.size() > 1) res.addAll(list);
        }
        return res;
    }
    
    public String alphagram(String str) {
        // sort word alphabetically
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        // return new String(ch);
        return String.valueOf(ch);
    }
}