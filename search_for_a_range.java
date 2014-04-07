/*
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/
// O(logn) solution
public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] range = new int[]{-1, -1};
        if (A == null || A.length == 0) return range;
        
        int left = findLeft(A, target);
        int right = findRight(A, target);
        range[0] = left;
        range[1] = right;
        return range; 
    }
    
    private int findLeft(int[] A, int target) {
        int i = 0, j = A.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (A[mid] < target) i = mid + 1;
            else j = mid - 1;
        }
        if (A[i] == target) return i;
        if (i < A.length - 1 && A[i + 1] == target) return i + 1;
        return -1;
    }
    
    private int findRight(int[] A, int target) {
        int i = 0, j = A.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (A[mid] > target) j = mid - 1;
            else i = mid + 1;
        }
        if (j >= 0 && A[j] == target) return j;
        if (j > 0 && A[j - 1] == target) return j - 1;
        return -1;
    }
}


// O(n) solution
public class Solution {
    public int[] searchRange(int[] A, int target) {
        int [] res = {-1,-1};
        int left = 0, right = A.length-1;
        if(A.length == 0) return res;
        while(left<=right){
            int mid = left + (right - left)/2;
            if(A[mid] == target){
                res[0] = mid;
                res[1] = mid;
                int i = mid, j = mid;
                while(i-1>=0 && A[i-1]==target) res[0]=--i;
                while(j+1<A.length && A[j+1]==target) res[1]=++j;
                return res;
            }
            else if(A[mid]<target) left = mid+1;
            else right = mid-1;
        }
        return res;
    }
}
