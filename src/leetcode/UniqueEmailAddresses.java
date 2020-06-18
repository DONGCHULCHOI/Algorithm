package leetcode;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
    // Need to verify the time complexity: O(C) VS O(C * J) where C is the number of emails, and J is the longest length of the email
    public int numUniqueEmails(String[] emails) {
        // T.C: O(C) where C is the total content of emails
        // S.C: O(C)
        // r.f. In T.C, The size of the email address has upper bound so any operations of String class on them can be considered O(1)
        Set<String> seen = new HashSet<>();
        for(String email : emails){
            int i = email.indexOf('@');
            String local = email.substring(0, i);
            String domain = email.substring(i);
            // omit above "+"
            if(local.contains("+")){
                local = local.substring(0, local.indexOf("+"));
            }
            // ignore "."
            local = local.replaceAll("\\.", "");
            seen.add(local + domain);
        }
        return seen.size();
    }
}
