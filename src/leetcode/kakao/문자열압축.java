package leetcode.kakao;

public class 문자열압축 {
    public int solution(String s) {
        int answer = s.length();

        for(int i = 1; i <= s.length() / 2; i++) { // because if we cut string over than the half of the length, we cannot compress it
            int pos = 0;
            int len = s.length();

            for(; pos + i <= s.length();) { // inside for, increase the pos
                String unit = s.substring(pos, pos + i);
                pos += i;

                int cnt = 0;
                for(;pos + i <= s.length();) {
                    if(unit.equals(s.substring(pos, pos + i))) {
                        cnt++; // cnt value is 1 less than actual count of the unit
                        pos += i;
                    } else {
                        break;
                    }
                }

                // don't need actual compressed string
                if(cnt > 0) {
                    len -= i * cnt; // delete units except the first unit

                    if(cnt < 9) len += 1; // add the cnt in front of the unit
                    else if(cnt < 99) len += 2;
                    else if(cnt < 999) len += 3;
                    else    len += 4; // s의 길이는 1 이상 1,000 이하입니다. e.g. 1000a
                }
                answer = Math.min(answer, len);
            }
        }
        return answer;
    }
}
