import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2589 {
    static int w,l;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static char[][] area;
    static int[][] dist;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        w = Integer.parseInt(stk.nextToken());
        l = Integer.parseInt(stk.nextToken());
        area = new char[w][l];
        Queue<Point>q = new LinkedList<>();

        for(int i=0;i<w;i++){
            String s = br.readLine();
            for(int j=0;j<l;j++){
                area[i][j] = s.charAt(j);
            }
        }
        for(int i=0;i<w;i++){
            for(int j=0;j<l;j++){
                if(area[i][j]=='L'){
                    q.add(new Point(i,j));
                    dist = new int[w][l];
                    dist[i][j] = 1;
                    while(!q.isEmpty()){
                        Point p = q.poll();
                        for(int d=0;d<4;d++){
                            int mx = p.x + dx[d];
                            int my = p.y + dy[d];
                            if(mx<0||my<0||mx>=w||my>=l)continue;
                            if(dist[mx][my]==0&&area[mx][my]=='L') {
                                dist[mx][my] += dist[p.x][p.y] + 1;
                                q.add(new Point(mx,my));
                            }
                        }
                    }
                    max = Math.max(findMax(dist)-1,max);
                }
            }
        }
        System.out.println(max);

    }

    private static int findMax(int[][] dist) {
        int max = 0;
        for(int i=0;i<w;i++){
            for(int j=0;j<l;j++){
                if(dist[i][j]==0)continue;
                max = Math.max(max,dist[i][j]);
            }
        }
        return max;
    }

    private static class Point {
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
