package leetcode.amazon_google_questions;

public class ReadNCharactersGivenRead4IICallMultipleTimes extends Reader4{
/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */
    // T.C: O(n)
    // S.C: O(1)
    // There is Two buffers: buf for result, buff for read4()
    // Use each pointer for each buffer: ptr for buf, buffPtr for buff;
    //      Becuase buffPtr keeps setting 0, gotta use seperate pointers
    // 1st. read4()
    // 2nd. copy the values from buff to buf
    // 3rd. re-set buffPtr to 0
    // 4th. repeat, and when meet buffCnt < 4, then this means it reaches EOF, break the loop
    private int buffPtr = 0;
    private int buffCnt = 0;
    private char[] buff = new char[4];
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int ptr = 0;
        while(ptr < n){
            if(buffPtr == 0) // *****
                buffCnt = read4(buff);

            while(buffPtr < buffCnt && ptr < n) // ***** // e.g. "abcde", 3
                buf[ptr++] = buff[buffPtr++];

            if (buffPtr == buffCnt) // *****
                buffPtr = 0;

            if (buffCnt < 4) // ***** // when read EOF
                break;
        }
        return ptr;
    }
}

class Reader4{
    int read4(char[] buf4){
        return 0;
    };
}
