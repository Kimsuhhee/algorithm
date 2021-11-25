import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class bj2473 {
    static int N;
    static long a,b,c;
    static long[] arr;
    static long min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new long[N];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(arr);

        min = Long.MAX_VALUE;
        for(int i=0;i<N-2;i++){
            if(binarySearch(i))break;
        }
        ArrayList<Long>list = new ArrayList<>();
        list.add(a);list.add(b);list.add(c);
        Collections.sort(list);
        for(long i:list) System.out.print(i+" ");
    }

    private static boolean binarySearch(int idx) {
        int st = idx+1, en = N-1;
        long cur = arr[idx];
        while(st<en){
            long sum = cur+arr[st]+arr[en];
            if(Math.abs(sum)<min){
                min = Math.abs(sum);
                a = cur;
                b = arr[st];
                c = arr[en];
            }
            if(sum>0){
                en--;
            }else if(sum<0){
                st++;
            }else return true;
        }
        return false;
    }
}
