import java.util.*;

class Solution {
    
    public static int romanToInt(String s) {

        Map<Character, Integer> romanNumerals = new HashMap<>();
        romanNumerals.put('M', 1000);
        romanNumerals.put('D', 500);
        romanNumerals.put('C', 100);
        romanNumerals.put('L', 50);
        romanNumerals.put('X', 10);
        romanNumerals.put('V', 5);
        romanNumerals.put('I', 1);


        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentchar = s.charAt(i);
            int currentValue = romanNumerals.get(currentchar);
            if (i < s.length() - 1 && romanNumerals.get(s.charAt(i + 1)) > currentValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Example usage
        String roman1 = "XCIV";
        System.out.println(roman1 + " = " + romanToInt(roman1));
    }
}
