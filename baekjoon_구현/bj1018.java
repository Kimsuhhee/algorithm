import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1018 {
    static int N,M,min;
    static char[][]chess;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        
        chess = new char[N][M];
        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<M;j++){
                chess[i][j] = s.charAt(j);
            }
        }

        min = Integer.MAX_VALUE;
        for(int i=0;i<=N-8;i++){
            for(int j=0;j<=M-8;j++){
                check(i,j,'B');
                check(i,j,'W');
            }
        }
        System.out.println(min);
    }

    private static void check(int x, int y, char s) {
        int cnt = 0;
        for(int i=x;i<x+8;i++){
            for(int j=y;j<y+8;j++){
                if(i%2==0){
                    if(j%2==0){
                        if(chess[i][j]!=s)cnt++;
                    }else{
                        if(chess[i][j]==s)cnt++;
                    }
                }else{
                    if(j%2!=0){
                        if(chess[i][j]!=s)cnt++;
                    }else{
                        if(chess[i][j]==s)cnt++;
                    }
                }
            }
        }
        min = Math.min(min,cnt);
    }
}
