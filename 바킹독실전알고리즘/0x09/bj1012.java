import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1012 {
    static int[][] map;
    static boolean[][] visited;
    static Queue<Point> q = new LinkedList<>();
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int N,M,K;

    private static class Point {
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<T;i++) {
            String nmk = br.readLine();
            StringTokenizer stk = new StringTokenizer(nmk," ");
            N = Integer.parseInt(stk.nextToken());  //x
            M = Integer.parseInt(stk.nextToken());  //y
            K = Integer.parseInt(stk.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];
            q.clear();

            for (int j = 0; j < K; j++) {
                String s = br.readLine();
                stk = new StringTokenizer(s);
                int x = Integer.parseInt(stk.nextToken());
                int y = Integer.parseInt(stk.nextToken());
                map[x][y] = 1;
            }

            int cnt = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[j][k] == 1 && !visited[j][k]) {
                        q.add(new Point(j,k));
                        visited[j][k] = true;
                        cnt++;
                        bfs();
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs() {
        while(!q.isEmpty()){
            Point tmp = q.poll();
            for(int i=0;i<4;i++){
                int mx = tmp.x +dx[i];
                int my = tmp.y +dy[i];
                if(mx<0 || my<0 || mx>=N||my>=M) continue;
                if(map[mx][my]==1 && !visited[mx][my]){
                    q.add(new Point(mx,my));
                    visited[mx][my] = true;
                }
            }
        }
    }

}
