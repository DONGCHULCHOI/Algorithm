package leetcode;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        // T.C: O(mn) where the m is the length of num1, n is the length of num2
        // S.C: O(m+n)
        // https://leetcode.com/problems/multiply-strings/discuss/17608/AC-solution-in-Java-with-explanation
        // make a product array which is num1.length() + num2.length() length of arr // *****
        // fill the arr from end to start // *****
        // use carry, from end to start in product arr, adjust the carries of digits // *****
        // (!) The digits of the product of two numbers cannot exceed the sum of the two lengths
        // e.g 100 * 100 = 10000 (4 digits), 999 * 999 = 998,001(6 digits)
        int n1 = num1.length(), n2 = num2.length();
        int[] products = new int[n1 + n2]; // *****
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int d1 = num1.charAt(i) - '0';
                int d2 = num2.charAt(j) - '0';
                products[i + j + 1] += d1 * d2; // filled from the end idx to the start idx // add the result at the proper digits // *****
            }
        }
        int carry = 0; // *****
        for (int i = products.length - 1; i >= 0; i--) { // *****
            int tmp = (products[i] + carry) % 10;
            carry = (products[i] + carry) / 10;
            products[i] = tmp;
        }
        StringBuilder sb = new StringBuilder();
        for (int num : products)
            sb.append(num); // ***

        while (sb.length() != 0 && sb.charAt(0) == '0') // the case: there is empty upper digits in the product arr // ***
            sb.deleteCharAt(0);

        return sb.length() == 0 ? "0" : sb.toString(); // the case of num1, num2 are both 0 and the product of 0 and x // ***
    }
}

