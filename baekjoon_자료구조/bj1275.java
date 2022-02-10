import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1275 {
    static int N,Q;
    static long[] tree, arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        Q = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        arr = new long[N];
        for(int i=0;i<N;i++){
            arr[i] = Long.parseLong(stk.nextToken());
        }

        int H = (int)Math.ceil(Math.log(N)/Math.log(2));
        int treeSize = (int)Math.pow(2,H+1);
        tree = new long[treeSize];

        init(1,0,N-1);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<Q;i++){
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            int a = Integer.parseInt(stk.nextToken());
            long b = Integer.parseInt(stk.nextToken());
            //순서 조정
            if(x>y){
                int temp = 0;
                temp = x;
                x = y;
                y = temp;
            }
            //x~y번째 합
            sb.append(query(1,0,N-1,x-1,y-1)+"\n");
            //a번째 수를 b로 바꾸기
            long diff = b - arr[a-1];
            arr[a-1] = b;
            update(1,0,N-1,a-1,diff);
        }
        System.out.print(sb);
    }

    private static void update(int node, int start, int end, int idx, long diff) {
        if(idx<start || idx>end)return;
        tree[node] += diff;
        if(start!=end) {
            update(node*2, start, (start + end) / 2, idx, diff);
            update(node*2+1, (start+end)/2+1, end, idx, diff);
        }
    }

    private static long query(int node, int start, int end, int left, int right) {
        if(left>end || right<start)return 0;
        if(left<=start && end<=right)return tree[node];
        return query(node*2,start,(start+end)/2,left,right)+query(node*2+1,(start+end)/2+1,end,left,right);
    }

    private static long init(int node, int start, int end) {
        if(start==end)return tree[node] = arr[start];
        return tree[node] = init(node*2,start,(start+end)/2) + init(node*2+1,(start+end)/2+1,end);
    }
}
