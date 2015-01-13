/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/

public class Solution {
    public String convert(String s, int nRows) {
        if (s == null || nRows < 0) return "";
        if (nRows < 2) return s;

        StringBuilder res = new StringBuilder();
        int numLetters = s.length();
        int numDiagonal = nRows - 2;
        int numZigZag = nRows + numDiagonal;

        // for each row, firstly add the vertical line of letters, then the diagonal line
        for (int i = 0; i < nRows; i++) {
            for (int j = i; j < numLetters; j += numZigZag) {
                res.append(s.charAt(j));
                if (i != 0 && i != nRows - 1 && j + numZigZag - 2 * i < numLetters) 
                    res.append(s.charAt(j + numZigZag - 2 * i));
            }
        }
        return res.toString();
    }
}