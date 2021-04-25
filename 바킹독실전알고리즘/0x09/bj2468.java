import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj2468 {
    static int[][] area;
    static int[][] temp;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static Queue<Point>q = new LinkedList<>();
    static int N;

    private static class Point {
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        area = new int[N][N];
        temp = new int[N][N];
        visited = new boolean[N][N];

        int max = 0;
        int min = 101;

        for(int i=0;i<N;i++){
            String s = br.readLine();
            StringTokenizer stk = new StringTokenizer(s," ");
            for(int j=0;j<N;j++){
                area[i][j] = Integer.parseInt(stk.nextToken());
                max = Math.max(max,area[i][j]);
                min = Math.min(min,area[i][j]);
            }
        }

        ArrayList list = new ArrayList();
        if (max==min && max==1){
            System.out.println(1);
            return;
        }
        for(int h=min;h<max+1;h++){

            for(int i[]:temp) Arrays.fill(i,0);
            for(boolean i[]:visited) Arrays.fill(i,false);
            q.clear();

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(area[i][j]<=h){
                        temp[i][j] = -1;
                    }
                }
            }

            int cnt = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(temp[i][j]!=-1 && !visited[i][j]){
                        q.add(new Point(i,j));
                        visited[i][j] = true;
                        cnt++;
                        bfs();
                    }
                }
            }
            list.add(cnt);
        }
        Collections.sort(list,Collections.reverseOrder());
        System.out.println(list.get(0));

    }

    private static void bfs() {
        while(!q.isEmpty()){
            Point tmp = q.poll();
            for(int i=0;i<4;i++){
                int mx = tmp.x+dx[i];
                int my = tmp.y+dy[i];
                if(mx<0 ||my<0 || mx>=N|| my>=N)continue;
                if(temp[mx][my]!=-1 && !visited[mx][my]){
                    q.add(new Point(mx,my));
                    visited[mx][my] = true;
                }
            }
        }
    }
}
