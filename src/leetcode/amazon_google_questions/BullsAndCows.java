package leetcode.amazon_google_questions;

public class BullsAndCows {
    public String getHint(String secret, String guess) {
        // one pass
        // T.C: O(N) where N is the length of strings
        // S.C: O(1)
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10]; // ***** // because the digits are from 0 to 9
        for (int i = 0; i<secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i))
                bulls++;
            else { // *****
                if (numbers[secret.charAt(i)-'0'] < 0)
                    cows++;
                numbers[secret.charAt(i)-'0']++;
                if (numbers[guess.charAt(i)-'0'] > 0)
                    cows++;
                numbers[guess.charAt(i)-'0']--;
            }
        }
        return bulls + "A" + cows + "B";
    }
}