import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj17073 {
    static int N,W;
    static double lcnt;
    static ArrayList<Integer>[]tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        W = Integer.parseInt(stk.nextToken());

        tree = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            tree[i] = new ArrayList<>();
        }

        for(int i=1;i<N;i++){
            stk = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(stk.nextToken());
            int V = Integer.parseInt(stk.nextToken());
            tree[U].add(V);
            tree[V].add(U);
        }

        for(int i=2;i<=N;i++){
            // 연결된 간선이 하나만 있음 --> 리프노드
            if(tree[i].size()==1) lcnt++;
        }
        System.out.println(W/lcnt);
    }

}
