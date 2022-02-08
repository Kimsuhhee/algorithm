import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2243 {
    static int n;
    static long[]tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        //사탕 맛 1~1000000
        int H = (int)Math.ceil(Math.log(1000000)/Math.log(2));
        int treeSize = (int)Math.pow(2,H+1);
        tree = new long[treeSize];

        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            stk = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(stk.nextToken());
            int B = Integer.parseInt(stk.nextToken());
            if(A==1){
                int rank = query(1,0,1000000,B);
                sb.append(rank+"\n");
                update(1,0,1000000,rank,-1);
            }else if(A==2){
                int C = Integer.parseInt(stk.nextToken());
                update(1,0,1000000,B,C);
            }
        }
        System.out.print(sb);
    }

    private static int query(int node, int start, int end, long rank) {
        if(start==end) return start;
        int mid = (start+end)/2;
        //왼쪽자식노드개수가 rank와 같거나 큰경우
        if(rank <= tree[node*2])return query(node*2,start,mid,rank);
        else {
            return query(node*2+1,mid+1,end,rank-tree[node*2]);
        }
    }

    private static void update(int node, int start, int end, int rank, int diff) {
        if(rank < start || rank > end)return;
        tree[node] += diff;
        if(start != end){
            update(node*2,start,(start+end)/2,rank,diff);
            update(node*2+1,(start+end)/2+1,end,rank,diff);
        }
    }
}
