import java.io.*;
import java.util.Arrays;
import java.util.Collections;


public class bj11931 {
    static int N;
    static Integer[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new Integer[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr, Collections.reverseOrder());
        for(int i=0;i<N;i++){
            bw.write(arr[i]+"\n");
        }
        bw.flush();
        bw.close();
    }
}
