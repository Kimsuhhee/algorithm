import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj9466 {
    static int n,cnt;
    static int[] students;
    static boolean[] visited;
    static boolean[] finished;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            n = Integer.parseInt(br.readLine());

            students = new int[n+1];
            visited = new boolean[n+1];
            finished = new boolean[n+1];

            String studentNum = br.readLine();
            StringTokenizer stk = new StringTokenizer(studentNum," ");

            for(int i=1;i<=n;i++){
                students[i] = Integer.parseInt(stk.nextToken());
            }

            cnt = 0;

            for(int i=1;i<=n;i++){
                dfs(students[i]);
            }

            System.out.println(n-cnt);

        }
    }

    private static void dfs(int start) {
        if(visited[start])return ;

        visited[start] = true;
        int next = students[start];

        if(!visited[next]){
            dfs(next);
        }else{
            if(!finished[next]){
                cnt++;
                for(int i=next;i!=start;i=students[i])cnt++;
            }
        }
        finished[start] = true;
    }
}
