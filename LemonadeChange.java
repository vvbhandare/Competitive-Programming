class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int f = 0, t = 0, tt = 0;
        for (int i : bills) {
            if (i == 5) f++;
            else if (i == 10 && f > 0) {
            	t++;
            	f--;
            } else if (i == 20 && t > 0 && f > 0) {
            	tt++;
            	t--;
            	f--;
            } else if (i == 20 && f >= 3) {
            	tt++;
            	f -= 3;
            } else return false;
        }
        return true;
    }
}