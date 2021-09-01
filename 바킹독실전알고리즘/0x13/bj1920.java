import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1920 {
    static int N,M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(arr);
        M = Integer.parseInt(br.readLine());
        stk = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<M;i++){
            int num = Integer.parseInt(stk.nextToken());
            if(binarySearch(num)) System.out.println(1);
            else System.out.println(0);
        }

    }

    private static boolean binarySearch(int num) {
        int st = 0, en = arr.length-1;
        int mid = 0;
        boolean find = false;
        while(st<=en){
            mid = (st+en)/2;
            if(arr[mid]>num){
                en = mid-1;
            }else if(arr[mid]<num){
                st = mid+1;
            }else if(arr[mid]==num){
                find = true; break;
            }
        }
        return find;
    }
}
