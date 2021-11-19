import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj14921 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        int res = 0;
        int gap = Integer.MAX_VALUE;
        int st = 0;
        int en = N-1;
        while(st<en){
            int g = arr[st]+arr[en];
            if(Math.abs(g)<gap){
                gap = Math.abs(g);
                res = g;
            }
            if(g==0)break;
            if(g>0)en--;
            else st++;
        }
        System.out.println(res);
    }
}
