package 쩜튜브;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj5557 {
    static int N;
    static int[] arr;
    static long[][] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        d = new long[N][21];
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)
            arr[i] = Integer.parseInt(stk.nextToken());
        System.out.println(dp());

    }

    private static long dp() {
        d[0][arr[0]] = 1;

        for(int i=1;i<N-1;i++){
            for(int j=0;j<21;j++){
                if(d[i-1][j]!=0){
                    if(j+arr[i]<21){
                        d[i][j+arr[i]] += d[i-1][j];
                    }
                    if(j-arr[i]>=0){
                        d[i][j-arr[i]] += d[i-1][j];
                    }
                }
            }
        }
        return d[N-2][arr[N-1]];
    }

}
