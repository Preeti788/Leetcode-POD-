class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        
        Arrays.sort(players); 
        Arrays.sort(trainers);

        int matches = 0;
        int i = 0, j = 0;

        while (i < players.length && j < trainers.length) {
            if (players[i] <= trainers[j]) {
                matches++;
                i++;
            }
            j++;
        }

        return matches;
    }
}