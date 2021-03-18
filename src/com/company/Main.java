package com.company;

import leetcode.amazon_google_questions.*;
import leetcode.top100_questions.*;

import java.util.*;
import java.io.*;
import com.company.Pair;

public class Main {


    public static void main(String[] args) {

        int[] ab = {10, 20, 30, 40, 50, 11, 15, 19};
        List<Integer> list = new ArrayList<>();
        for(int elem : ab) {
            list.add(elem);
        }

        Collections.sort(list, (a, b) -> {
            return b / 10 - a / 10;
        });
        Collections.sort(list, (a, b) -> {
            return b / 10 - a / 10 > 0 ? b / 10 - a / 10 : b - a;
        });


    }


}



