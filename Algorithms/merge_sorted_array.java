/*
Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note:
You may assume that A has enough space to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
*/

// Wrong solution: should consider if A or B has ended in index, not k
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        if (A == null || m == 0 || B == null || n == 0) return;
        
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (k >= 0) {
            if (A[i] >= B[j]) {
                A[k--] = A[i--];
            } else {
                A[k--] = B[j--];
            }
        }
    }
}

// Correct solution
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        if (B == null || n == 0) return;
        
        int index_a = m - 1, index_b = n - 1, index_new = m + n - 1;
        while (index_a >= 0 && index_b >=0) {
            A[index_new--] = A[index_a] >= B[index_b] ? A[index_a--] : B[index_b--];
        }
        while (index_b >= 0) {
            A[index_new--] = B[index_b--];
        }       
    }
}