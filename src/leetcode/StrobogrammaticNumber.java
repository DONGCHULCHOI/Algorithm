package leetcode;

public class StrobogrammaticNumber {
    // T.C: O(5^N)
    // S.C: O(N)
    // Strobogrammatic Number II solve first
    // A strobogrammatic number is a number that looks the same when rotated 180 degrees
    // increasing order, so there is no 00 // ***
    // like fibonacci
    // 0, 1, 8, 11, 69, 88, 96, 101, 111, 181, 609, 619, 689, 808, 818, 888, 906, 916, 986, 1001, ...
    private boolean res = false;
    public boolean isStrobogrammatic(String num) {
        findStrobogrammaticHelper(num.toCharArray(), 0, num.length() - 1);
        return res;
    }

    public void findStrobogrammaticHelper(char[] a, int l, int r) {
        if (l > r) { // when the length is even
            res = true;
            return;
        }
        if (l == r) { // when the length is odd
            res = (a[l] == '0' || a[l] == '1' || a[l] == '8') ? true : false;
            return;
        }

        if (l != 0) { // to avoid 00
            if(a[l] == '0' && a[r] == '0'){
                findStrobogrammaticHelper(a, l+1, r-1);
            }
        }
        if(a[l] == '1' && a[r] == '1'){
            findStrobogrammaticHelper(a, l+1, r-1);
        }
        if(a[l] == '8' && a[r] == '8'){
            findStrobogrammaticHelper(a, l+1, r-1);
        }
        if(a[l] == '6' && a[r] == '9'){
            findStrobogrammaticHelper(a, l+1, r-1);
        }
        if(a[l] == '9' && a[r] == '6'){
            findStrobogrammaticHelper(a, l+1, r-1);
        }
    }
}
