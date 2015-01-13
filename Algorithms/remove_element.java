/*
Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
*/

public class Solution {
    public int removeElement(int[] A, int elem) {
        if (A == null) 
            return 0;
        int len = A.length;
        if (len == 0) 
            return 0;

        int l = 0, r = len - 1;
        while (l <= r) {
            if (A[l] == elem) {
                if (A[r] != elem) {
                    A[l] = A[r];
                    A[r] = elem;
                    l++;
                }
                r--;
            }
            else 
                l++;
        }
        return l + 1;
    }
}


public class Solution {
    public int removeElement(int[] A, int elem) {
        if (A == null) 
            return 0;
        int len = A.length;
        if (len == 0) 
            return 0;    

        int index = 0;
        for (int i = 0; i < len; i++) {
            if (A[i] != elem) {
                A[index++] = A[i];
            } 
        }
        return index;
    }
}





