import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10942 {
    static int N,M;
    static int[] arr;
    static int[][]d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        d = new int[N][N];
        dp();
        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(M-- > 0){
            stk = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());
            sb.append(d[s-1][e-1]+"\n");
        }
        System.out.print(sb);
    }

    private static void dp() {
        //길이가 1인 경우
        for(int i=0;i<N;i++){
            d[i][i] = 1;
        }

        //길이가 2인 경우
        for(int i=0;i<N-1;i++){
            if(arr[i]==arr[i+1]){
                d[i][i+1] = 1;
            }
        }

        //길이가 3이상인 경우
        for(int i=3;i<=N;i++){
            for(int j=0;j<N-i+1;j++){
                if(arr[j]==arr[j+i-1] && d[j+1][j+i-2]==1){
                    d[j][j+i-1] = 1;
                }
            }
        }
    }
}
