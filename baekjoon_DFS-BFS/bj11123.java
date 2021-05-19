import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj11123 {
    static int H,W,cnt;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static char[][] map;
    static boolean[][] visited;
    static Queue<Point>q = new LinkedList<>();

    private static class Point {
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            StringTokenizer stk = new StringTokenizer(br.readLine()," ");
            H = Integer.parseInt(stk.nextToken());
            W = Integer.parseInt(stk.nextToken());

            map = new char[H][W];
            visited = new boolean[H][W];
            q.clear();
            for(int i=0;i<H;i++){
                String s = br.readLine();
                for(int j=0;j<W;j++){
                    map[i][j] = s.charAt(j);
                }
            }
            ArrayList list = new ArrayList();
            for(int i=0;i<H;i++){
                for(int j=0;j<W;j++){
                    if(map[i][j]=='#'&&!visited[i][j]){
                        q.add(new Point(i,j));
                        visited[i][j] = true;
                        cnt=0;
                        bfs();
                        cnt++;
                        list.add(cnt);
                    }
                }
            }
            sb.append(list.size()).append("\n");
        }
        System.out.println(sb);

    }

    private static void bfs() {
        while(!q.isEmpty()){
            Point temp = q.poll();
            for(int i=0;i<4;i++){
                int x = temp.x + dx[i];
                int y = temp.y + dy[i];
                if(x<0||y<0||x>=H||y>=W)continue;
                if(map[x][y]=='#'&&!visited[x][y]){
                    q.add(new Point(x,y));
                    visited[x][y] = true;
                }
            }
        }
    }

}
