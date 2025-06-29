import java.util.*;

class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int total = 0;

        for (int i = 0; i < s.length(); i++) {
            int current = map.getOrDefault(s.charAt(i), -1);
            int next = (i + 1 < s.length()) ? map.getOrDefault(s.charAt(i + 1), -1) : 0;

            if (current == -1) {
                throw new IllegalArgumentException("Invalid Roman character: " + s.charAt(i));
            }

            if (current < next) {
                total -= current;
            } else {
                total += current;
            }
        }

        return total;
    }
}
