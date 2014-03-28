/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].
*/
public class Solution {
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) return 0;
        
        int iNew = 0;
        for (int iter = 0; iter < A.length; iter++) {
            int counter = 1;
            while (iter < A.length -1 && A[iter] == A[iter + 1]) {
                counter++;
                iter++;                
            }
            A[iNew++] = A[iter];
            if (counter >= 2) A[iNew++] = A[iter];
        }
        return iNew;
    }
}