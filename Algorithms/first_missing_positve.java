/*
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
*/

// Solution 1
// The first missing positive numbers must be within 1~n. Since there're at most n numbers in the array, 
// if ordered strictly ascending by 1, which is 1, 2, 3, ..., n - 1, n, then the first missing positive is n + 1
// otherwise there must be one number within [1, n] that is missing and replaced by something else
// We can use the original array as hashtable, to put element A[i] in position (value of A[i]), 
// but in this case, there's no number to fit in A[0] spot if no 0 in the array
// thus we would swap A[0] to position value of A[0] - 1, which means spot 0 is 1, A[0] = 1.
public class Solution {
    public int firstMissingPositive(int[] A) {
        for(int i = 0; i < A.length; ++i) {
            while(A[i] != i + 1) {
                if(A[i] <= 0 || A[i] > A.length || A[i] == A[A[i]-1])
                    break;
                int temp = A[i];
                A[i] = A[temp - 1];
                A[temp - 1] = temp;
            }
        }
        
        for(int i = 0; i < A.length; ++i)
            if(A[i] != i + 1)
                return i + 1;
        return A.length + 1;
    }
}


// Solution 2: Create a new array for hash
public class Solution {
    public int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function        
        if(A.length==0) return 1;
        int max = 0;
        
        for(int i=0; i<A.length; i++){
            max = max > A[i] ? max : A[i];
        }
        
        int[] arr = new int[max];
        
        for(int i=0; i<A.length; i++){
            if(A[i]>0){
                arr[A[i]-1] = 1;
            }
        }
        
        for(int i=0; i<max; i++){
            if(arr[i] == 0)
                return i+1;
        }
        
        return max+1;        
        
    }
}

// Solution 3: Use original array with overwritten
public class Solution {
    public int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A == null || A.length == 0) return 1;
        int len = A.length;
        int intOutOfRange = len + 2;
        
        // scan 1: turn each negative value into an impossible value
        for (int i = 0; i < len; i++) {
            if (A[i] <= 0) A[i] = intOutOfRange;
        }
        
        // scan 2: make array A as a hash table, A[i] indicates the prescence of i+1
        // note that the max missing number is len
        // if A[i] is within [1, n], which is i+1, then set A[A[i] - 1] as its opposite (negative)
        for (int i = 0; i < len; i++) {
            int ai = A[i];
            // if absi is negative, then it must be set to negative in scan 2 previously
            int absi = Math.abs(ai);
            if (absi <= len) {
                A[absi - 1] = -Math.abs(A[absi - 1]);
            }
        }
        
        // scan 3: find the first positive value as the first missing positive
        for (int i = 0; i < len; i++) {
            if (A[i] > 0) {
                return i + 1;
            }
        }
        return len+1;        
    }
}