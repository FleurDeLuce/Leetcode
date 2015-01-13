/*
 The API: int read4(char *buf) reads 4 characters at a time from a file.
 
 The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
 
 By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
 
 Note:
 The read function will only be called once for each test case.
 */

// Solution
// Time complexity: O(n), Space complexity: O(1)
/* The read4 API is defined in the parent class Reader4.
 int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] fourBuffer = new char[4];
        int readBytes = 0;
        boolean eof = false;
        while (!eof && readBytes < n) {
            // each time, check if the remaining buffer size is less than 4
            int size = read4(fourBuffer);
            if (size < 4) eof = true;
            /* bytes newly read in this iteration
             before last iteration, addBytes is always 4 (size)
             in the last iteration, if byte is 1 - 4, then add size
             else(size is 0), then add n - readBytes, which is the remaining bytes here,and less than the size
             */
            int addBytes = Math.min(n - readBytes, size);
            // update buf, copy current reading 4-char content to it
            System.arraycopy(fourBuffer, 0, buf, readBytes, addBytes);
            readBytes += addBytes;
        }
        return readBytes;
    }
    
}