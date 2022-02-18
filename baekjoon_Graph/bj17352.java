import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj17352 {
    static int N,idx;
    static int[] p,answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        p = new int[N+1];
        for(int i=1;i<=N;i++){
            p[i] = i;
        }

        StringTokenizer stk;
        //다리 연결
        for(int i=0;i<N-2;i++){
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            union(a,b);
        }

        int answer = -1;
        for(int i=2;i<=N;i++){
            //1과 i번다리를 연결할수 있다면 연결안되어 있는 상태임
            if(union(1,i)){
                answer = i;
            }
            if(answer !=-1)break;
        }
        System.out.println(1+" "+answer);
    }

    private static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a!=b) {
            p[b] = a;
            return true;
        }
        return false;
    }

    private static int find(int a) {
        if(a==p[a])return a;
        return p[a] = find(p[a]);
    }
}
