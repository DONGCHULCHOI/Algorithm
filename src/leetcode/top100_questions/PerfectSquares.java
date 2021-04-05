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
    // BFS:
    // Two important BFS concept:
    //  1. Expand the childs
    //  2. Shortest path
    // hint for using bfs: return the least***** number of perfect square numbers that sum to n
    // node.val = remain = target(remain) - perfect square num
    // level means the number of used perfect square numbers including last itself
    // visited means that it is already decided not perfect square number
    // use Pair class to keep the current level // *****
    // use set for time complexity // *****
    public int numSquares(int n) {
        List<Integer> perfectSquareNumbers = new ArrayList<>();
        for(int i = 1;  i <= n; i++) {
            if(i * i <= n)
                perfectSquareNumbers.add(i * i);
        }

        Pair<Integer, Integer> root = new Pair<>(n, 1);
        Set<Integer> visited = new HashSet<>();
        visited.add(root.getKey());
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Pair<Integer, Integer> node = queue.remove();
            double num = Math.sqrt(node.getKey());
            if(num - Math.floor(num) == 0) {
                return node.getValue();
            }

            for(int perfectSquareNum : perfectSquareNumbers) {
                int remain = node.getKey() - perfectSquareNum;
                if(remain > 0 && !visited.contains(remain)) {
                    visited.add(remain);
                    queue.add(new Pair<>(remain, node.getValue() + 1));
                }
            }
        }
        return 0;
    }
}
