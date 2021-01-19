package leetcode.amazon_google_questions;

import java.util.*;

public class EvaluateDivision {
    // Consider time complexity next time
    // https://leetcode.com/problems/evaluate-division/discuss/171649/1ms-DFS-with-Explanations
    // Build a graph and do dfs
    // Binary relationship is represented as a graph usually
    // it is a directed weighted graph
    // Imagine a/b = k as a link between node a and b, the weight from a to b is k, the reverse is 1/k.
    // Query is to find a path between two nodes, and calculate a distance
    // If a/b = 2.0 and b/c = 3.0, we can treat a,b, and c as vertices.
    // then edge(a,b)’s weight is 2.0 and edge(b,c)’s weight is 3.0
    // backward edge(b,a)’s weight is 1/2.0 and backward edge(c,b)’s weight is 1/3.0
    // query a,c is a path from a to c, and calculate a distance (a,c) = weight(a,b) * weight(b,c)
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Build graph
        Map<String, Map<String, Double>> graph =  new HashMap<>();
        String u, v;
        for(int i=0; i<equations.size(); i++){
            u = equations.get(i).get(0);
            v = equations.get(i).get(1);
            if(!graph.containsKey(u))
                graph.put(u, new HashMap<>());
            graph.get(u).put(v, values[i]);
            if(!graph.containsKey(v))
                graph.put(v, new HashMap<>());
            graph.get(v).put(u, 1/values[i]);
        }
        // do dfs and calculate weight b/w a and b
        double[] result = new double[queries.size()];
        for(int i=0; i<queries.size(); i++){
            result[i] = calcWeight(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), graph); // ***** // because do dfs by each query
        }
        return result;
    }
    // do dfs and calculate weight b/w a and b
    public double calcWeight(String start, String end, Set<String> visited, Map<String, Map<String, Double>> graph){
        if(!graph.containsKey(start)) // edge case
            return -1.0;

        if(graph.get(start).containsKey(end)) // base case
            return graph.get(start).get(end);

        visited.add(start); // visit

        for(Map.Entry<String, Double> neighbour : graph.get(start).entrySet()){
            if(!visited.contains(neighbour.getKey())){
                double weight = calcWeight(neighbour.getKey(), end, visited, graph); // *****
                if (weight != -1.0) // *****
                    return neighbour.getValue() * weight; // *****
            }
        }
        return -1.0;
    }
}