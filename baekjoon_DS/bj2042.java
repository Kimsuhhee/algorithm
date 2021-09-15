import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2042 {
    static int N,M,K,a,b;
    static long[] arr,Tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        arr = new long[N];
        Tree = new long[4*N];

        for(int i=0;i<N;i++){
            arr[i] = Long.parseLong(br.readLine());
        }
        init(1,0,N-1);
        for(int i=0;i<M+K;i++){
            stk = new StringTokenizer(br.readLine());
            a = Integer.parseInt(stk.nextToken());
            b = Integer.parseInt(stk.nextToken());
            long c = Long.parseLong(stk.nextToken());
            if(a==1){
                long diff = c-arr[b-1];
                arr[b-1] = c;
                update(1,0,N-1,b-1,diff);
                continue;
            }
            if(a==2){
                System.out.println(sum(1,0,N-1,b-1,(int)c-1));
            }
        }
    }

    private static long sum(int node, int start, int end, int left, int right) {
        if(left > end || right < start){
            return 0;
        }
        if(left <= start && end <= right){
            return Tree[node];
        }
        return sum(node*2,start,(start+end)/2,left,right) + sum(node*2+1,(start+end)/2+1,end,left,right);
    }

    private static void update(int node, int start, int end, int index, long diff) {
        if(index < start || index > end)return;
        Tree[node] = Tree[node] + diff;

        if(start != end){
            update(node*2,start,(start+end)/2,index,diff);
            update(node*2+1,(start+end)/2+1,end,index,diff);
        }
    }

    private static long init(int node, int start, int end) {
        if(start==end){
            return Tree[node] = arr[start];
        }else{
            return Tree[node] = init(node*2,start,(start+end)/2) + init(node*2+1,(start+end)/2+1,end);
        }
    }

}
