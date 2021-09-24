import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10819 {
    static int N,max;
    static boolean[] check;
    static int[] arr,com;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        check = new boolean[N];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        com = new int[N];
        combination(0);
        System.out.println(max);
    }

    private static void combination(int n) {
        if(n==N){
            max = Math.max(max,cal());
            return;
        }
        for(int i=0;i<N;i++){
            if(!check[i]){
                check[i] = true;
                com[n] = i;
                combination(n+1);
                check[i] = false;
            }
        }
    }

    private static int cal() {
        int sum = 0;
        for(int i=0;i<N-1;i++){
            sum += Math.abs(arr[com[i]]-arr[com[i+1]]);
        }
        return sum;
    }
}
