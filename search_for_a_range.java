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
    
    // find lower bound
    private int findLeft(int[] A, int target) {
        int left = 0, right = A.length - 1;
        // not left <= right, since when left == right, the index may be out of range
        while (left < right) {
            int mid = (left + right) / 2;
            if (A[mid] < target) left = mid + 1;
            // when A[mid] == target, we should still shrink the right to find a bound smaller than target, thus the same as A[mid] > target
            // the true target here, the lower bound, is smaller than target
            else right = mid - 1;
        }
        if (A[left] == target) return left;
        if (left < A.length - 1 && A[left + 1] == target) return left + 1;
        return -1;
    }
    
    // find upper bound
    private int findRight(int[] A, int target) {
        int left = 0, right = A.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (A[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        if (right >= 0 && A[right] == target) return right;
        if (right > 0 && A[right - 1] == target) return right - 1;
        return -1;
    }
}

// O(logn) solution
// We can make target - 0.5 for searching lower bound and target + 0. 5 for the upper bound. 
public class Solution {
    public int[] searchRange(int[] A, int target) {  
        if (A==null) return null;
       
        int[] result={-1,-1};
      
        int low=binarySearch(A,target-0.5);
        
        
        // Be care for there , low>=A.length must be check first or 
        // there may be a out of boundary exception cause 
        // the binarySearch function in this question return low instead of null
        // if the target are not in the array
        
        if (low>=A.length||A[low]!=target){
            return result;
            
        }        
        result[0]=low;
        result[1]=binarySearch(A,target+0.5)-1;
        
        return result;
           
    }
    public int binarySearch(int[] A, double t){
        int low = 0, high = A.length - 1;
        while(low <= high){
            int m = (low + high) / 2;
            if(A[m] == t) return m;
            if(A[m] > t) high = m - 1;
            else low = m + 1;
        }
        return low;
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