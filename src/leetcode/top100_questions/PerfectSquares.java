package leetcode.top100_questions;

import java.util.*;

//import javafx.util.Pair;
class Pair<K, V> { // do not add public in front of the class
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() { return key; }

    public V getValue() {
        return value;
    }
}

public class PerfectSquares {
    // Brute force(BFS):
    // Two important BFS concept:
    //  1. Expand the childs
    //  2. Shortest path
    // hint for using bfs: return the least***** number of perfect square numbers that sum to n
    // use Pair class to keep the current level // *****
    // use set for time complexity // *****
    public int numSquares(int n) {
        List<Integer> squareNums = new ArrayList<Integer>();
        for(int i = 1; i * i <= n; i++) {
            squareNums.add(i * i);
        }

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        Set<Integer> repeated = new HashSet<>();

        int level = 1;
        queue.add(new Pair(n,level));
        repeated.add(n);

        while(queue.size() != 0) {
            Pair<Integer, Integer> node = queue.remove();

            int remainder = node.getKey();
            double sqrt = Math.sqrt(remainder);
            if((sqrt - Math.floor(sqrt)) == 0) { // goal test
                return node.getValue();
            }

            for(int squareNum : squareNums) {
                int remainderChild = remainder - squareNum; // expand the childs

                if(remainderChild > 0 && !repeated.contains(remainderChild)){ // for time complexity
                    queue.add(new Pair(remainderChild, node.getValue() + 1)); // for keeping the current level
                    repeated.add(remainderChild);
                }
            }
        }
        return level;
    }
}
