/*
 Given a list of non negative integers, arrange them such that they form the largest number.
 
 For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 
 Note: The result may be very large, so you need to return a string instead of an integer.
 */

// Solution
// Time complexity: O(), Space complexity: O()
public class Solution {
    public String largestNumber(int[] num) {
        Integer[] arr = new Integer[num.length];
        
        // rewrite the sorting comparison rules, whichis to check
        // if two adjacent numbers in the given array are larger as a combination
        // in the original order or need to be swapped ([a, b, ...] "ab" or "ba" is larger)
        int i = 0;
        for (int e : num) {
            arr[i++] = Integer.valueOf(e);
        }
        
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            // Watch out large number case
            public int compare(Integer a,Integer b) {
                int l_a = a == 0 ? 1 : (int)Math.log10(Math.abs(a)) + 1;
                int l_b = b == 0 ? 1 : (int)Math.log10(Math.abs(b)) + 1;
                
                long long_a = (long)(a * Math.pow(10, l_b) + b);
                long long_b = (long)(b * Math.pow(10, l_a) + a);
                
                return long_a > long_b ? -1 : (long_a == long_b ? 0 : 1);
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for (Integer e : arr) {
            sb.append(e);
        }
        
        return sb.toString().replaceFirst("^0+(?!$)", "");
    }
}

