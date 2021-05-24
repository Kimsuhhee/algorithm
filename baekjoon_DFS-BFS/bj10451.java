import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj10451 {
    static int T,N,s;
    static int cnt;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(T-- > 0){
            N = Integer.parseInt(br.readLine());
            arr = new int[N+1];
            visited = new boolean[N+1];
            cnt = 0;

            StringTokenizer stk = new StringTokenizer(br.readLine()," ");
            for(int i=1;i<=N;i++){
                arr[i] = Integer.parseInt(stk.nextToken());
            }

            for(int i=1;i<=N;i++){
                if(!visited[i]) {
                    dfs(i);
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int start) {
        visited[start] = true;

        if(!visited[arr[start]])
            dfs(arr[start]);

    }
}
