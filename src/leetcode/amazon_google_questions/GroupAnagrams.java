package leetcode.amazon_google_questions;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // T.C: O(NK) where N is the length of strs, and K is the maximum length of a string in strs
        // S.C: O(NK) because the total information content stored in ans
        // In the point of view of Characters related to Complexity
        // For each String, gonna make a key, and define anagram using the key
        // If Key is same, then anagram
        if(strs.length == 0){
            return null;
        }
        Map<String, List<String>> ans = new HashMap<>();
        int[] count = new int[26]; // just for count
        for(String s : strs){
            Arrays.fill(count, 0);
            for(char c : s.toCharArray()){
                count[c-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<26; i++){ // *****
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString(); // *****
            if(!ans.containsKey(key)){
                ans.put(key, new ArrayList<>());
            }
            ans.get(key).add(s); // *****
        }
        return new ArrayList<>(ans.values()); // ***
    }
}
