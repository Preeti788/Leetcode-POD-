class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int drunk = 0;
        int empty = 0;

        drunk += numBottles;
        empty += numBottles;

        while(empty >= numExchange){
            empty -= numExchange;
            numExchange++;
            numBottles = 1;

            drunk += numBottles;
            empty += numBottles;
        }

        return drunk;
        
    }
}