/*
 Given a digit string, return all possible letter combinations that the number could represent.
 
 A mapping of digit to letters (just like on the telephone buttons) is given below.
 
 
 
 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 Note:
 Although the above answer is in lexicographical order, your answer could be in any order you want.
 */

// Solution
// Time complexity: O(), Space complexity: O()
public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> res = List<String>();
        if (digits == null || digits.length == 0)
            return res;
        for (int i = 0; i < digits.length(); i++) {
            String combination = getLetter(digits.charAt(it
                                                         ));
            ArrayList<String> curList = new ArrayList<String>();
            for (int j = 0; j < res.length; j++) {
                for (int k = 0; k < combination.length(); k++) {
                    curList.add(combination);
                }
            }
            res.add(curList);
        }
        
    }
    
    public List<String> getCombination(String digits, int index, List<String> curList) {
        
    }
    
    public String getLetter(char digit) {
        switch(digit) {
                case '1':
                    return "";
                case '2':
                    return "abc";
                case '3':
                    return "def";
                case '4':
                    return "ghi";
                case '5':
                    return "jkl";
                case '6':
                    return "mno";
                case '7':
                    return "pqrs";
                case '8':
                    return "tuv";
                case '9':
                    return "wxyz";
                case '0':
                    return " ";
                default:
                    return "";
        }
    }
}

// solution: recursion
public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> res = List<String>();
        if (digits == null || digits.length == 0)
            return res;
        
    }
    
    public List<String> getCombination(String digits, int index, List<String> curList) {
        
    }
    
    public String getLetter(char digit) {
        switch(digit) {
            case '1':
                return "";
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            case '0':
                return " ";
            default:
                return "";
        }
    }
}