/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
*/

public class Solution {
    public boolean isAlphaNumeric(char ch){
        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9'))
            return true;
        else 
            return false;
    }
    
    public boolean isPalindrome(String s) {
        if (s == null) 
            return true;
        int len = s.length();
        if (len == 0)
            return true;
        
        int l = 0, r = len - 1;
        String lower = s.toLowerCase();
        
        while (l < r) { 
            char lCh = lower.charAt(l);
            char rCh = lower.charAt(r);
            if (!isAlphaNumeric(lCh))   
                l++;
            else if (!isAlphaNumeric(rCh))   
                r--;                  
            else if (lCh != rCh) 
                return false;
            else if (lCh == rCh) {
                l++;
                r--;
            }
        }
        return true;
    } 
}

/*
public class Solution {
    public boolean isNum(char ch){
        if (ch >= '0' && ch <= '9')
            return true;
        return false;
    }
    
    public boolean isAlpha(char ch){
        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
            return true;
        return false;
    }
    
    public  boolean isSame(char a, char b){
        if(isNum(a) && isNum(b)){
            return a == b;
        } 
        else if (Character.toLowerCase(a) == Character.toLowerCase(b))
            return true;
        else
            return false;
    }
    
    public boolean isPalindrome(String s) {
        if (s == null) 
            return true;
        int len = s.length();
        if (len < 2)
            return true;
        
        int l = 0, r = len - 1;
        while (l < r) { 
            char lCh = s.charAt(l);
            char rCh = s.charAt(r);
            if (!isNum(lCh) || !isAlpha(lCh))   
                l++;
            else if (!isNum(rCh) || !isAlpha(rCh))   
                r--;                  
            else if (isSame(lCh, rCh)) 
                return false;
            else {
                l++;
                r--;
            }
        }
        return true;
    } 
}

*/


/*
public class Solution {
    public boolean isAlphaNumeric(char ch){
        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9'))
            return true;
        return false;
    }
    
    public boolean isPalindrome(String s) {
        if (s == null) 
            return true;
        int len = s.length();
        if (len == 0)
            return true;
        
        int idx = 0;
        int l = 0, r = len - 1;
        String lower = s.toLowerCase();
        
        while (l <= r && l < len && r >= 0) { 
            if (!isAlphaNumeric(s.charAt(l)))   
                l++;
            else if (!isAlphaNumeric(s.charAt(r)))   
                r--;                  
            else if (s.charAt(l) != s.charAt(r)) 
                return false;
            // else {
            //     l++;
            //     r--;
            // }
        }
        return true;
    } 
}
*/