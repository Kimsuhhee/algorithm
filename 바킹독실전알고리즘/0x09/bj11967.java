import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj11967 {
    static int n,m;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] room;
    static boolean[][] visited;
    static boolean[][] possible;
    static ArrayList<Point>list[][];
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
        String nm = br.readLine();
        StringTokenizer stk = new StringTokenizer(nm," ");
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        room = new int[n][n];
        visited = new boolean[n][n];
        possible = new boolean[n][n];
        list = new ArrayList[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                list[i][j] = new ArrayList<Point>();
            }
        }

        for(int i=0;i<m;i++){
            stk = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            list[x-1][y-1].add(new Point(a-1,b-1));
        }

        visited[0][0] = true;
        room[0][0] = 1;
        q.add(new Point(0,0));

        int cnt = 1;
        while(!q.isEmpty()){
            Point tmp = q.poll();
            for(int i=0;i<4;i++){ //상하좌우로 움직일수 있는 칸 체크
                int mx = tmp.x+dx[i];
                int my = tmp.y+dy[i];
                if(mx<0||my<0||mx>=n||my>=n)continue;
                possible[mx][my] = true;
            }
            for(int i=0;i<list[tmp.x][tmp.y].size();i++){
                Point next = list[tmp.x][tmp.y].get(i);
                if(room[next.x][next.y]!=1) { //불이 켜져 있지 않다면 불을 킴
                    room[next.x][next.y] = 1;
                    cnt++;
                }
                if(possible[next.x][next.y] && !visited[next.x][next.y]){ //이동할 수 있는 칸인데 방문한적이 없다면 큐에 넣음
                    visited[next.x][next.y] = true;
                    q.add(new Point(next.x, next.y));
                }

            }
            for(int i=0;i<4;i++){
                int mx = tmp.x+dx[i];
                int my = tmp.y+dy[i];
                if(mx<0||my<0||mx>=n||my>=n)continue;
                if(visited[mx][my] || !possible[mx][my] || room[mx][my]==0)continue;
                //이동할 수 있는 칸이 불이 켜져있고 방문한 적이있다면 큐에 넣음
                visited[mx][my] = true;
                q.add(new Point(mx,my));
            }

        }

        System.out.println(cnt);

    }

}
