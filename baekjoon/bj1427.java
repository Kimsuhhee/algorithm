import java.io.*;
import java.util.*;

public class bj1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        String arr[]=s.split("");

        Arrays.sort(arr, Comparator.reverseOrder());
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]);
        br.close();
    }
}
