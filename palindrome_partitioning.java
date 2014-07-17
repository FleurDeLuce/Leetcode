/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
*/

// Solution: DFS
// Time complexity: O(2^n), Space complexity: O(n)
public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

        if (s == null || s.length() == 0) return result;
        ArrayList<String> partition = new ArrayList<String>();
        searchParition(s, 0, partition, result);
        return result;
    }

    public void searchParition(String s, int start, ArrayList<String> partition, ArrayList<ArrayList<String>> result) {
        if (start >= s.length()) {
            result.add(new ArrayList<String>(partition));
            return;
        }

        int strLen = s.length();
        for (int i = start + 1; i <= strLen; i++) {
            String firstPart = s.substring(start, i);
            if (checkPalindrome(firstPart)) {
                partition.add(firstPart);
                searchParition(s, i, partition, result);
                // unsure if this partition works, then removes the cut until 
                // proved the whole palindrome partitioning successful
                partition.remove(partition.size() - 1);
            }
        }
    }

    public boolean checkPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            else {
                start++;
                end--;
            }
        }
        return true;
    }
}