package leetcode;

public class StrobogrammaticNumber {
    // T.C: O(N) where recursive call looks like linear line O(N/2)
    // S.C: O(N)
    // Strobogrammatic Number II solve first
    // A strobogrammatic number is a number that looks the same when rotated 180 degrees
    // increasing order, so there is no 00 // ***
    // like fibonacci
    // 0, 1, 8, 11, 69, 88, 96, 101, 111, 181, 609, 619, 689, 808, 818, 888, 906, 916, 986, 1001, ...
    public boolean isStrobogrammatic(String num) {
        return findStrobogrammaticHelper(num.toCharArray(), 0, num.length() - 1);
    }

    public boolean findStrobogrammaticHelper(char[] a, int l, int r) {
        if (l > r) { // when the length is even // *****
            return true;
        }
        if (l == r) { // when the length is odd // *****
            return (a[l] == '0' || a[l] == '1' || a[l] == '8') ? true : false;
        }

        if(l != 0 && a[l] == '0' && a[r] == '0' // to avoid 00 // *****
                || a[l] == '1' && a[r] == '1'
                || a[l] == '8' && a[r] == '8'
                || a[l] == '6' && a[r] == '9'
                ||a[l] == '9' && a[r] == '6')
            return findStrobogrammaticHelper(a, l+1, r-1);

        return false;
    }
}
