/*
There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */

// Solution
// Time complexity: O(log(m + n)), Space complexity: O(n)
public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int aLen = A.length;
        int bLen = B.length;
        if((aLen + bLen) % 2 ==0){
            return (findKthElement(A, 0, aLen - 1, B, 0, bLen - 1, (aLen + bLen) / 2) + findKthElement(A, 0, aLen - 1, B, 0, bLen - 1, (aLen + bLen) / 2 + 1)) / 2.0;
        } else {
            return findKthElement(A, 0, aLen - 1, B, 0, bLen - 1, (aLen + bLen) / 2 + 1);
        }
    }
    
    public int findKthElement(int A[], int aStart, int aEnd, int B[], int bStart, int bEnd, int k){
    	int aLen = aEnd - aStart + 1;
    	int bLen = bEnd - bStart + 1;

    	// the kth element in array starting from bStart
    	if (aLen < 1) return B[bStart + k - 1];
    	if (bLen < 1) return A[aStart + k - 1];
    	if (k == 1) return Math.min(A[aStart], B[bStart]);

        int aMid = (aStart + aEnd) / 2;
        int bMid = (bStart + bEnd) / 2;
        int len = (aMid - aStart + 1) + (bMid - bStart + 1);


        if (A[aMid] <= B[bMid]) {
        	if (len <= k) 
        		// drop smaller half of A
        		return findKthElement(A, aMid + 1, aEnd, B, bStart, bEnd, k - (aMid - aStart + 1));
        	else
        		// drop larger half of B
        		return findKthElement(A, aStart, aEnd, B, bStart, bMid - 1, k);
        }
        else {
        	if (len <= k)
        		// drop smaller half of B
        		return findKthElement(A, aStart, aEnd, B, bMid + 1, bEnd, k - (bMid - bStart + 1));
        	else 
        		// drop larger half of A
        		return findKthElement(A, aStart, aMid - 1, B, bStart, bEnd, k);
        }
    }
}




// Defected solutions
public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        if ((A == null && B == null) || (A.length == 0 && B.length == 0)) return 0;
        int aLen = A.length;
        int bLen = B.length;
        // even
        if ((aLen + bLen) % 2 == 0) {
        	int leftMed = findKthElement(A, 0, aLen - 1, B, 0, bLen - 1, (aLen + bLen) / 2);
        	int rightMed = findKthElement(A, 0, aLen - 1, B, 0, bLen - 1, (aLen + bLen) / 2 + 1);
			return (leftMed + rightMed) / 2;
        }
        // odd
        else 
        	return findKthElement(A, 0, aLen - 1, B, 0, bLen - 1, (aLen + bLen + 1) / 2);
    }

    public int findKthElement(int A[], int aStart, int aEnd, int B[], int bStart, int bEnd, int k) {
    	int aLen = aEnd - aStart + 1;
    	int bLen = bEnd - bStart + 1;

    	// the kth element in array starting from bStart
    	if (aLen < 1) return B[bStart + k - 1];
    	if (bLen < 1) return A[aStart + k - 1];
    	if (k == 1) return Math.min(A[aStart], B[bStart]);

    	int aMid = (aStart + aEnd) / 2;
    	int bMid = (bStart + bEnd) / 2;
    	if (A[aMid] <= B[bMid]) {
    		// the index of kth element is k - 1
    		if (aLen / 2 + bLen / 2 <= k - 1) 
    			// drop smaller half of A, and modifies the k index accordingly
    			// number of elements dropped is aLen / 2
    			return findKthElement(A, aMid + 1, aEnd, B, bStart, bEnd, k - (aLen / 2 + 1));
    		else 
    			// drop larger half of B
    			// elements dropped are beyond k
    			return findKthElement(A, aStart, aEnd, B, bStart, bMid - 1, k);
    	}
    	else {
    		if (aLen / 2 + bLen / 2 <= k - 1)
				// drop smaller half of B
    			return findKthElement(A, aStart, aEnd, B, bMid + 1, bEnd, k - (bLen / 2 + 1));
    		else 
    			// drop larger half of A
    			return findKthElement(A, aStart, aMid - 1, B, bStart, bEnd, k);
    	}
    }
}


// Solution
public class Solution {
	public double findMedianSortedArrays(int A[], int B[]) {
        if ((A == null && B == null) || (A.length == 0 && B.length == 0)) return 0;
        int aLen = A.length;
        int bLen = B.length;
        if ((aLen + bLen) % 2 == 0) {
        	int leftMed = findKthElement(A, 0, aLen - 1, B, 0, bLen - 1, (aLen + bLen) / 2);
        	int rightMed = findKthElement(A, 0, aLen - 1, B, 0, bLen - 1, (aLen + bLen) / 2 + 1);
			return (leftMed + rightMed) / 2;
        }
        else 
        	return findKthElement(A, 0, aLen - 1, B, 0, bLen - 1, (aLen + bLen + 1) / 2);
    }

