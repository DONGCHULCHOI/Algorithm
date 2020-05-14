package com.company;

import leetcode.TwoSum;

public class Main {

    public static void main(String[] args) {
        // TwoSum
        TwoSum twoSum = new TwoSum();
        int[] output = twoSum.twoSum(new int[]{2,7,11,15}, 9);
        for(int elem : output){
            System.out.print(elem+" ");
        }


    }
}
