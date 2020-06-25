package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {
    // T.C: O(1)
    // S.C: O(M) where M is the number of all the incoming messages
    private Map<String, Integer> map;
    /** Initialize your data structure here. */
    public LoggerRateLimiter() {
        map = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!map.containsKey(message)){
            map.put(message, timestamp);
            return true;
        }

        Integer oldTimestamp = map.get(message);
        if(timestamp - oldTimestamp >= 10){
            map.put(message, timestamp);
            return true;
        }
        else
            return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */