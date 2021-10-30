import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1495 {
    static int N,S,M;
    static int[] v;
    static boolean[][]d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        S = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        v = new int[N];
        stk = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            v[i] = Integer.parseInt(stk.nextToken());
        }
        d = new boolean[N][M+1];
        if(S-v[0]>=0)d[0][S-v[0]] = true;
        if(S+v[0]<=M)d[0][S+v[0]] = true;

        for(int i=1;i<N;i++){
            for(int j=0;j<=M;j++){
                if(!d[i-1][j])continue;
                if(j-v[i]>=0)d[i][j-v[i]] = true;
                if(j+v[i]<=M)d[i][j+v[i]] = true;
            }
        }
        int answer = -1;
        for(int i=0;i<=M;i++){
            if(d[N-1][i]) {
                answer = i;
            }
        }
        System.out.println(answer);
    }
}
