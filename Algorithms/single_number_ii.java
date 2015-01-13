/*
Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/
/*
Solution 1: Hashtable, time complexity O(n), space complexity O(n)
*/
public class Solution {
    public int singleNumber(int[] A) {
        int len = A.length;
        if (len == 1) return A[0];
        
        HashMap<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int a : A) {
            if (hashtable.containsKey(a)) hashtable.put(a, hashtable.get(a) + 1);
            else hashtable.put(a, 1);
        }
        
        for (int key : hashtable.keySet()) {
            if (hashtable.get(key) == 1) return key;
        }
        return 0;
    }
}

/* 
Solution 2: Bit operation, time complexity O(n), space complexity O(1)
*/
public class Solution {
    public int singleNumber(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
         if(A.length == 0)
            return 0;
        int[] cnt = new int[32];
        for(int i = 0; i < A.length; i++)
        {
            for(int j = 0; j < 32; j++)
            {
                if( (A[i]>>j & 1) ==1)
                {
                    cnt[j] = (cnt[j] + 1)%3;
                }
            }
        }
        int res = 0;
        for(int i = 0; i < 32; i++)
        {
            res += (cnt[i] << i);
        }
        cnt = null;
        return res;
    }
}
