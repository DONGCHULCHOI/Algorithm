package leetcode.samsung;
// https://www.geeksforgeeks.org/thue-morse-sequence/#:~:text=Thue%E2%80%93Morse%20sequence%2C%20or%20Prouhet,the%20sequence%20obtained%20so%20far
public class ThueMorseSequence {
    public static void main(String[] args) {
        int n = 3;
        String res = "0";
        for(int i = 0; i < n; i++) {
            res += complement(res);
        }
        System.out.println();

    }

    // function
    public static String complement(String str) {
        int pos = 0;
        String res = "";
        while(pos < str.length()) {
            if(str.charAt(pos) == '0') {
                res += "1";
            } else {
                res += "0";
            }
            pos++;
        }
        return res;
    }
}

