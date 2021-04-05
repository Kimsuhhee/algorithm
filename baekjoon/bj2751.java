import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class bj2751 {
    static int N;
    static ArrayList<Integer> arr = new ArrayList<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            arr.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(arr);
        for(int i=0;i<N;i++)
            bw.write(arr.get(i)+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
