import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2230 {
    static int N,M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int st = 0;
        int en = 0;
        int min = Integer.MAX_VALUE;

        while(st<N && en<N){
            int gap = Math.abs(arr[st]-arr[en]);
            if(gap<M){
                en++;
            }else {
                min = Math.min(min,gap);
                st++;
            }
        }
        System.out.println(min);
    }
}
