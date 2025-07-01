class Solution {
    public int possibleStringCount(String word) {
    
        int count = 1; 

        for (int i = 0, n = word.length(); i < n; ) {
            int j = i + 1;
            while (j < n && word.charAt(j) == word.charAt(i)) j++;
            int len = j - i;
            if (len > 1) count += len - 1;
            i = j;
        }

        return count;
    }
}
