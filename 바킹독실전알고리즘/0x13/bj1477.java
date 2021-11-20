import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1477 {
    static int N,M,L;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken()); //현재 휴개소의 개수
        M = Integer.parseInt(stk.nextToken()); //더 지으려고 하는 휴게소의 개수
        L = Integer.parseInt(stk.nextToken()); //고속도로의 길이

        arr = new int[N+2];
        stk = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        arr[N+1] = L;
        Arrays.sort(arr);

        int st = 1;
        int en = L-1;
        int res = 0;
        while(st<=en){
            //휴게소 간 간격
            int mid = (st+en)/2;

            int cnt = 0;
            for(int i=1;i<=N+1;i++){
                cnt += (arr[i]-arr[i-1]-1)/mid;
            }
            if(cnt<=M){
                res = mid;
                en = mid - 1;
            }
            else {
                st = mid + 1;
            }
        }
        System.out.println(res);
    }
}
