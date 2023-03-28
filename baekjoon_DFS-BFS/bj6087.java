import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj6087 {
    static int W,H,endX,endY;
    static char[][]map;
    static Queue<Point>q;
    static int[][]visited;
    static boolean[][][] checked;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        W = Integer.parseInt(stk.nextToken());
        H = Integer.parseInt(stk.nextToken());

        map = new char[H][W];
        boolean f = false;

        q = new LinkedList<>();
        visited = new int[H][W];
        for(int i=0;i<H;i++){
            Arrays.fill(visited[i],Integer.MAX_VALUE);
        }

        checked = new boolean[H*W + 1][H][W];

        for(int i=0;i<H;i++){
            String s = br.readLine();
            for(int j=0;j<W;j++){
                map[i][j] = s.charAt(j);
                if(map[i][j]=='C'){
                    if(!f) {
                        q.add(new Point(i,j,0,0));
                        q.add(new Point(i,j,0,1));
                        q.add(new Point(i,j,0,2));
                        q.add(new Point(i,j,0,3));
                        visited[i][j] = -1;
                        f = true;
                    }else {
                        endX = i; endY = j;
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;

        while(!q.isEmpty()){
            Point cur = q.poll();

            for(int d=0;d<4;d++){
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                while(true){
                    if(nx<0||ny<0||nx>=H||ny>=W)break;
                    if(map[nx][ny]=='*')break;
                    if(visited[nx][ny] == Integer.MAX_VALUE){
                        visited[nx][ny] = visited[cur.x][cur.y] + 1;
                        q.add(new Point(nx, ny, cur.cnt +1, cur.dir));
                    }
                    nx += dx[d];
                    ny += dy[d];
                }

            }

        }
        System.out.println(visited[endX][endY]);

    }

    private static class Point {
        int x,y,cnt,dir;

        public Point(int x, int y, int cnt, int dir) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.dir = dir;
        }
    }
}
