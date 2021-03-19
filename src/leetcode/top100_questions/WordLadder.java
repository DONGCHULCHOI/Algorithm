package leetcode.top100_questions;

import java.util.*;

public class WordLadder {
    private static Map<String, List<String>> preprocess = new HashMap<>();

    public int ladderLength(String begin, String target, List<String> words) {
        int length = begin.length();

        for(String word : words) {
            for(int i = 0; i < length; i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(word.substring(0, i) + "*" + word.substring(i + 1, word.length()));
                String key = sb.toString();

                List<String> transformation = preprocess.getOrDefault(key, new ArrayList<>());
                transformation.add(word);
                preprocess.put(key, transformation);
            }
        }

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(begin);
        queue.add(new Pair<>(begin,1));

        while(!queue.isEmpty()) {
            Pair<String, Integer> node = queue.remove();
            String nodeWord = node.getKey();
            int nodeLevel = node.getValue();

            if(nodeWord.equals(target)) {
                return nodeLevel;
            }

            for(int i = 0; i < length; i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(nodeWord.substring(0, i) + "*" + nodeWord.substring(i + 1, nodeWord.length()));
                String key = sb.toString();
                for(String transformation : preprocess.getOrDefault(key, new ArrayList<>())) {
                    if(!visited.contains(transformation)) {
                        visited.add(transformation);
                        queue.add(new Pair<>(transformation, nodeLevel + 1));
                    }
                }
            }
        }
        return 0;
    }
}
