class ExcelSheetColumnTitle {
    int SIZE = 26;
    public String convertToTitle(int n) {
        char[] alphabets = new char[SIZE];
        alphabets[0] = 'A'; alphabets[1] = 'B'; alphabets[2] = 'C';
        alphabets[3] = 'D'; alphabets[4] = 'E'; alphabets[5] = 'F';
        alphabets[6] = 'G'; alphabets[7] = 'H'; alphabets[8] = 'I';
        alphabets[9] = 'J'; alphabets[10] = 'K'; alphabets[11] = 'L';
        alphabets[12] = 'M'; alphabets[13] = 'N'; alphabets[14] = 'O';
        alphabets[15] = 'P'; alphabets[16] = 'Q'; alphabets[17] = 'R';
        alphabets[18] = 'S'; alphabets[19] = 'T'; alphabets[20] = 'U';
        alphabets[21] = 'V'; alphabets[22] = 'W'; alphabets[23] = 'X';
        alphabets[24] = 'Y'; alphabets[25] = 'Z';
        
        String res = "";
        while (n > 0) {
            if (n >= SIZE) {
                int d = n % SIZE;
                if (d == 0) {
                    res += alphabets[SIZE - 1];
                    n = (n / SIZE) - 1;
                } else {
                    res += alphabets[d - 1];
                    n /= 26;
                }
            } else {
                res += alphabets[n - 1];
                break;
            }
        }
        StringBuilder sb = new StringBuilder(res);
        return sb.reverse().toString();
    }
}