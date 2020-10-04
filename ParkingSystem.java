class ParkingSystem {

    int[] res;
    public ParkingSystem(int big, int medium, int small) {
        res = new int[3];
        res[0] = big;
        res[1] = medium;
        res[2] = small;
    }
    
    public boolean addCar(int ct) {
        if (res[ct - 1] == 0) return false;
        else {
            res[ct - 1]--;
            return true;
        }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */