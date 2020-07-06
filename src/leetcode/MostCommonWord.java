package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        // T.C: O(P+B) where P is the size of paragraph and B is the size of banned
        // S.C: O(P+B) to store the count and the banned set // ***
        // assume the following:
        // Words in the list of banned words are given in lowercase, and free of punctuation.
        // Words in the paragraph are not case sensitive.  The answer is in lowercase
        // Words only consist of letters
        paragraph += "."; // ***** // for the case of only cosisted word with letter. e.g. paragraph = "Bob"

        Set<String> banset = new HashSet<>();
        for(String word : banned){
            banset.add(word);
        }

        Map<String, Integer> count = new HashMap<>();
        String ans = ""; // *****
        int maxFreq = 0; // *****

        StringBuilder word = new StringBuilder();
        for(char c : paragraph.toCharArray()){ // *****
            if(Character.isLetter(c)){ // *****
                word.append(Character.toLowerCase(c));
            }
            else if(word.length()>0){ // *****
                String finalword = word.toString();
                if(!banset.contains(finalword)){ // *****
                    count.put(finalword, count.getOrDefault(finalword, 0) + 1);
                    if(count.get(finalword) > maxFreq){ // update the most frequent word // *****
                        ans = finalword;
                        maxFreq = count.get(finalword);
                    }
                }
                word = new StringBuilder(); // *****
            }
        }
        return ans;
    }
}
