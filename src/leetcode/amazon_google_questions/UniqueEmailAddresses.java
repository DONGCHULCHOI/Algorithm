package leetcode.amazon_google_questions;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        // T.C: O(C * J) where C is the number of emails, and J is the longest length of the email
        // S.C: O(C)
        // r.f. In T.C, The size of the email address has upper bound so any operations of String class on them can be considered O(1)
        Set<String> unique = new HashSet<>();
        for(String email : emails){
            int i = email.indexOf('@'); // O(S) where S is the length of email string
            String local = email.substring(0, i); // O(S)
            String domain = email.substring(i); // O(S)
            // omit above "+"
            if(local.contains("+")){ // O(S)
                local = local.substring(0, local.indexOf("+")); // O(S)
            }
            // ignore "."
            local = local.replaceAll("\\.", ""); // O(S)
            unique.add(local + domain);
        }
        return unique.size();
    }
}
