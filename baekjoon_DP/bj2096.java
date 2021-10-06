import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2096 {
    static int N;
    static int[][]min,max,arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer stk;
        arr = new int[N+1][3];
        max = new int[N+1][3];
        min = new int[N+1][3];

        for(int i=1;i<=N;i++){
            stk = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(stk.nextToken());
            arr[i][1] = Integer.parseInt(stk.nextToken());
            arr[i][2] = Integer.parseInt(stk.nextToken());

            max[i][0] = Math.max(max[i-1][0],max[i-1][1])+arr[i][0];
            min[i][0] = Math.min(min[i-1][0],min[i-1][1])+arr[i][0];

            max[i][1] = Math.max(Math.max(max[i-1][0],max[i-1][1]),max[i-1][2])+arr[i][1];
            min[i][1] = Math.min(Math.min(min[i-1][0],min[i-1][1]),min[i-1][2])+arr[i][1];

            max[i][2] = Math.max(max[i-1][1],max[i-1][2])+arr[i][2];
            min[i][2] = Math.min(min[i-1][1],min[i-1][2])+arr[i][2];
        }
        int m1 = Math.max(Math.max(max[N][0],max[N][1]),max[N][2]);
        int m2 = Math.min(Math.min(min[N][0],min[N][1]),min[N][2]);

        System.out.println(m1+" "+m2);

    }
}
