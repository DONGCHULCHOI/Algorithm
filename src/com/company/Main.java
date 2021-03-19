package com.company;

import leetcode.amazon_google_questions.*;
import leetcode.top100_questions.*;

import java.util.*;
import java.io.*;
import com.company.Pair;

public class Main {
    // private



    // main
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("1a",1);
        map.put("2a",2);
        map.put("3a",3);
        for(Map.Entry<String, Integer> a : map.entrySet()) {
            System.out.println(a.getKey() + a.getValue());
        }

    }

    public static List<String> dfs(String[][] tickets, int start, List<String> answer, Set<String[]> visited) {
        answer.add(tickets[start][0]);
        visited.add(tickets[start]);
        if(answer.size() == tickets.length) {
            answer.add(tickets[start][1]);
            return answer;
        }

        for(int i = 0; i < tickets.length; i++) {
            if(!visited.contains(tickets[i]) && tickets[start][1].equals(tickets[i][0])) {
                List<String> tmp = dfs(tickets, i, answer, visited);
                if(tmp.size() == 0) {
                    visited.remove(tickets[i]);
                    answer.remove(answer.size() - 1);
                }
                if(answer.size() == tickets.length + 1) {
                    return answer;
                }

            }
        }
        return new ArrayList<>();
    }
}



