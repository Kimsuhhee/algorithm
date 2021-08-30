import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class bj1941 {
    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,1,0,-1};
    static char[][] girls = new char[5][5];
    static int[] princess;
    static boolean[] visited;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0;i<5;i++){
            String s = br.readLine();
            for(int j=0;j<5;j++){
                girls[i][j] = s.charAt(j);
            }
        }

        princess = new int[7];
        visited = new boolean[25];
        dfs(0,0,0);
        System.out.println(answer);
    }

    private static void dfs(int idx, int n, int s) {
        if(n==7){
            if(s>=4) {
                if(check()==7)answer++;
            }
            return;
        }
        for(int i=idx;i<25;i++){
            if(!visited[i]) {
                visited[i] = true;
                princess[n] = i;
                if (girls[i / 5][i % 5] == 'S') dfs(i,n+1,s+1);
                else dfs(i,n+1,s);
                visited[i] = false;
            }
        }
    }

    private static int check() {
        int[][] temp = new int[5][5];
        for(int i: princess){
            temp[i/5][i%5] = 1;
        }
        int t = 0;
        Queue<Integer>q = new LinkedList<>();
        q.add(princess[0]);
        boolean[][] ch = new boolean[5][5];
        ch[princess[0]/5][princess[0]%5] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            t++;
            for(int i=0;i<4;i++){
                int x = cur/5 + dx[i];
                int y = cur%5 + dy[i];
                if(x<0||y<0||x>=5||y>=5)continue;
                if(temp[x][y]==1&& !ch[x][y]){
                    q.add(x*5+y);
                    ch[x][y] = true;
                }
            }
        }
        return t;
    }

}
