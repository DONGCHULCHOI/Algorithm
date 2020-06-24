package leetcode;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        // T.C: O(N)
        // S.C: O(1)
        if(s.length() != t.length())
            return false;

        int[] map = new int[26]; // Map
        for(int i=0; i<s.length(); i++){
            map[s.charAt(i) - 'a']++;
            map[t.charAt(i) - 'a']--;
        }
        for(int elem : map){
            if(elem != 0)
                return false;
        }
        return true;
    }
}
