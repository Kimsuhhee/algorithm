import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class bj10989 {
    static int N;
    static int [] counting = new int[10002];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            int x = Integer.parseInt(br.readLine());
            counting[x]++;
        }

        for(int i=0;i<10001;i++){
            if(counting[i]==0)
                continue;

            for(int j=0;j<counting[i];j++)
                sb.append(i).append("\n");
        }
        System.out.print(sb.toString());
        br.close();
    }
}
