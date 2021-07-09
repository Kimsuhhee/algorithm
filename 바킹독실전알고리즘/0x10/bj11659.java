import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11659 {
    static int N,M,i,j;
    static int[] arr = new int[100005];
    static int[] d = new int[100005];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine()," ");
        for(int k=1;k<=N;k++){
            arr[k] = Integer.parseInt(stk.nextToken());
            d[k] = d[k-1] + arr[k];
        }

        StringBuilder sb = new StringBuilder();
        while(M-- > 0){
            stk = new StringTokenizer(br.readLine()," ");
            i = Integer.parseInt(stk.nextToken());
            j = Integer.parseInt(stk.nextToken());
            sb.append(d[j]-d[i-1]).append("\n");
        }

        System.out.print(sb);

    }
}
