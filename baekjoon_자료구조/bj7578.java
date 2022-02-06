import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class bj7578 {
    static int N,H;
    static HashMap<Integer,Integer> A;
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer stk;

        A = new HashMap<>();
        stk = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int a = Integer.parseInt(stk.nextToken());
            A.put(a,i);
        }

        //트리 높이
        H = (int)Math.ceil(Math.log(N)/Math.log(2));
        int treeSize = (int)Math.pow(2,H+1);
        tree = new long[treeSize];

        long answer = 0;
        stk = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int b = Integer.parseInt(stk.nextToken());
            int idx = A.get(b);
            
            //현재 인덱스보다 큰 인덱스를 포함한 영역에서 연결한 케이블 선의 개수 찾기
            answer += query(1,0,N-1,idx+1,N-1);
            
            //현재 인덱스를 포함한 구간에 +1
            update(1,0,N-1,idx,1);
        }
        System.out.println(answer);
    }

    private static void update(int node, int start, int end, int idx, long diff) {
        if(idx < start || idx > end)return;
        tree[node] += diff;
        if(start != end){
            update(node*2,start,(start+end)/2,idx,diff);
            update(node*2+1,(start+end)/2+1,end,idx,diff);
        }
    }

    private static long query(int node, int start, int end, int left, int right) {
        if(left > end || right < start)return 0;
        if(left <= start  && end<=right)return tree[node];
        return query(node*2,start,(start+end)/2,left,right) + query(node*2+1,(start+end)/2+1,end,left,right);
    }
}
