package leetcode;

import java.util.Arrays;

public class FindAndReplaceInString {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        // T.C: O(NQ) where NN is the length of S, and we have QQ replacement operations
        // S.C: O(N)
        // First check whether we can do operations given arrays using match arr to save the information
        // Then, do the operations(build the ans)
        // (!) the index of indexes, sources, and targets is same, but the index of S is different from the prev index
        // So, use match array between two indexes like a arbitrator
        int[] match = new int[S.length()];
        Arrays.fill(match, -1);

        for(int i=0; i<indexes.length; i++){ // *****
            int idx = indexes[i];
            if(S.substring(idx, idx+sources[i].length()).equals(sources[i]))
                match[idx] = i;
        }

        StringBuilder ans = new StringBuilder();
        int idx = 0;
        while(idx < S.length()){
            if(match[idx] >= 0){
                ans.append(targets[match[idx]]);
                idx += sources[match[idx]].length();
            }
            else{
                ans.append(S.charAt(idx++));
            }
        }
        return ans.toString();
    }
}
