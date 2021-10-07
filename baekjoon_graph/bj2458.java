import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2458 {
    static int N,M;
    static boolean[][]students;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        students = new boolean[N+1][N+1];
        while(M-- > 0){
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            students[a][b] = true;
        }

        for(int k=1;k<=N;k++){
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    if(i==j || j==k || k==i)continue;
                    if(students[i][k] && students[k][j]) students[i][j] = true;
                }
            }
        }

        int cnt = 0;
        for(int i=1;i<=N;i++){
            int sum = 0;
            for(int j=1;j<=N;j++){
                if(i==j)continue;
                if(!students[i][j]&&!students[j][i]) continue;
                sum++;
            }
            if(sum==N-1)cnt++;
        }
        System.out.println(cnt);

    }
}
