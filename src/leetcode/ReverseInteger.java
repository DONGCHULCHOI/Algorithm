package leetcode;

public class ReverseInteger {
    public int reverse(int x) {
        // T.C: O(log x) where log x means x's digits
        // S.C: O(1)
        int res = 0;
        while(x != 0){
            // pop // e.g. stack looks like 1 <- 2 <- 3 <- head
            int pop = x % 10;
            x /= 10;

            if(res > Integer.MAX_VALUE/10 || res == Integer.MAX_VALUE/10 && pop > 7) // overflow // *** // r.f. Integer.MAX_VALUE = 2147483647
                return 0;
            if(res < Integer.MIN_VALUE/10 || res == Integer.MIN_VALUE/10 && pop < -8) // underflow // *** // r.f. Integer.MIN_VALUE = -2147483648
                return 0;

            // push // e.g. stack looks like 3 <- 2 <- 1 <- head
            res = res * 10 + pop;
        }
        return res;
    }
}
