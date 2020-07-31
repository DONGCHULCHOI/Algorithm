package leetcode;

public class SwapAdjacentInLRString {
    // T.C: O(N)
    // S.C: O(1)
    // We can ask: what invariants there are: // *****
    //      invariants are conditions that remain true after making any transformation / properties that are not changed after making any transformation
    //      This is natural for any question that involves transforming some state and asking whether a final state is possible
    // contraints: len(start) == len(end)
    public boolean canTransform(String start, String end) {
        if (!start.replace("X", "").equals(end.replace("X", ""))) // To meet for transforming => when eliminate X in each string, it should be same, e.g. LLR, RRL // *****
            return false;

        int p1 = 0;
        int p2 = 0;
        while(p1 < start.length() && p2 < end.length()){ // e.g. RXL, XRL
            // get the non-X positions(L/R) in start, end // *****
            while(p1 < start.length() && start.charAt(p1) == 'X')   p1++;
            while(p2 < end.length() && end.charAt(p2) == 'X')   p2++;

            //if both of the pointers reach the end the strings are transformable, e.g. RXLX, XRLX // *****
            if(p1 == start.length() && p2 == end.length())  return true;

            // if only one of the pointer reach the end they are not transformable, e.g. RXLX, XRLL // *****
            if(p1 == start.length() || p2 == end.length())  return false;

            // '"XL" can***** be replaced by "LX"' means the position of L in start can only be at right-side of that L in end. // invariant // *****
            // => it should be p1 > p2 when p1, p2 point L in start, end // *****
            if(start.charAt(p1) == 'L' && p2 > p1)  return false;
            // '"RX" can***** be replaced by "XR"' means the position of R in start can only be at left-side of that R in end. // invariant // *****
            // => it should be p1 < p2 when p1, p2 point R in start, end // *****
            if(start.charAt(p1) == 'R' && p1 > p2)  return false;

            p1++;
            p2++;
        }
        return true;
    }
}
