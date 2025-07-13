class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int play=0, train=0;
        int ans = 0;
        Arrays.sort(trainers);
        Arrays.sort(players);
        while(play < players.length && train < trainers.length){
            if(players[play] <= trainers[train]){
                ans++;
                play++;
                train++;
            }
            else
                train++;

        }

        return ans;
        
    }
}