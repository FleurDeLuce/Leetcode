/*
Implement pow(x, n).
*/
// recursive
public class Solution {
    public double pow(double x, int n) {
        if (n == 0) return 1.; 
        if (n == 1) return x;
        if (n == -1) {
            return x == 0 ? 0 : 1. / x;
        }
        double temp = pow(x, n/2);
        return temp * temp * pow(x, n%2);
    }
}

// iterative
public class Solution {
    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n==0) return 1.;
        if(x==0) return 0.;
        if(n<0){
            n=-n;
            x=1./x;
        }
        
        double res=1.;
        while(n>0){
            if(n%2 == 1) res*=x;
            x*=x;
            n>>=1;
        }
        return res;
    }
}