import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14889 {
    static int N;
    static int ability = 101;
    static boolean[] visited;
    static int[]start;
    static int[]link;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        visited = new boolean[N+1];
        link = new int[N/2];
        start = new int[N/2];
        for(int i=1;i<=N;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=N;j++){
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        permutation(0,0);
        System.out.println(ability);
    }

    private static void permutation(int s, int n) {
     if(n==N/2){
         ability = Math.min(ability,cal_ability());
         return;
     }
     for(int i=s+1;i<=N;i++){
         if(!visited[i]) {
             visited[i] = true;
             start[n] = i;
             permutation( i,n+1);
             visited[i] = false;
         }
     }
    }

    private static int cal_ability() {
        int sum1 = 0,sum2=0;
        int idx = 0;
        for(int i=1;i<=N;i++){
            if(!visited[i]){
                link[idx++] = i;
            }
        }

        for(int i=0;i<N/2;i++){
            for(int j=0;j<N/2;j++){
                if(i==j)continue;
                sum1 += arr[start[i]][start[j]];
                sum2 += arr[link[i]][link[j]];
            }
        }
        return Math.abs(sum1-sum2);
    }
}
