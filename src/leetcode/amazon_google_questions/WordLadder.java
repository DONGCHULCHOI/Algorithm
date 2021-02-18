package leetcode.amazon_google_questions;
import java.util.*;

//import javafx.util.Pair;
class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

public class WordLadder {
    // Consider bidirectional bfs next time
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // T.C: O(M^2*N)
        // S.C: O(M^2*N)
        // complexity of time and space are hard, next time try to understand fully
        Map<String, List<String>> preProcess = new HashMap<>();
        int wordLength = beginWord.length(); // all words has same length
        // preprocessing // ***** // O(M^2*N)
        for(String word : wordList){ // O(N)
            for(int i=0; i<wordLength; i++){ // O(M)
                String newWord = word.substring(0,i) + "*" + word.substring(i+1, wordLength); //*1) // O(M)
                List<String> transformations = preProcess.getOrDefault(newWord, new ArrayList<>());
                transformations.add(word);
                preProcess.put(newWord, transformations); // *2)
            }
        }
        // BFS // *3) // *****
        Map<String, Boolean> visited = new HashMap<>(); // for mark visited

        LinkedList<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1)); // level starts with 1
        visited.put(beginWord, true);
        // O(M^2*N)
        while(queue.size() != 0){ // O(N)
            // visit
            Pair<String, Integer> node = queue.remove();
            String word = node.getKey();
            int level = node.getValue();
            // add unvisited neighbors into the queue
            for(int i=0; i<wordLength; i++){ // O(M^2)
                String newWord = word.substring(0,i) + "*" + word.substring(i+1, wordLength);

                for(String neighbors : preProcess.getOrDefault(newWord, new ArrayList<>())){
                    if(neighbors.equals(endWord)){
                        return level+1;
                    }
                    if(!visited.containsKey(neighbors)){
                        queue.add(new Pair<>(neighbors, level+1));
                        visited.put(neighbors, true);
                    }
                }
            }
        }
        return 0;
    }
    // 1) substring(0,0) = null, substring(L,L) = null
    // 1) e.g. a[bc], [a]b[c], [ab]c
    // 2) {"*bc"=["abc"], "a*c"=["abc"], "ab*"=["abc"]
    // 3) While building the graph, find the shortest graph. In here, we can consider all possible
    // graphs. r.f. usually, we did BFS in built graph, but also, like here, we can BFS building the
    // graph.
}
