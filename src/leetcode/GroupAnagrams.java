package leetcode;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // T.C: O(NK) where N is the length of strs, and K is the maximum length of a string in strs *1)
        // S.C: O(NK) because the total information content stored in ans
        if(strs.length == 0){
            return new ArrayList();
        }
        Map<String, List<String>> ans = new HashMap<>();
        int[] count = new int[26]; // ***
        for(String s : strs){
            Arrays.fill(count, 0);
            for(char c : s.toCharArray()){
                count[c-'a']++; // *****
            }
            StringBuilder sb = new StringBuilder(); // ***
            for(int i = 0; i<26; i++){ // *****
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString(); // ***
            if(!ans.containsKey(key)){ // *****
                ans.put(key, new ArrayList<String>());
            }
            ans.get(key).add(s); // *****
        }
        return new ArrayList(ans.values()); // ***
    }
    // 1) Counting each string is linear in the size of the string, and we count every string.
}
