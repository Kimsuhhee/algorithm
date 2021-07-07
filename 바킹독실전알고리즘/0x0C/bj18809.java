import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj18809 {
    static int N,M,G,R;
    static int flower;
    static int Max = Integer.MIN_VALUE;
    static int[][] garden;
    static dist[][] state;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[] red;
    static int[] green;
    static boolean[] visited;
    static Queue<Point> q = new LinkedList<>();
    static ArrayList<Point>possible = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        G = Integer.parseInt(stk.nextToken());
        R = Integer.parseInt(stk.nextToken());

        garden = new int[N][M];

        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                garden[i][j] = Integer.parseInt(stk.nextToken());
                if(garden[i][j]==2){
                    possible.add(new Point(i,j));
                    garden[i][j] = 1;
                }
            }
        }

        red = new int[R];
        green = new int[G];
        visited = new boolean[possible.size()];

        permutation_green(0,0);
        //배양액을 뿌릴수 있는 조합
        //해당 조합으로 bfs(배양액을 뿌려서 꽃을 피워 꽃의 최대 개수 구하기)
        System.out.println(Max);

    }

    private static void permutation_green(int start, int n) {
        if(n==G){
            permutation_red(0,0);
            return;
        }
        for(int i=start;i< possible.size();i++){
            if(!visited[i]){
                visited[i] = true;
                green[n] = i;
                permutation_green(i+1,n+1);
                visited[i] = false;
            }
        }
    }

    private static void permutation_red(int start, int n) {
        if(n==R){
            Max = Math.max(Max,bfs());
            return;
        }
        for(int i=start;i< possible.size();i++){
            if(!visited[i]){
                visited[i] = true;
                red[n] = i;
                permutation_red(i+1,n+1);
                visited[i] = false;
            }
        }
    }


    private static int bfs() {
        setGarden();
        flower = 0;
        while(!q.isEmpty()){
            Point temp = q.poll();
            if(state[temp.x][temp.y].color==-10)continue;
            for(int i=0;i<4;i++){
                int x = temp.x + dx[i];
                int y = temp.y + dy[i];
                if(x<0 || y<0 || x>=N || y>=M)continue;
                //아직 방문을 안했을때
                if(state[x][y].color == 0 && garden[x][y] != 0){
                    state[x][y].time = state[temp.x][temp.y].time+1;
                    state[x][y].color = state[temp.x][temp.y].color;
                    q.add(new Point(x,y));
                }else if(state[x][y].color != -10){
                    //방문한경우
                    if(state[temp.x][temp.y].color != state[x][y].color && state[x][y].time == state[temp.x][temp.y].time+1){
                        state[x][y].color = -10;
                        flower++;
                    }
                }
            }
        }
        return flower;
    }

    private static void setGarden() {
        state = new dist[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                state[i][j] = new dist(0,0);
            }
        }
        for(int i=0;i<green.length;i++) {
            Point temp = possible.get(green[i]);
            state[temp.x][temp.y] = new dist(1,0);
            q.add(new Point(temp.x,temp.y));
        }
        for(int i=0;i<red.length;i++) {
            Point temp = possible.get(red[i]);
            state[temp.x][temp.y] = new dist(2,0);
            q.add(new Point(temp.x,temp.y));
        }
    }

    private static class Point {
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class dist {
        int color, time;

        public dist(int color, int time) {
            this.color = color;
            this.time = time;
        }
    }
}
