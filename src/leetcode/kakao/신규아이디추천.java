package leetcode.kakao;

public class 신규아이디추천 {
    public String solution(String new_id) {
        // step 1.
        char[] charArray = new_id.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char character : charArray) {
            if (Character.isLetter(character)) {
                sb.append(Character.toLowerCase(character));
            } else {
                sb.append(character);
            }
        }

        // step 2.
        charArray = sb.toString().toCharArray();
        sb = new StringBuilder();
        for(char character : charArray) {
            if(Character.isLetter(character) || Character.isDigit(character) || character == '-' || character == '_' || character == '.') {
                sb.append(character);
            }
        }

        // step 3.
        charArray = sb.toString().toCharArray();
        sb = new StringBuilder();
        for(int i = 0; i < charArray.length; i++) {
            if(charArray[i] == '.' && i + 1 < charArray.length && charArray[i + 1] == '.') {
                continue;
            }
            else {
                sb.append(charArray[i]);
            }
        }

        // step 4.
        charArray = sb.toString().toCharArray();
        sb = new StringBuilder();
        for(int i = 0; i < charArray.length; i++) {
            if((i == 0 && charArray[i] == '.') || (i == charArray.length - 1 && charArray[i] == '.')) {
                continue;
            }
            else {
                sb.append(charArray[i]);
            }
        }

        // step 5.
        charArray = sb.toString().toCharArray();
        if(charArray.length == 0) {
            sb = new StringBuilder();
            sb.append('a');
        }

        // step 6.
        charArray = sb.toString().toCharArray();
        if(charArray.length >= 16) {
            sb = new StringBuilder();
            for(int i = 0; i < 15; i++) {
                if(!(i == 14 && charArray[i] == '.')) {
                    sb.append(charArray[i]);
                }
            }
        }

        // step 7.
        charArray = sb.toString().toCharArray();
        if(charArray.length < 3) {
            sb = new StringBuilder();

            int i = 0;
            while(sb.length() < 3) {
                if(i < charArray.length) {
                    sb.append(charArray[i]);
                } else {
                    sb.append(charArray[charArray.length - 1]);
                }
                i++;
            }
        }

        return sb.toString();
    }
}
