import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// 3
// 3 2 1

//0 0 3 4 1 2

// Initial : [3, 2, 1]
// l : 0 m : 0 r : 1
// After Sort : [2, 3, 1]   //count = 1

// Initial : [2, 3, 1]
// l : 0 m : 1 r : 2
// After Sort : [1, 2, 3]   //count = 1 + 2 = 3

// 3


public class MergeSortCountingInversions {

    // Complete the countInversions function below.
    static long countInversions(int[] arr) {
        return divideNConquer(arr, 0, arr.length - 1);
    }

    private static long divideNConquer(int[] a, int l, int r) {
        // TODO Auto-generated method stub
        long count = 0;
        if (l < r) {
            int mid = l + (r - l) / 2;
            count += divideNConquer(a, l, mid);
            count += divideNConquer(a, mid + 1, r);
            count += merge(a, l, mid, r);
        }
        return count;
    }

    private static long merge(int[] arr, int l, int m, int r) {
        // TODO Auto-generated method stub
        int n1 = m - l + 1, n2 = r - m; 
      
        int L[] = new int[n1];
        for(int i = 0; i < n1; i++) L[i] = arr[l + i]; 
        
        int R[] = new int[n2];
        for(int j = 0; j < n2; j++) R[j] = arr[m + 1 + j]; 
      
        int i = 0, j = 0, k = l;
        long count = 0; 
          
        while (i < n1 && j < n2) { 
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else { 
                arr[k++] = R[j++]; 
                count += L.length - i;
            } 
        } 
      
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
        
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            long result = countInversions(arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
