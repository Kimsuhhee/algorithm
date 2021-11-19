import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1253 {
    static int N;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Long.parseLong(stk.nextToken());
        }
        int cnt = 0;
        Arrays.sort(arr);
        for(int i=0;i<N;i++){
            if(binarySearch(i)){
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static boolean binarySearch(int idx) {
        int st = 0, en = N-1;
        while(st<en){
            //찾는 값(arr[idx])의 인덱스(idx)를 사용하여 합을 구하면 안됨
            if(st==idx)st++;
            if(en==idx)en--;

            if(st==en)break;

            long sum = arr[st]+arr[en];

            if(sum>arr[idx]){
                en--;
            }else if(sum<arr[idx]){
                st++;
            }else if(sum==arr[idx]){
                return true;
            }
        }
        return false;
    }
}
