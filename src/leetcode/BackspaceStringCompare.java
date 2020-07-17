package leetcode;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        // T.C: O(M+N) where M, N are the lengths of S and T // there is inner loop but it does not go back to previous index
        // S.C: O(1)
        // Start from the end of the each string // *****
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
                else if(skipS > 0){ // skip by the value of skipS, e.g. if skipS == 2, skip two times // *****
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
                else if(skipT > 0){ // skip by the value of skipS, e.g. if skipS == 2, skip two times // *****
                    skipT--;
                    j--;
                }
                else{
                    break;
                }
            }

            if(i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) // when compare char vs char // *****
                return false;

            if(i >= 0 != j >= 0) // when compare char vs nothing // when not the same length which means either i or j is -1 // *****
                return false;

            i--;
            j--;
        }
        return true; // include the case of comparing of "" vs "" because initially those are null or deleted all // *****
    }
}
