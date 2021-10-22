import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1963 {
    static int a,b,answer;
    static int[] sieve = new int[10001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        primeSieve();
        while(T-- > 0){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            a = Integer.parseInt(stk.nextToken());
            b = Integer.parseInt(stk.nextToken());
            answer = -1;
            bfs();
            if(answer == -1) System.out.println("Impossible");
            else System.out.println(answer);
        }
    }

    private static void primeSieve() {
        for(int i=1;i<=10000;i++){
            sieve[i] = i;
        }
        for(int i=2;i<=10000;i++){
            for(int j=i+i;j<=10000;j+=i){
                if(sieve[j]==0)continue;
                sieve[j] = 0;
            }
        }
    }

    private static void bfs() {
        Queue<Info>q = new LinkedList<>();
        boolean[] visited = new boolean[10000];
        q.add(new Info(String.valueOf(a),0));
        visited[a] = true;
        while(!q.isEmpty()){
            Info info = q.poll();
            int cur = Integer.parseInt(info.s);
            if(cur==b){
                answer = info.cnt;
                break;
            }
            for(int i=1000;i<=9999;i++){
                if(sieve[i]!=0 && !visited[i]){
                    String pnum = String.valueOf(i);
                    int check = 0;
                    for(int j=0;j<4;j++){
                        if(pnum.charAt(j)!=info.s.charAt(j))check++;
                    }
                    if(check==1){
                        q.add(new Info(pnum,info.cnt+1));
                        visited[i] = true;
                    }
                }
            }
        }

    }

    private static class Info {
        String s;
        int cnt;

        public Info(String s, int cnt) {
            this.s = s;
            this.cnt = cnt;
        }
    }
}
