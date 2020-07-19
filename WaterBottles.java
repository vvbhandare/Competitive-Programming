class WaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        while (numBottles >= numExchange) {
            int t = numBottles / numExchange;
            res += t;
            numBottles = t + (numBottles % numExchange);
        }
        return res;
    }
}