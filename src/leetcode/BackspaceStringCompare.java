package leetcode;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        // T.C: O(M+N) where M, N are the lengths of S and T
        // S.C: O(1)
        // skip the char which will be deleted // *****
        // then compare char vs char // *****
        int i = S.length() - 1;
        int j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while(i >= 0 || j >= 0){ // the length can be different
            while(i >= 0){ // skip the char which will be deleted // *****
                if(S.charAt(i) == '#'){
                    skipS++;
                    i--;
                }
                else if(skipS > 0){
                    skipS--;
                    i--;
                }
                else{
                    break;
                }
            }
            while(j >= 0){ // skip the char which will be deleted // *****
                if(T.charAt(j) == '#'){
                    skipT++;
                    j--;
                }
                else if(skipT > 0){
                    skipT--;
                    j--;
                }
                else{
                    break;
                }
            }

            if(i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) // when compare char vs char
                return false;

            if(i >= 0 != j >= 0) // when compare char vs nothing // when not the same length
                return false;

            i--;
            j--;
        }
        return true;
    }
}
