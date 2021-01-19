package leetcode.amazon_google_questions;

public class AndroidUnlockPatterns {
    // T.C: O(N!) where n is a maximum pattern length
    // S.C: O(N)
    // Keep last
    // when i is candidate, process roughly from adjacent cases to non-adjacent cases
    // 1. There is a knight move (as in chess) from last toward i.
    // 2. last and i are adjacent digits in a row.
    // 3. last and i are adjacent digits in a column.
    // case 1~3: In this case the sum of both digits should be an odd number.
    // 4. The middle element mid in the line which connects i and last was previously selected.
    // case 4: In case i and last are positioned at both ends of the diagonal, digit mid = 5 should be previously selected.
    // 5. last and i are adjacent digits in a diagonal
    // case 5: In this case, (curr%3 != curr%3) && (last/3 != last/3) => should be true
    // 6. all other cells which are not adjacent
    // case 6: depends on whether there is a previous cell which bridges them
    private boolean[] used = new boolean[9];
    public int numberOfPatterns(int m, int n) {
        int res = 0;
        for(int len=m; len<=n; len++){
            res += calcPatterns(-1, len); // -1 is just dummy for the first digit
            for(int i=0; i<9; i++){
                used[i] = false;
            }
        }
        return res;
    }

    public int calcPatterns(int last, int len){
        if(len == 0)    return 1;
        int res = 0;
        for(int curr=0; curr<9; curr++){
            if(isValid(curr, last)){
                used[curr] = true;
                res += calcPatterns(curr, len-1);
                used[curr] = false;
            }
        }
        return res;
    }

    public boolean isValid(int curr, int last){ // *****
        if(used[curr])
            return false;

        if(last == -1)  // when the first digit
            return true;

        if((curr + last) % 2 == 1) // knight move or in a adjacent row or in a adjacent col
            return true;

        int mid = (curr + last)/2; // 5(idx 4) is selected // order matters // this first // *****
        if(mid == 4)
            return used[mid];

        if((curr % 3 != last % 3) && (curr / 3 != last / 3)) // adjacent cells on diagonal // order matters // this later // *****
            return true;

        return used[mid]; // all other cells which are not adjacent
    }
}
