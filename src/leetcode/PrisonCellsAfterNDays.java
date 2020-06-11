package leetcode;

import java.util.HashMap;

public class PrisonCellsAfterNDays {
    // Consider simulation with bitmap next time
    // Due to the nature of game, to solve this problem is playing the game, i.e. we can simply run the simulation
    // Given K number of cells, there could be at most 2^K possible states.
    // If the number of steps is larger than all possible states (i.e. N > 2^K)
    // Therefore, based on this observation, we could fast-forward the simulation rather than going step by step
    // Once we discover a repetitive state, we can then determine the length (denoted as CC) of the cycle
    // if the remaining steps is N, at least we could fast-forward to the step of N % C, then, continue the simulation step by step
    // T.C: O(K⋅min(N,2^K)) where K be the number of cells, and N be the number of steps
    // S.C: O(2^K) including hashmap, and also encoding the state as a single integer
    public int[] prisonAfterNDays(int[] cells, int N) {
        HashMap<Integer, Integer> seen = new HashMap<>();
        boolean isFastForwarded = false;
        // run the simulation
        while(N > 0){
            if(!isFastForwarded){ // to find the cycle and also after find the cycle
                int stateBitmap = cellsToBitmap(cells);
                if(seen.containsKey(stateBitmap)){
                    // the length of the cycle is seen[stateKey] - N
                    N %= seen.get(stateBitmap) - N;
                    isFastForwarded = true;
                }
                else{
                    seen.put(stateBitmap, N);
                }
            }

            if(N > 0){
                N -= 1;
                cells = nextDay(cells);
            }
        }
        return cells;
    }

    public int cellsToBitmap(int[] cells){ // save a state, which is an array of integers, into a integer using bit
        int stateBitmap = 0x0;
        for(int cell : cells){
            stateBitmap <<= 1;
            stateBitmap = stateBitmap | cell;
        }
        return stateBitmap;
    }
    public int[] nextDay(int[] cells) {
        int[] newCells = new int[cells.length];

        newCells[0] = 0; // first idx
        for (int i = 1; i < cells.length - 1; i++){ // follow the rule
            newCells[i] = (cells[i - 1] == cells[i + 1]) ? 1 : 0;
        }
        newCells[cells.length - 1] = 0; // last idx

        return newCells;
    }
}