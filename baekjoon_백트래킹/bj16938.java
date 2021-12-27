import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj16938 {
    static int N,L,R,X,ans;
    static long[] level;
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        L = Integer.parseInt(stk.nextToken());
        R = Integer.parseInt(stk.nextToken());
        X = Integer.parseInt(stk.nextToken());

        level = new long[N+1];
        stk = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            level[i] = Long.parseLong(stk.nextToken());
        }
        Arrays.sort(level);

        for(int i=2;i<=N;i++){
            p = new int[i];
            permutation(1,0,i);
        }
        System.out.println(ans);
    }

    private static void permutation(int start, int n, int len) {
        if(n==len){
            long sum = 0,diff = 0;
            long max = -1, min = Long.MAX_VALUE;
            for(int i : p){
                sum += level[i];
                max = Math.max(max,level[i]);
                min = Math.min(min,level[i]);
            }
            if(sum<L || sum>R)return;
            diff = max - min;
            if(diff<X)return;
            ans++;
            return;
        }
        for(int i=start;i<=N;i++){
            p[n] = i;
            permutation(i+1,n+1,len);
        }
    }
}
