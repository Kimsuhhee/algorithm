import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj9019 {
    static int T,A,B;
    static Queue<Info>q;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringTokenizer stk;
        while(T-- > 0) {
            stk = new StringTokenizer(br.readLine());
            A = Integer.parseInt(stk.nextToken());
            B = Integer.parseInt(stk.nextToken());
            q = new LinkedList<>();
            visited = new boolean[10001];
            q.add(new Info(A,""));
            visited[A] = true;
            bfs();
        }
    }

    private static void bfs() {
        while(!q.isEmpty()){
            Info c = q.poll();
            int cur = c.num;
            if(cur==B){
                System.out.println(c.command);
                return;
            }
            //D
            if(!visited[(cur*2)%10000]){
                q.add(new Info((cur*2)%10000,c.command+"D"));
                visited[(cur*2)%10000] = true;
            }
            //S
            if(!visited[(cur-1+10000)%10000]){
                q.add(new Info((cur-1+10000)%10000,c.command+"S"));
                visited[(cur-1+10000)%10000] = true;
            }
            //L
            int l = (cur%1000)*10+(cur/1000);
            if(!visited[l]){
                q.add(new Info(l%10000,c.command+"L"));
                visited[l] = true;
            }
            //R
            int r = (cur%10)*1000+(cur/10);
            if(!visited[r]){
                q.add(new Info(r%10000,c.command+"R"));
                visited[r] = true;
            }
        }
    }

    private static class Info {
        int num;
        String command;

        public Info(int num, String command) {
            this.num = num;
            this.command = command;
        }
    }
}
