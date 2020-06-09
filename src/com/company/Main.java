package com.company;

import leetcode.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        /*
        // TwoSum
        TwoSum twoSum = new TwoSum();
        int[] output = twoSum.twoSum(new int[]{2,7,11,15}, 9);
        for(int elem : output){
            System.out.print(elem + " ");
        }

        // TwoSumII
        TwoSumII twoSumII = new TwoSumII();
        int[] output = twoSumII.twoSum(new int[]{2,7,11,15}, 9);
        for (int elem : output){
            System.out.print(elem + " ");
        }

        // ThreeSum
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> output = threeSum.threeSum(new int[]{-1,0,1,2,-1,-4});
        for (List<Integer> list : output){
            for(int elem : list){
                System.out.print(elem + " ");
            }
            System.out.println();
        }

        // ThreeSumClosest
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        int output = threeSumClosest.threeSumClosest(new int[]{-1,2,1,-4},1);
        System.out.println(output);

        // RomanToInteger
        RomanToInteger romanToInteger = new RomanToInteger();
        System.out.println(romanToInteger.romanToInt("MCMXCIV"));

        // IntegerToRoman
        IntegerToRoman integerToRoman = new IntegerToRoman();
        System.out.println(integerToRoman.intToRoman(58));

        // ProductOfArrayExceptSelf
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        int[] output = productOfArrayExceptSelf.productExceptSelf(new int[]{1,2,3,4});
        for (int elem : output){
            System.out.print(elem + " ");
        }

        // RotateImage
        RotateImage rotateImage = new RotateImage();
        int[][] output = rotateImage.rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        for(int[] elemArr : output){
            for(int elemVar : elemArr){
                System.out.print(elemVar+" ");
            }
            System.out.println();
        }
        // ContainerWithMostWater
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println(containerWithMostWater.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));

        // TrappingRainWater
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        System.out.print(trappingRainWater.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}) + " ");

        // FirstUniqueCharacterInString
        FirstUniqueCharacterInAString firstUniqueCharacterInAString = new FirstUniqueCharacterInAString();
        System.out.println(firstUniqueCharacterInAString.firstUniqChar("loveleetcode"));

        // LongestSubstringWithoutRepeatingCharacters
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abcabcbb"));

        // StringToInteger
        StringToInteger stringToInteger = new StringToInteger();
        System.out.println(stringToInteger.myAtoi("4193 with words"));

        // ImplementStrStr
        ImplementStrStr implementStrStr = new ImplementStrStr();
        System.out.println(implementStrStr.strStr("hello", "ll"));

        // ValidParentheses
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("([)]"));

        // MissingNumber
        MissingNumber missingNumber = new MissingNumber();
        System.out.println(missingNumber.missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));

        // GroupAnagrams
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        List<List<String>> output = groupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        for(List<String> elem : output){
            System.out.println(elem);
        }

        // CompareVersionNumbers
        CompareVersionNumbers compareVersionNumbers = new CompareVersionNumbers();
        System.out.println(compareVersionNumbers.compareVersion("1.0.1", "1"));

        // MostCommonWord
        MostCommonWord mostCommonWord = new MostCommonWord();
        System.out.println(mostCommonWord.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));

        // ReorderDataInLogFiles
        ReorderDataInLogFiles reorderDataInLogFiles = new ReorderDataInLogFiles();
        String[] output = reorderDataInLogFiles.reorderLogFiles(new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"});
        for (String elem : output){
            System.out.print(elem + " ");
        }

        // AddTwoNumbers
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode output = addTwoNumbers.addTwoNumbers(l1, l2);
        while(output != null){
            System.out.print(output.val + " ");
            output = output.next;
        }

        // MergeTwoSortedLists
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode output = mergeTwoSortedLists.mergeTwoLists(l1, l2);
        while(output != null){
            System.out.print(output.val + " ");
            output = output.next;
        }

        // ReverseLinkedList
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);
        ListNode output = reverseLinkedList.reverseList(l);
        while(output != null){
            System.out.print(output.val + " ");
            output = output.next;
        }

        // CopyListWithRandomPointer
        CopyListWithRandomPointer copyListWithRandomPointer = new CopyListWithRandomPointer();

        Node l = new Node(3);
        l.random = null;
        l.next = new Node(3);
        l.next.random = l;
        l.next.next = new Node(3);
        l.next.next.random = null;
        l.next.next.next = null;

        Node output = copyListWithRandomPointer.copyRandomList(l);
        while(output != null){
            System.out.print("["+output.val+","+output.random+"]" + " ");
            output = output.next;
        }

        // inorder / preorder / postorder traversal of binary tree
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.inOrderTraversal(root);
        System.out.println();
        root.preOrderTraversal(root);
        System.out.println();
        root.postOrderTraversal(root);
        System.out.println();
        System.out.println(root.maxDepth(root)); // == height

        // DiameterOfBinaryTree
        DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(diameterOfBinaryTree.diameterOfBinaryTree(root));

        // SymmetricTree
        SymmetricTree symmetricTree = new SymmetricTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(symmetricTree.isSymmetric(root));

        // BinaryTreeLevelOrderTraversal
        BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = new BinaryTreeLevelOrderTraversal();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(binaryTreeLevelOrderTraversal.levelOrder(root));

        // BinaryTreeZigzagLevelOrderTraversal
        BinaryTreeZigzagLevelOrderTraversal binaryTreeZigzagLevelOrderTraversal = new BinaryTreeZigzagLevelOrderTraversal();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(binaryTreeZigzagLevelOrderTraversal.zigzagLevelOrder(root));

        // ValidateBinarySearchTree
        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        System.out.println(validateBinarySearchTree.isValidBST(root));

        // LowestCommonAncestorOfABinaryTree
        LowestCommonAncestorOfABinaryTree lowestCommonAncestorOfABinaryTree = new LowestCommonAncestorOfABinaryTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        TreeNode p = root.left; // ans
        TreeNode q = root.left.right.right;
        System.out.println(p);
        System.out.println(lowestCommonAncestorOfABinaryTree.lowestCommonAncestor(root, p, q));

        // FloodFill
        FloodFill floodFill = new FloodFill();
        int[][] output = floodFill.floodFill(new int[][]{{1,1,1},{1,1,0},{1,0,1}}, 1, 1, 2);
        for(int[] elemArr : output){
            for(int elem : elemArr){
                System.out.print(elem + " ");
            }
            System.out.println();
        }

        // WordLadder
        WordLadder wordLadder = new WordLadder();
        List<String> input = Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"});
        System.out.println(wordLadder.ladderLength("hit","cog",input));

        // NumberOfIslands
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        char[][] input = new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(numberOfIslands.numIslands(input));

        // CourseSchedule
        CourseSchedule courseSchedule = new CourseSchedule();
        int[][] prerequisites = new int[][]{{1,0},{0,1}};
        System.out.println(courseSchedule.canFinish(2, prerequisites));

        // NQueensII
        NQueensII nQueensII = new NQueensII();
        System.out.println(nQueensII.totalNQueens(4));

        // WordSearch
        WordSearch wordSearch = new WordSearch();
        char[][] input = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(wordSearch.exist(input, "ABCCED"));

        // GenerateParentheses
        GenerateParentheses generateParentheses = new GenerateParentheses();
        System.out.println(generateParentheses.generateParenthesis(3));

        // LetterCombinationsOfAPhoneNumber
        LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber = new LetterCombinationsOfAPhoneNumber();
        System.out.println(letterCombinationsOfAPhoneNumber.letterCombinations("23"));

        // SearchInRotatedSortedArray
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        System.out.println(searchInRotatedSortedArray.search(new int[]{4,5,6,7,0,1,2}, 0));

        // MergeIntervals
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] input = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] output = mergeIntervals.merge(input);
        for (int[] elem : output){
            System.out.print(Arrays.toString(elem) + ", ");
        }

        // MeetingRoomsII
        MeetingRoomsII meetingRoomsII = new MeetingRoomsII();
        System.out.println(meetingRoomsII.minMeetingRooms(new int[][]{{0, 30},{5, 10},{15, 20}}));

        // TopKFrequentElements
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        System.out.println(Arrays.toString(topKFrequentElements.topKFrequent(new int[]{1,1,1,2,2,3}, 2)));

        // KthLargestElementInAnArray
        KthLargestElementInAnArray kthLargestElementInAnArray = new KthLargestElementInAnArray();
        System.out.println(kthLargestElementInAnArray.findKthLargest(new int[]{3,2,1,5,6,4}, 2));

        // KClosestPointsToOrigin
        KClosestPointsToOrigin kClosestPointsToOrigin = new KClosestPointsToOrigin();
        int[][] output = kClosestPointsToOrigin.kClosest(new int[][]{{3,3},{5,-1},{-2,4}}, 2);
        for (int[] elem : output){
            System.out.print(Arrays.toString(elem)+ ", ");
        }

        // Fibonacci
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fibonacci(5));
        System.out.println(fibonacci.fibonacciTopDown(5));
        System.out.println(fibonacci.fibonacciBottomUp(5));
        System.out.println(fibonacci.fibonacciBottomUpImproved(5));

        // MaximumSubarray
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        System.out.println(maximumSubarray.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));

        // BestTimeToBuyAndSellStock
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        System.out.println(bestTimeToBuyAndSellStock.maxProfit(new int[]{7,1,5,3,6,4}));

        // CoinChange
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(new int[]{1, 2, 5}, 11));
        
         */
    }
}









