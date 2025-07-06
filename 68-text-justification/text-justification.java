class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int i = 0, n = words.length;

        while (i < n) {
            int j = i + 1;
            int lineLen = words[i].length();


            while (j < n && lineLen + 1 + words[j].length() <= maxWidth) {
                lineLen += 1 + words[j].length(); // 1 for space
                j++;
            }

            int gaps = j - i - 1;
            StringBuilder line = new StringBuilder();

            if (j == n || gaps == 0) {
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) line.append(" ");
                }
            
                while (line.length() < maxWidth) line.append(" ");
            } else {
                int totalSpaces = maxWidth;
                for (int k = i; k < j; k++) totalSpaces -= words[k].length();

                int spacePerGap = totalSpaces / gaps;
                int extraSpaces = totalSpaces % gaps;

                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) {
                        int spaces = spacePerGap + (extraSpaces-- > 0 ? 1 : 0);
                        for (int s = 0; s < spaces; s++) line.append(" ");
                    }
                }
            }

            res.add(line.toString());
            i = j;
        }

        return res;
    }
}
