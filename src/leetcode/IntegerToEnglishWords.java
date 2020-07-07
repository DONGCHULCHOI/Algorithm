package leetcode;

public class IntegerToEnglishWords {
    // Consider time complexity later exactly
    // T.C : O(N) since Intuitively the output is proportional to the number N of digits in the input.
    // S.C : O(1) since the output is just a string
    // Input is guaranteed to be less than 2^31-1 -> log2^31 -> 9.333 .. -> 10 digits -> can be dealt at most by billion 10^9 // *****
    // Divide and conquer // *****
    // split the initial integer 1234567890 on the groups containing not more than three digits 1.234.567.890
    // split further 234 -> 2 Hundred 34 into two sub-problems : convert 1-digit integer and convert 2-digit integer
    // split the second one further into two sub-problems : convert 1-digit
    // but the ones from 10 to 19 which should be considered separately
    public String numberToWords(int num) {
        if(num == 0)
            return "Zero";
        // divide digits by 3 // *****
        int billion = num / 1000000000;
        int million = (num % 1000000000) / 1000000;
        int thousand = (num % 1000000) / 1000;
        int rest = num % 1000;

        String res = "";
        if(billion != 0){
            res = splitIntoThree(billion) + " Billion";
        }
        if(million != 0){
            if(!res.equals(""))
                res += " ";
            res += splitIntoThree(million) + " Million";
        }
        if(thousand != 0){
            if(!res.equals(""))
                res += " ";
            res += splitIntoThree(thousand) + " Thousand";
        }
        if(rest != 0){
            if(!res.equals(""))
                res += " ";
            res += splitIntoThree(rest);
        }
        return res;
    }
    public String splitIntoThree(int num){
        // divide three digits into digit 1 and digit 2 // *****
        int hundred = num / 100;
        int rest = num % 100;
        String res = "";
        if(hundred * rest != 0)
            res = ones(hundred) + " Hundred " + splitIntoTwo(rest);
        else if(hundred == 0 && rest != 0)
            res = splitIntoTwo(rest);
        else if(hundred != 0 && rest == 0)
            res = ones(hundred) + " Hundred";
        return res;
    }
    public String splitIntoTwo(int num){
        // divide digits into one // *****
        if(num < 10)
            return ones(num);
        else if(num < 20)
            return tenToNineteen(num); // *****
        else{
            int ten = num / 10;
            int rest = num % 10;
            if(rest != 0)
                return tens(ten) + " " + ones(rest);
            else
                return tens(ten);
        }
    }

    public String ones(int num){
        switch(num){
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
            default: return "";
        }
    }
    public String tens(int num){
        switch(num){
            // case 1: return "Ten"; (X)
            case 2: return "Twenty";
            case 3: return "Thirty";
            case 4: return "Forty";
            case 5: return "Fifty";
            case 6: return "Sixty";
            case 7: return "Seventy";
            case 8: return "Eighty";
            case 9: return "Ninety";
            default: return "";
        }
    }
    public String tenToNineteen(int num){ // *****
        switch(num){
            case 10: return "Ten";
            case 11: return "Eleven";
            case 12: return "Twelve";
            case 13: return "Thirteen";
            case 14: return "Fourteen";
            case 15: return "Fifteen";
            case 16: return "Sixteen";
            case 17: return "Seventeen";
            case 18: return "Eighteen";
            case 19: return "Nineteen";
            default: return "";
        }
    }


}
