package leetcode;

public class SwapAdjacentInLRString {
    // T.C: O(N)
    // S.C: O(1)
    // We can ask: what invariants (conditions that remain true after making any move) there are.
    // This is natural for any question that involves transforming some state and asking whether a final state is possible
    // In mathematics, an invariant is a property of a mathematical object which remains unchanged,
    // after operations or transformations of a certain type are applied to the objects
    public boolean canTransform(String start, String end) {
        if (!start.replace("X", "").equals(end.replace("X", ""))) // ***** // 1st cond. to meet for transforming
            return false;

        int p1 = 0;
        int p2 = 0;

        while(p1 < start.length() && p2 < end.length()){

            // get the non-X positions of 2 strings // *****
            while(p1 < start.length() && start.charAt(p1) == 'X'){
                p1++;
            }
            while(p2 < end.length() && end.charAt(p2) == 'X'){
                p2++;
            }

            //if both of the pointers reach the end the strings are transformable
            if(p1 == start.length() && p2 == end.length())
                return true;

            // if only one of the pointer reach the end they are not transformable
            if(p1 == start.length() || p2 == end.length())
                return false;

            // "XL" can be replaced by "LX" which means the position of L in start can only be at right-side of that L in end. // invariant // *****
            // when p2 == p1 -> pointing same characters, e.g. start: LLXR, end: LLRX
            if(start.charAt(p1) == 'L' && p2 > p1)
                return false;
            // Or replaceing "RX" with "XR" means the position of R in start can only be at left-side of that R in end. // invariant // *****
            // when p2 == p1 -> pointing same characters, e.g. start: LLXR, end: LLRX
            if(start.charAt(p1) == 'R' && p1 > p2)
                return false;

            p1++;
            p2++;
        }
        return true;
    }
}
