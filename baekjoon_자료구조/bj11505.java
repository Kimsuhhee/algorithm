import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11505 {
    static int N,M,K;
    static long[] arr, Tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        arr = new long[N];
        Tree = new long[N * 4];

        for(int i=0;i<N;i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        init(1,0,N-1);

        for(int i=0;i<M+K;i++){
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            long c = Long.parseLong(stk.nextToken());
            if(a==1){
                update(1, 0, N-1, b-1, c);
            }else{
                System.out.println(mul(1, 0, N-1, b-1, (int)c-1));
            }
        }
    }

    private static long mul(int idx, int L, int R, int left, int right) {
        if(left > R || right < L) return 1;
        if(left <= L && right >= R) return Tree[idx];
        return (mul(idx*2, L, (L+R)/2, left, right)
                * mul(idx*2+1, (L+R)/2+1, R, left, right)) % 1000000007;
    }

    private static long update(int idx, int L, int R, int target, long c) {
        if(target < L || target > R) return Tree[idx] % 1000000007;
        if(L==R)return Tree[idx] = c;
        return Tree[idx] = (update(idx*2, L, (L+R)/2, target, c)
                * update(idx*2+1, (L+R)/2+1, R, target, c)) % 1000000007;
    }

    private static long init(int idx, int L, int R) {
        if(L==R)return Tree[idx] = arr[L];
        return Tree[idx] = (init(idx*2, L, (L+R)/2) * init(idx*2+1, (L+R)/2+1, R)) % 1000000007;
    }
}
