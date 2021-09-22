import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj1068 {
    static int N,target,cnt,root;
    static boolean[] visited;
    static ArrayList<Integer>[]graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N];
        for(int i=0;i<N;i++) graph[i] = new ArrayList<>();
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int n = Integer.parseInt(stk.nextToken());
            if(n==-1){
                root = i;
                continue;
            }
            graph[n].add(i);
        }
        visited = new boolean[N];
        target = Integer.parseInt(br.readLine());
        visited[target] = true;  //지우는 노드 방문체크
        
        if(!visited[root]) dfs(root);
        
        System.out.println(cnt);
    }

    private static void dfs(int n) {
        visited[n] = true;
        boolean find = true; 
        for(int i=0;i<graph[n].size();i++){
            int next = graph[n].get(i);
            if(!visited[next] && next!=target) { //리프노드 아님
                find = false; 
                dfs(next);
            }
        }
        if(find == true)cnt++;
    }
}