	public int findKthElement(int A[], int aStart, int aEnd, int B[], int bStart, int bEnd, int k) {
    	int aLen = aEnd - aStart + 1;
    	int bLen = bEnd - bStart + 1;

    	// the kth element in array starting from bStart
    	if (aLen < 1) return B[bStart + k - 1];
    	if (bLen < 1) return A[aStart + k - 1];
    	if (k == 1) return Math.min(A[aStart], B[bStart]);

    	int aMid = (aStart + aEnd) / 2;
    	int bMid = (bStart + bEnd) / 2;
    	if (A[aMid] <= B[bMid]) {
    		// the index of kth element is k - 1
    		if (aLen / 2 + bLen / 2 <= k - 1) {
    			// drop smaller half of A, and modifies the k index accordingly
    			// number of elements dropped is aLen / 2
    			return findKthElement(A, aMid + 1, aEnd + 1, B, bStart, bEnd + 1, k - aLen / 2 - 1);
    		}
    		else  {
    			// drop larger half of B
    			// elements dropped are beyond k
    			return findKthElement(A, aStart, aEnd + 1, B, bStart, bMid, k);
    		}
    	}
    	else {
    		if (aLen / 2 + bLen / 2 <= k - 1) {
				// drop smaller half of B
    			return findKthElement(A, aStart, aEnd, B, bMid + 1, bEnd + 1, k - bLen / 2 - 1);
    		}
    		else {
    			// drop larger half of A
    			return findKthElement(A, aStart, aMid, B, bStart, bEnd + 1, k);
    		}
    	}
    }
}





public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        if ((A == null && B == null) || (A.length == 0 && B.length == 0)) return 0;
        int aLen = A.length;
        int bLen = B.length;
        if ((aLen + bLen) % 2 == 0) {
        	int leftMed = findKthElement(A, 0, aLen, B, 0, bLen, (aLen + bLen) / 2);
        	int rightMed = findKthElement(A, 0, aLen, B, 0, bLen, (aLen + bLen) / 2 + 1);
			return (leftMed + rightMed) / 2;
        }
        else 
        	return findKthElement(A, 0, aLen - 1, B, 0, bLen - 1, (aLen + bLen + 1) / 2);
    }

    public int findKthElement(int A[], int aStart, int aEnd, int B[], int bStart, int bEnd, int k) {
    	int aLen = aEnd - aStart;
    	int bLen = bEnd - bStart;

    	// the kth element in array starting from bStart
    	if (aLen < 1) return B[bStart + k - 1];
    	if (bLen < 1) return A[aStart + k - 1];
    	if (k == 1) return Math.min(A[aStart], B[bStart]);

    	int aMid = (aStart + aEnd) / 2;
    	int bMid = (bStart + bEnd) / 2;
    	if (A[aMid] <= B[bMid]) {
    		// the index of kth element is k - 1
    		if (aLen / 2 + bLen / 2 <= k - 1) 
    			// drop smaller half of A, and modifies the k index accordingly
    			// number of elements dropped is aLen / 2
    			return findKthElement(A, aMid + 1, aEnd, B, bStart, bEnd, k - aLen / 2 - 1);
    		else 
    			// drop larger half of B
    			// elements dropped are beyond k
    			return findKthElement(A, aStart, aEnd, B, bStart, bMid, k);
    	}
    	else {
    		if (aLen / 2 + bLen / 2 <= k - 1)
				// drop smaller half of B
    			return findKthElement(A, aStart, aEnd, B, bMid + 1, bEnd, k - bLen / 2 - 1);
    		else 
    			// drop larger half of A
    			return findKthElement(A, aStart, aMid, B, bStart, bEnd, k);
    	}
    }
}


// Solution
public class Solution {
    public static double findMedianSortedArrays(int A[], int B[]) {
    	int m = A.length;
    	int n = B.length;
     
    	if ((m + n) % 2 != 0) // odd
    		return (double) findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1);
    	else { // even
    		return (findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1) 
    			+ findKth(A, B, (m + n) / 2 - 1, 0, m - 1, 0, n - 1)) * 0.5;
    	}
    }
 
    public static int findKth(int A[], int B[], int k, int aStart, int aEnd, int bStart, int bEnd) {
    	int aLen = aEnd - aStart + 1;
    	int bLen = bEnd - bStart + 1;
     
    	// Handle special cases
    	if (aLen == 0)
    		return B[bStart + k];
    	if (bLen == 0)
    		return A[aStart + k];
    	if (k == 0)
    		return Math.min(A[aStart], B[bStart]);
     
    	int aMid = aLen * k / (aLen + bLen); // a's middle count
    	int bMid = k - aMid - 1; // b's middle count
     
    	// make aMid and bMid to be array index
    	aMid = aMid + aStart;
    	bMid = bMid + bStart;
     
    	if (A[aMid] > B[bMid]) {
    		k = k - (bMid - bStart + 1);
    		aEnd = aMid;
    		bStart = bMid + 1;
    	} else {
    		k = k - (aMid - aStart + 1);
    		bEnd = bMid;
    		aStart = aMid + 1;
    	}
    	return findKth(A, B, k, aStart, aEnd, bStart, bEnd);
    }
}