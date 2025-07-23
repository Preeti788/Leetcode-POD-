class Solution {
    public int maximumGain(String s, int x, int y) {
        if (x > y) {
            Result res1 = removePattern(s, 'a', 'b', x);
            Result res2 = removePattern(res1.remaining, 'b', 'a', y);
            return res1.score + res2.score;
        } else {
            Result res1 = removePattern(s, 'b', 'a', y);
            Result res2 = removePattern(res1.remaining, 'a', 'b', x);
            return res1.score + res2.score;
        }
    }

    class Result {
        int score;
        String remaining;
        Result(int score, String remaining) {
            this.score = score;
            this.remaining = remaining;
        }
    }

    private Result removePattern(String s, char first, char second, int scoreValue) {
        StringBuilder stack = new StringBuilder();
        int score = 0;

        for (char c : s.toCharArray()) {
            if (stack.length() > 0 && stack.charAt(stack.length() - 1) == first && c == second) {
                stack.deleteCharAt(stack.length() - 1);
                score += scoreValue;
            } else {
                stack.append(c);
            }
        }

        return new Result(score, stack.toString());
    }
}
