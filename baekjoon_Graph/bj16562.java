import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj16562 {
    static int N,M,k;
    static int[] cost, parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        cost = new int[N+1];
        stk = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            cost[i] = Integer.parseInt(stk.nextToken());
        }

        parent = new int[N+1];
        for(int i=1;i<=N;i++){
            parent[i] = i;
        }

        for(int i=0;i<M;i++){
            stk = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(stk.nextToken());
            int w = Integer.parseInt(stk.nextToken());
            union(v,w);
        }

        int answer = 0;
        for(int i=1;i<=N;i++){
            //0(준석)이랑 연결X
            if(find(i)!=0){
                //현재 자신의 루트 노드의 비용 더하기
                answer += cost[find(i)];
                //0과 합침
                union(0,i);
            }
        }
        //비용이 k이하 인지 확인
        if(answer<=k) {
            System.out.println(answer);
        }else System.out.println("Oh no");
    }

    private static boolean union(int v, int w) {
        int pv = find(v);
        int pw = find(w);
        if(pv==pw) {
            return false;
        }else {
            //루트노드는 최소값을 유지할 수 있도록 하기
            if (cost[pv] <= cost[pw]) {
                parent[pw] = pv;
            } else {
                parent[pv] = pw;
            }
            return true;
        }
    }

    private static int find(int v) {
        if(v==parent[v])return v;
        return parent[v] = find(parent[v]);
    }
}
