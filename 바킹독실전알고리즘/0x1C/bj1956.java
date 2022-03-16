import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1956 {
    static int V,E,a,b,c;
    static int[][]town;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        V = Integer.parseInt(stk.nextToken());
        E = Integer.parseInt(stk.nextToken());
        town = new int[V+1][V+1];
        for(int i=1;i<=V;i++){
            for(int j=1;j<=V;j++){
                town[i][j] = 50000000;
            }
        }

        for(int i=0;i<E;i++){
            stk = new StringTokenizer(br.readLine());
            a = Integer.parseInt(stk.nextToken());
            b = Integer.parseInt(stk.nextToken());
            c = Integer.parseInt(stk.nextToken());
            town[a][b] = c;
        }

        for(int k=1;k<=V;k++){
            for(int i=1;i<=V;i++){
                for(int j=1;j<=V;j++){
                    town[i][j] = Math.min(town[i][j] , town[i][k] + town[k][j]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        //사이클 최소값 갱신
        for(int i=1;i<=V;i++){
            if(town[i][i]==50000000)continue;
            min = Math.min(min,town[i][i]);
        }

        if(min==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }
}
