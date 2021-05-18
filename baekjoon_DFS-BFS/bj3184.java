import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj3184 {
    static int R,C,s,w;
    static int[] cnt;
    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,1,0,-1};
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
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");

        R = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];
        cnt = new int[2];
        for(int i=0;i<R;i++){
            String s = br.readLine();
            for(int j=0;j<C;j++){
                map[i][j] = s.charAt(j);
            }
        }

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(map[i][j]!='#' && !visited[i][j]){
                    q.add(new Point(i,j));
                    visited[i][j] = true;
                    s=0; w=0;
                    bfs();
                    if(s>w){
                        cnt[0]+=s;
                    }else{
                        cnt[1]+=w;
                    }
                }
            }
        }

        System.out.println(cnt[0]+" "+cnt[1]);

    }

    private static void bfs() {
        while(!q.isEmpty()){
            Point temp = q.poll();
            if(map[temp.x][temp.y]=='v')w++;
            if(map[temp.x][temp.y]=='o')s++;
            for(int i=0;i<4;i++){
                int x = temp.x + dx[i];
                int y = temp.y + dy[i];
                if(x<0||y<0||x>=R||y>=C)continue;
                if(map[x][y]!='#' && !visited[x][y]){
                    q.add(new Point(x,y));
                    visited[x][y] = true;
                }
            }
        }
    }

}
